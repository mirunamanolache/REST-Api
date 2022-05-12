package com.example.demo.mapper;

import com.example.demo.dtos.CourseDto;
import com.example.demo.entities.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class CourseMapper {

    public static Course toEntity(CourseDto courseDto){
        Course course=new Course();
        course.setName(courseDto.getName());
        course.setTeacherName(courseDto.getTeacherName());
        course.setCredits(courseDto.getCredits());
        return course;
    }

    public static CourseDto toDto(Course course){
        CourseDto courseDto=new CourseDto();
        courseDto.setId(course.getId());
        courseDto.setName(course.getName());
        courseDto.setTeacherName(course.getTeacherName());
        courseDto.setCredits(course.getCredits());
        return courseDto;
    }

    public static List<Course> toListEntity(List<CourseDto> courseDtos){
        List<Course> courses=new ArrayList<>();
        Iterator<CourseDto> it=courseDtos.iterator();
        while(it.hasNext()){
            Course course=CourseMapper.toEntity(it.next());
            courses.add(course);
        }
        return courses;
    }

    public static List<CourseDto> toListDto(List<Course> courses){
        List<CourseDto> courseDtos=new ArrayList<>();
        Iterator<Course> it=courses.iterator();
        while(it.hasNext()){
            CourseDto course=CourseMapper.toDto(it.next());
            courseDtos.add(course);
        }
        return courseDtos;
    }
}
