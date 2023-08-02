package com.restspring.restSpring.controller;

import com.restspring.restSpring.entities.Course;
import com.restspring.restSpring.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String home() {
        return "this is a home page";
    }

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return this.courseService.getCourses();
    }

    @GetMapping("/course/{courseId}")
    public Course getCourse(@PathVariable String courseId) {
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    @PostMapping("/course")
    public Course getCourse(@RequestBody Course course) {
        this.courseService.addCourse(course);
        return course;
    }

    @PutMapping("/courses")
    public List<Course> updateCourse(@RequestBody Course course) {
        return this.courseService.updateCourse(course);
    }

    @DeleteMapping("/course/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
        try {
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
