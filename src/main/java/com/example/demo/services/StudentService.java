package com.example.demo.services;


import com.example.demo.dtos.StudentDto;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<StudentDto> getAllStudents(){
        return studentRepository.getAllStudents();
    }

    public Object addStudent(StudentDto studentDto){
        return studentRepository.addStudent(studentDto);
    }
}
