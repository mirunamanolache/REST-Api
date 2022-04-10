package com.example.demo.services;

import com.example.demo.dtos.CourseDto;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public Object addCourse(CourseDto courseDto){
       return courseRepository.addCourse(courseDto);
    }

    public List<CourseDto> getAllCourses(){
        return courseRepository.getAllCourses();
    }

    public List<CourseDto> getAllCoursesByTeacherName(String teacherName){
        return courseRepository.getAllCoursesByTeacherName(teacherName);
    }

    public List<CourseDto> getAllCoursesByStudent(Integer studentId){
        return courseRepository.getAllCoursesByStudent(studentId);
    }

    public Object addCourseToStudent(Integer studentId, Integer courseId){
        return courseRepository.addCourseToStudent(studentId,courseId);
    }

    public Object updateCourseName(Integer courseId, String name){
        return courseRepository.updateCourseName(courseId,name);
    }

    public Object deleteCourse(Integer courseId){
        return courseRepository.deleteCourse(courseId);
    }

}
