package com.example.demo.repository;


import com.example.demo.dtos.StudentDto;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    public List<StudentDto> getAllStudents(){
        List<StudentDto> result=new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:mem::memDb", "sa","");
            String request="select * from STUDENT";
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id=resultSet.getInt(1);
                String firstname=resultSet.getString(2);
                String lastname=resultSet.getString(3);
                StudentDto studentDto=new StudentDto(id,firstname,lastname);
                result.add(studentDto);
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Object addStudent(StudentDto studentDto){
        Object result=null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:mem::memDb", "sa","");
            String request="insert into STUDENT(id,firstname,lastname) values (?,?,?)";
            PreparedStatement preparedStatement= connection.prepareStatement(request);
            preparedStatement.setInt(1,IncrementStudent.getCount());
            preparedStatement.setString(2,studentDto.getFirstname());
            preparedStatement.setString(3,studentDto.getLastname());
            result=preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
