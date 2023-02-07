package com.example.springbootswagger.controller;

import com.example.springbootswagger.entity.Course;
import com.example.springbootswagger.entity.Student;
import com.example.springbootswagger.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping(path ="/addStudent")
    public Student addStudent(@RequestBody Student Student){
        return studentService.addStudent(Student);
    }

    @GetMapping(path = "/getAllStudents")
    public @ResponseBody List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/getById/{id}")
    public Optional<Student> getById(@PathVariable Long id){
        return studentService.getById(id);
    }

    @DeleteMapping(path = "/deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        studentService.deleteById(id);
    }

    @PutMapping(path = "/updateById/{id}")
    public Student updateById(@PathVariable Long id, @RequestBody Student Student){
        Student.setStudentId(id);
        return studentService.updateById(id, Student);
    }
    @PutMapping("/enroll/{id}")
    public Student enroll(@PathVariable("id") Long id, @RequestBody Course course) {
        return studentService.enroll(id, course);
    }
    @DeleteMapping("/drop/{id}")
    public Student drop(@PathVariable("id") Long id, @RequestBody Course course) {
        studentService.drop(id, course);
        return studentService.drop(id,course);
    }

}