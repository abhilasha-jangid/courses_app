package com.restspring.restSpring.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Course {

    @Id
    private long courseId;
    @Column
    private String courseName;
    @Column
    private String courseDescription;

    public Course() {
    }

    public Course(String courseName, long courseId, String courseDescription) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.courseDescription = courseDescription;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }
}
