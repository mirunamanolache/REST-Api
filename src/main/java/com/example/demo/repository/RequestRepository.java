package com.example.demo.repository;

import com.example.demo.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository  extends JpaRepository<Request,Integer> {

    public List<Request> findAll();
    public List<Request> findAllByStudentId(Integer id);
    @Modifying
    @Query(
            value = "UPDATE REQUEST set COURSE_NAME = :name where id =:id" ,
            nativeQuery = true)
    public void updateCourseName(@Param("id") Integer courseId, String name);
}
