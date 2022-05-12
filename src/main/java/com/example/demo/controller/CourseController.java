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


    @PostMapping(value="/newCourse")
    public ResponseEntity<CourseDto> addStudent(@RequestBody CourseDto courseDto){
        CourseDto addedCourseDto=courseService.addCourse(courseDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedCourseDto);
    }

    @GetMapping(value="/allCoursesByTeacher")
    public List<CourseDto> getAllCoursesByUserId(@RequestParam String teacherName){
        return courseService.getAllCoursesByTeacherName(teacherName);
    }

    @PutMapping(value = "/course/{id}/name/{name}")
    public ResponseEntity<CourseDto> updateCourseName(@PathVariable Integer id, @PathVariable String name){
        CourseDto result= courseService.updateCourseName(id,name);
        return ResponseEntity.ok().body(result);
    }

}
