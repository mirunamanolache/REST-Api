package com.example.demo.repository;

import com.example.demo.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

    public List<Course> findAll();
    public List<Course> findAllByTeacherName(String teacherName);

}
