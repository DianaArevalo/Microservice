package com.microservice.course.dto;



import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private List <Long> idCourse;
}
