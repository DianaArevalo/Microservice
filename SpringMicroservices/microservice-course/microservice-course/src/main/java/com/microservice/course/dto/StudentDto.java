package com.microservice.course.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class StudentDto {

    private String name;
    private String lastname;
    private String email;
    private Long idCourse;
}
