package com.restspring.restSpring.services;

import com.restspring.restSpring.dao.CourseDao;
import com.restspring.restSpring.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;

//    List<Course> courses;

    public CourseServiceImpl() {
//        courses = new ArrayList<>();
//        courses.add(new Course("java core course", 456, "this course is for java core learner"));
//        courses.add(new Course("python course", 78, "this course is for python learner"));
    }

    @Override
    public List<Course> getCourses() {

        return this.courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {
        Course course = null;
        try {
            course = this.courseDao.getReferenceById(courseId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        for (Course course : courses) {
//            if (course.getCourseId() == courseId) {
//                return course;
//            }
//        }
//        return null;
        return course;
    }

    @Override
    public Course addCourse(Course course) {
        try {
            this.courseDao.save(course);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        courses.add(course);
       return course;
    }

    @Override
    public String deleteCourse(long courseId) {
        Course course = this.courseDao.getOne(courseId);
        this.courseDao.delete(course);
//        courses = courses.stream().filter(x -> x.getCourseId() != courseId).collect(Collectors.toList());
        return "delete succesfully";
    }

    @Override
    public List<Course> updateCourse(Course course) {
        this.courseDao.save(course);
        return this.courseDao.findAll();
//        courses.forEach(e ->
//        {
//            if (e.getCourseId() == course.getCourseId()) {
//                e.setCourseName(course.getCourseName());
//                e.setCourseDescription(course.getCourseDescription());
//            }
//        });
//
//        return courses;
    }
}
