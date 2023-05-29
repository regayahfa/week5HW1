package com.example.week5hw1.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeacherDTO {
    private Integer id;
    private String name;
    private String email;
}
