package com.microservice.course.http.response;


import com.microservice.course.dto.TeacherDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherByCourseResponse {

    private String courseName;
    private Long idCourse;
    private TeacherDto teacherDto;
    private TeacherDto id;

}
