package com.example.demo3.service;

import com.example.demo3.dao.CourseDao;
import com.example.demo3.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("fir")
public class FirstCourseService implements CourseService{

    @Autowired
    private CourseDao courseDao;


    public FirstCourseService() {
        System.out.println("First Course Service has been initialised");
    }

    @Override
    public List<Course> getCourses() {
        System.out.println("First Service is fetching all the courses");
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long id) {
        System.out.println("First Service is fetching the course");
        Optional<Course> optionalCourse= courseDao.findById(id);
        if(optionalCourse.isPresent()) {
            return optionalCourse.get();
        }
        return null;
    }

    @Override
    public Course addCourse(Course course) {
        System.out.println("First Service is adding the course");
        courseDao.save(course);
        return course;
    }

    @Override
    public boolean deleteCourse(long id) {
        System.out.println("First Service is deleting the course");
        if(courseDao.findById(id) == null) return false;
        courseDao.deleteById(id);
        return true;
    }
}
