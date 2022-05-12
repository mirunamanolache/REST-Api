package com.example.demo.services;


import com.example.demo.dtos.StudentDto;
import com.example.demo.entities.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDto> getAllStudents(){
        List<Student> students= studentRepository.findAll();
        List<StudentDto> studentDtoList=StudentMapper.toDtoList(students);
        return studentDtoList;
    }

    public StudentDto addStudent(StudentDto studentDto){
        Student student = StudentMapper.toEntity(studentDto);
        StudentDto studentDto1= StudentMapper.toDto(studentRepository.save(student));
        return studentDto1;
    }
}
