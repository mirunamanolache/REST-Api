package com.example.demo.mapper;

import com.example.demo.dtos.StudentDto;
import com.example.demo.entities.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class StudentMapper {

    public static Student toEntity(StudentDto studentDto){
        Student student=new Student();
        student.setFirstname(studentDto.getFirstname());
        student.setLastname(studentDto.getLastname());
        return student;
    }

    public static StudentDto toDto(Student student){
        StudentDto studentDto=new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstname(student.getFirstname());
        studentDto.setLastname(student.getLastname());
        return studentDto;
    }

    public static List<StudentDto> toDtoList(List<Student> studentList){
        List<StudentDto> studentDtoList=new ArrayList<>();
        Iterator<Student> it = studentList.iterator();
        while(it.hasNext()){
            StudentDto s=toDto(it.next());
            studentDtoList.add(s);
        }
        return studentDtoList;
    }
    public static List<Student> toEntityList(List<StudentDto> studentDtoList){
        List<Student> studentList=new ArrayList<>();
        Iterator<StudentDto> it = studentDtoList.iterator();
        while(it.hasNext()){
            Student s=toEntity(it.next());
            studentList.add(s);
        }
        return studentList;
    }

}
