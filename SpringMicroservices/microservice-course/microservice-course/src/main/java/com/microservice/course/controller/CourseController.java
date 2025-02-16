package com.microservice.course.controller;

import com.microservice.course.dto.TeacherDto;
import com.microservice.course.entities.Course;
import com.microservice.course.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @PostMapping("/create/")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCourse(@RequestBody Course course){
        courseService.save(course);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllCourses(){
        return ResponseEntity.ok(courseService.findAll());

    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        return ResponseEntity.ok(courseService.findById(id));
    }

    @GetMapping("/search-student/{idCourse}")
    public ResponseEntity<?> findStudentsByIdCourse(@PathVariable Long idCourse){
        return ResponseEntity.ok(courseService.findStudentsByIdCourse (idCourse));
    }

    @GetMapping("/search-teacher/{idCourse}")
    public  ResponseEntity<?> findTeachersByIdCourse(@PathVariable Long idCourse){
        return ResponseEntity.ok(courseService.findTeachersByIdCourse(idCourse));
    }

}
