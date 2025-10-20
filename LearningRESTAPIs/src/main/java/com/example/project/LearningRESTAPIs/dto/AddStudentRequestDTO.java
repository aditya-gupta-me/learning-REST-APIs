package com.example.project.LearningRESTAPIs.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AddStudentRequestDTO {
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 30, message = "Name should be between 3 to 30 characters!")
    private String name;

    @Email
    @NotBlank(message = "Email required")
    private String email;
}
