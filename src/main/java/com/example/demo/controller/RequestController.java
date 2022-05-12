package com.example.demo.controller;

import com.example.demo.dtos.RequestDto;
import com.example.demo.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class RequestController {

    @Autowired
    RequestService requestService;

    @GetMapping(value="/allRequests")
    public List<RequestDto> getAllCourses() {
        return requestService.getAllRequests();
    }

    @PostMapping(value="/newRequest/student/{studentId}/course/{courseId}")
    public ResponseEntity<RequestDto> addStudent(@PathVariable Integer studentId, @PathVariable Integer courseId){
        RequestDto addedRequest=requestService.addRequest(studentId,courseId);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedRequest);
    }

    @GetMapping(value="/allRequests/{studentId}")
    public List<RequestDto> getAllCourses(@PathVariable Integer studentId) {
        return requestService.getAllRequestByStudentId(studentId);
    }

    @DeleteMapping(value="/delete/{requestId}")
    public ResponseEntity<String> deleteRequest(@PathVariable Integer requestId){
        requestService.deleteRequest(requestId);
        return ResponseEntity.ok("Request with id "+requestId+ " was successfully deleted");
    }

}
