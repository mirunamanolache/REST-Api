package com.example.demo.repository;

public class IncrementCourse {

    private static Integer count=0;

    public static Integer getCount() {
        count++;
        return count;
    }

}
