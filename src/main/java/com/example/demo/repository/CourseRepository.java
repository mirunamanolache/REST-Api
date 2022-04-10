package com.example.demo.repository;

import com.example.demo.dtos.CourseDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {

    @PersistenceContext
    public EntityManager em;

    public Object addCourse(CourseDto courseDto){
        Object result=null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:mem::memDb", "sa","");
            String request="insert into COURSE(id,name,teacherName,credits) values (?,?,?,?)";
             PreparedStatement preparedStatement= connection.prepareStatement(request);
             preparedStatement.setInt(1,IncrementCourse.getCount());
             preparedStatement.setString(2,courseDto.getName());
             preparedStatement.setString(3,courseDto.getTeacherName());
             preparedStatement.setInt(4,courseDto.getCredits());
                    result=preparedStatement.execute();
                    connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

         return result;
    }

    public List<CourseDto> getAllCourses(){
        List<CourseDto> result=new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:mem::memDb", "sa","");
            String request="select * from COURSE";
            PreparedStatement preparedStatement=connection.prepareStatement(request);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Integer id=resultSet.getInt(1);
                String name=resultSet.getString(2);
                String teacherName=resultSet.getString(3);
                Integer credits=resultSet.getInt(4);
                CourseDto courseDto=new CourseDto(id,name,teacherName,credits);
                result.add(courseDto);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<CourseDto> getAllCoursesByTeacherName(String teacherName){

        List<CourseDto> result=new ArrayList<>();
        try {
            Connection connection=DriverManager.getConnection("jdbc:h2:mem::memDb", "sa","");
            String request="select * from COURSE where TEACHERNAME = ?";
            PreparedStatement preparedStatement=connection.prepareStatement(request);
            preparedStatement.setString(1,teacherName);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Integer id=resultSet.getInt(1);
                String name=resultSet.getString(2);
                String teacher=resultSet.getString(3);
                Integer credits=resultSet.getInt(4);

                CourseDto courseDto=new CourseDto(id,name,teacher,credits);
                result.add(courseDto);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<CourseDto> getAllCoursesByStudent(Integer studentId){

        List<CourseDto> result=new ArrayList<>();
        try {
            Connection connection=DriverManager.getConnection("jdbc:h2:mem::memDb", "sa","");
            String request="select * from COURSE inner join STUDENT_COURSE on COURSE.id=STUDENT_COURSE.idCourse where STUDENT_COURSE.idStudent=?";
            PreparedStatement preparedStatement=connection.prepareStatement(request);
            preparedStatement.setInt(1,studentId);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Integer id=resultSet.getInt(1);
                String name=resultSet.getString(2);
                String teacher=resultSet.getString(3);
                Integer credits=resultSet.getInt(4);

                CourseDto courseDto=new CourseDto(id,name,teacher,credits);
                result.add(courseDto);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Object addCourseToStudent(Integer studentId, Integer courseId){
        Object result=null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:mem::memDb", "sa","");
            String request="insert into STUDENT_COURSE(idStudent,idCourse) values (?,?)";
            PreparedStatement preparedStatement= connection.prepareStatement(request);
            preparedStatement.setInt(1,studentId);
            preparedStatement.setInt(2,courseId);
            result=preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public Object updateCourseName(Integer courseId, String name){

        Object result=null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:mem::memDb", "sa","");
            String request="update COURSE set name= ? where id = ?";
            PreparedStatement preparedStatement= connection.prepareStatement(request);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,courseId);
            result=preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public Object deleteCourse(Integer courseId){

        Object result=null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:mem::memDb", "sa","");
            String request="delete from  COURSE  where id = ?";
            PreparedStatement preparedStatement= connection.prepareStatement(request);
            preparedStatement.setInt(1,courseId);
            result=preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
