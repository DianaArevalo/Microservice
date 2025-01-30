package com.microservice.course.service;

import com.microservice.course.client.StudentClient;
import com.microservice.course.client.TeacherClient;
import com.microservice.course.dto.StudentDto;
import com.microservice.course.dto.TeacherDto;
import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.http.response.TeacherByCourseResponse;
import com.microservice.course.persistence.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private ICourseRepository courseRepository;

    @Autowired
    private StudentClient studentClient;

    @Autowired
    private TeacherClient teacherClient;

    @Override
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
         courseRepository.save(course);
    }

    @Override
    public StudentByCourseResponse findStudentsByIdCourse(Long idCourse) {
        Course course = courseRepository.findById(idCourse).orElse(new Course());
        List<StudentDto> studentDtoList = studentClient.findAllStudentByCourse(idCourse);


        return StudentByCourseResponse.builder()
                .courseName(course.getName())
              //  .teacher()
                .studentDtoList(studentDtoList)
                .build();
    }

    @Override
    public TeacherByCourseResponse findTeachersByIdCourse(Long idCourse) {

        //consultar el curso
        Course course = courseRepository.findById(idCourse).orElseThrow(() ->
                new RuntimeException("Course not found with id" + idCourse)
        );

//        //llamar al cliente de Feign para obtener los datos del profesor
       TeacherDto teacherDto = (TeacherDto) teacherClient.findTeachersByIdCourse(idCourse);
//
//
        return TeacherByCourseResponse.builder()
                .courseName(course.getName())
                .teacherDto(teacherDto)
                .id(teacherDto)
                .build();
    }


    }



