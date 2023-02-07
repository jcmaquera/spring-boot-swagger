package com.example.springbootswagger.service;

import com.example.springbootswagger.entity.Course;
import com.example.springbootswagger.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public String addCourse(String name, String description) {

        Course Course = new Course();
        Course.setName(name);
        Course.setDescription(description);
        courseRepository.save(Course);
        return "Added";
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> findCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }
    public Course updateCourse(long id, Course Course) {
        Course.setCourseId(id);
        return courseRepository.save(Course);
    }
}