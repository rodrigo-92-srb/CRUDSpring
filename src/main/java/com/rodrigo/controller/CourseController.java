package com.rodrigo.controller;

import com.rodrigo.model.Course;
import com.rodrigo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/courses")

public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<Course> list(){
        return courseRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course course){
        return ResponseEntity.status(HttpStatus.CREATED).body(courseRepository.save(course));
    }


}
