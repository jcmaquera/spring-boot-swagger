package com.example.springbootswagger.service;

import com.example.springbootswagger.entity.Course;
import com.example.springbootswagger.entity.Student;
import com.example.springbootswagger.repository.CourseRepository;
import com.example.springbootswagger.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Student addStudent(Student Student) {
        return studentRepository.save(Student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getById(Long id){
        return studentRepository.findById(id);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public Student updateById(long id, Student Student) {
        Student.setStudentId(id);
        return studentRepository.save(Student);
    }

    public Student enroll(Long id, Course course) {
        Student student=studentRepository.findById(id).get();
        student.getCourses().add(courseRepository.findById(course.getCourseId()).get());
        studentRepository.save(student);
        return student;
    }
    public Student drop(Long id, Course course) {
        Student student=studentRepository.findById(id).get();
        student.getCourses().remove(courseRepository.findById(course.getCourseId()).get());
        studentRepository.save(student);
        return student;
    }
}