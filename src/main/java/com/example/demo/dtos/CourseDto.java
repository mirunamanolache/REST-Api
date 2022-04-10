package com.example.demo.dtos;

public class CourseDto {

    private Integer id;
    private String name;
    private String teacherName;
    private Integer credits;

    public CourseDto(Integer id, String name, String teacherName, Integer credits) {
        this.id = id;
        this.name = name;
        this.teacherName = teacherName;
        this.credits = credits;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }
}
