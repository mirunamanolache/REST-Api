package com.example.demo.dtos;

public class StudentDto {

    private Integer id;
    private String firstname;
    private String lastname;

    public StudentDto(Integer id,String firstname, String lastname) {
        this.id=id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public StudentDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
