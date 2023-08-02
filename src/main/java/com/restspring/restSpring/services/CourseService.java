package com.restspring.restSpring.services;

import com.restspring.restSpring.entities.Course;

import java.util.List;

public interface CourseService {

    public List<Course> getCourses();
    public Course getCourse(long courseId);
    public Course addCourse(Course course);
    public String deleteCourse(long courseId);
    public List<Course> updateCourse(Course course);
}
