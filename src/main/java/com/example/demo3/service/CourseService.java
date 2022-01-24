package com.example.demo3.service;

import com.example.demo3.model.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getCourses();
    public Course getCourse(long id);
    public Course addCourse(Course course);
    public boolean deleteCourse(long id);
}
