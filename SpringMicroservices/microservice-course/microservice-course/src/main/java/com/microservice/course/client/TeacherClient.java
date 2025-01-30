package com.microservice.course.client;

import com.microservice.course.dto.TeacherDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-teacher", url = "localhost:8082/api/teacher")
public interface TeacherClient {

    @GetMapping("/search-by-course/{idCourse}")
    List<TeacherDto> findTeachersByIdCourse(@PathVariable("idCourse") Long idCourse);


}
