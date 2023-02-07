package com.example.springbootswagger.controller;

import com.example.springbootswagger.entity.Course;
import com.example.springbootswagger.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping(path = "/addCourse")
    public @ResponseBody String addCourse(@RequestParam String name, @RequestParam String description){
        return courseService.addCourse(name, description);
    }
    
    @GetMapping(path = "/getAllCourses")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }
    
    @GetMapping(path= "/getCourseById/{id}")
    public Optional<Course> getCourseById(@PathVariable Long id){
        return courseService.findCourseById(id);
    }
    
    @DeleteMapping(path = "/deleteCourse/{id}")
    public void deleteCourseById(@PathVariable Long id){
        courseService.deleteCourseById(id);
    }
    
    @PutMapping(path = "/updateCourse/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course Course){
        Course.setCourseId(id);
        return courseService.updateCourse(id, Course);
    }
    
}