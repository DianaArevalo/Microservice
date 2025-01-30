package com.microservice.teacher.service;

import com.microservice.teacher.entities.Teacher;

import java.util.List;

public interface ITeacherService {

    List<Teacher> findAll();
    Teacher findById(Long id);
    void save(Teacher teacher);
    //encontrar profe por curso
    List<Teacher> findByIdCourse(Long idCourse);
}
