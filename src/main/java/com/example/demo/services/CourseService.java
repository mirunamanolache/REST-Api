package com.example.demo.services;

import com.example.demo.dtos.CourseDto;
import com.example.demo.entities.Course;
import com.example.demo.exception.CustomException;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    RequestRepository requestRepository;

    public CourseDto addCourse(CourseDto courseDto){
        if(courseDto.getId()!=null)throw new CustomException(HttpStatus.EXPECTATION_FAILED,"New request should not have an ID");
        Course course= CourseMapper.toEntity(courseDto);
        Course savedCourse= courseRepository.save(course);
        CourseDto newCourseDto=CourseMapper.toDto(savedCourse);
        return  newCourseDto;
    }

    public List<CourseDto> getAllCourses(){
        List<Course> courses= courseRepository.findAll();
        return CourseMapper.toListDto(courses);
    }

    public List<CourseDto> getAllCoursesByTeacherName(String teacherName){
        List<Course> courses=courseRepository.findAllByTeacherName(teacherName);
        return CourseMapper.toListDto(courses);
    }

    @Transactional
    public CourseDto updateCourseName(Integer courseId, String name){
        Optional<Course> existingCourse=courseRepository.findById(courseId);
        existingCourse.orElseThrow( () -> new CustomException(HttpStatus.NOT_FOUND,"Course with id: "+courseId+" not found"));
        Course courseEntity=existingCourse.get();
        courseEntity.setName(name);
        Course updatedEntityCourse=this.courseRepository.save(courseEntity);
        this.updateCourse(courseId,name);
        CourseDto dto=CourseMapper.toDto(updatedEntityCourse);
        return  dto;
    }

    private void updateCourse(Integer id, String name){
        this.requestRepository.updateCourseName(id,name);
    }


}
