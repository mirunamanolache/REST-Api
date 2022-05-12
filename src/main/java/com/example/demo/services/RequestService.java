package com.example.demo.services;

import com.example.demo.dtos.CourseDto;
import com.example.demo.dtos.RequestDto;
import com.example.demo.entities.Course;
import com.example.demo.entities.Request;
import com.example.demo.entities.Student;
import com.example.demo.exception.CustomException;
import com.example.demo.mapper.RequestMapper;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.RequestRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;


    public RequestDto addRequest(Integer studentId, Integer courseId){
        Request request= new Request();
        Optional<Student> student=studentRepository.findById(studentId);
        Optional<Course> course=courseRepository.findById(courseId);
        student.orElseThrow(() ->new CustomException(HttpStatus.NOT_FOUND,"Student with id:"+studentId+" not found"));
        course.orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND,"Course with id:"+courseId+" not found"));

        request.setStudent(student.get());
        String fullName=student.get().getFirstname()+" "+student.get().getLastname();
        request.setStudentName(fullName);
        request.setCourseName(course.get().getName());
        request.setCourse(course.get());
        Request savedRequest= requestRepository.save(request);
        RequestDto newRequestDto=RequestMapper.toDto(savedRequest);

        return  newRequestDto;
    }

    public List<RequestDto> getAllRequests(){
        List<Request> requests= requestRepository.findAll();
        return RequestMapper.toListDto(requests);
    }

    public List<RequestDto> getAllRequestByStudentId(Integer id){
        List<Request> requests= requestRepository.findAllByStudentId(id);
        return RequestMapper.toListDto(requests);
    }

    public void deleteRequest(Integer requestId){
        Optional<Request> existingRequest=this.requestRepository.findById(requestId);
        existingRequest.orElseThrow(() -> new RuntimeException("Request not found"));
        requestRepository.delete(existingRequest.get());
    }

}
