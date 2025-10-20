package com.example.project.LearningRESTAPIs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AddStudentRequestDTO {
    private String name;
    private String email;
}
