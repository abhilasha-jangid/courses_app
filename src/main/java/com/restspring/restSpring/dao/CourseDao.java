package com.restspring.restSpring.dao;

import com.restspring.restSpring.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Long> {
}
