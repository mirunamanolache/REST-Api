package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @OneToOne()
    @JoinColumn( name = "student_id", referencedColumnName = "id",nullable = false)
    private Student student;

    @OneToOne(cascade = CascadeType.DETACH, orphanRemoval = true)
    @JoinColumn( name = "course_id",referencedColumnName = "id",nullable =false)
    private Course course;

    @Column
    private String studentName;
    @Column
    private String courseName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
