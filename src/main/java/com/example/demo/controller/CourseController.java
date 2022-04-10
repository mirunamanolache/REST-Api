package com.example.demo.controller;

import com.example.demo.dtos.CourseDto;
import com.example.demo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping(value="/allCourses")
    public List<CourseDto> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping(value="/allCoursesByTeacher")
    public List<CourseDto> getAllCoursesByUserId(@RequestParam String teacherName){
        return courseService.getAllCoursesByTeacherName(teacherName);
    }

    @PostMapping(value="/newCourse")
    public ResponseEntity<Object> addStudent(@RequestBody CourseDto courseDto){
        Object addedCourseDto=courseService.addCourse(courseDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedCourseDto);
    }

    @GetMapping(value="/allCoursesByStudent/{studentId}")
        public List<CourseDto> getAllCoursesByStudent(@PathVariable Integer studentId){
        return courseService.getAllCoursesByStudent(studentId);
    }

    @PostMapping(value="/courseToStudent/student/{studentId}/course/{courseId}")
    public ResponseEntity<Object> addCourseToStudent(@PathVariable Integer studentId,@PathVariable Integer courseId){
        Object result=courseService.addCourseToStudent(studentId,courseId);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping(value = "/course/{id}/name/{name}")
    public ResponseEntity<Object> updateCourseName(@PathVariable Integer id, @PathVariable String name){
        Object result= courseService.updateCourseName(id,name);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping(value="/delete/{courseId}")
    public ResponseEntity<Object> deleteCourse(@PathVariable Integer courseId){
        courseService.deleteCourse(courseId);
        return ResponseEntity.ok("Course with id "+courseId+ " was successfully deleted");
    }
}
