package com.microservice.teacher.persistence;


import com.microservice.teacher.entities.Teacher;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends CrudRepository <Teacher, Long> {

    // Consulta derivada para buscar profesores por curso
    //List<Teacher> findAllByIdCourses(Long IdCourse);


    @Query("SELECT t FROM Teacher t WHERE t.id = :idCourse")
    List<Teacher> findByIdCourse(Long idCourse);
}
