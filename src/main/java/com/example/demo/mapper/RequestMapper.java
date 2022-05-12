package com.example.demo.mapper;

import com.example.demo.dtos.CourseDto;
import com.example.demo.dtos.RequestDto;
import com.example.demo.entities.Request;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RequestMapper {

    public static Request toEntity(RequestDto requestDto){
        Request request = new Request();
        request.setCourseName(requestDto.getCourseName());
        request.setStudentName(requestDto.getStudentName());
        return request;
    }

    public static RequestDto toDto(Request request){
        RequestDto requestDto = new RequestDto();
        requestDto.setId(request.getId());
        requestDto.setCourseName(request.getCourseName());
        requestDto.setStudentName(request.getStudentName());
        return requestDto;
    }

    public static List<RequestDto> toListDto(List<Request> requests) {
        List<RequestDto> requestDtos=new ArrayList<>();
        Iterator<Request> iterator=requests.iterator();
        while(iterator.hasNext()){
            RequestDto requestDto=toDto(iterator.next());
            requestDtos.add(requestDto);
        }
        return requestDtos;
    }
}
