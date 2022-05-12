package com.example.demo.controller;

import com.example.demo.dtos.StudentDto;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping(value="/allStudents")
    public List<StudentDto> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping(value="/student/{idd}")
    public StudentDto getStudent(@PathVariable("idd") Integer id){
        return new StudentDto();
    }

    @PostMapping(value="/newStudent")
    public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto studentDto){
        StudentDto result=studentService.addStudent(studentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

}
