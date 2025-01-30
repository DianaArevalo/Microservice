package com.microservice.teacher.controller;


import com.microservice.course.dto.TeacherDto;
import com.microservice.teacher.entities.Teacher;
import com.microservice.teacher.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    @Autowired
    private ITeacherService teacherService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveTeacher(@RequestBody Teacher teacher){
        teacherService.save(teacher);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllTeacher(){
        return ResponseEntity.ok(teacherService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(teacherService.findById(id));
    }

    @GetMapping("/search-by-course/{idCourse}")
    public ResponseEntity<?> findByIdCourse (@PathVariable Long idCourse){
        List<Teacher> teachers = teacherService.findByIdCourse(idCourse);
        return ResponseEntity.ok(teachers);
    }

}
