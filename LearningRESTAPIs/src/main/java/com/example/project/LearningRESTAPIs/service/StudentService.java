package com.example.project.LearningRESTAPIs.service;

import com.example.project.LearningRESTAPIs.dto.AddStudentRequestDTO;
import com.example.project.LearningRESTAPIs.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudent();

    StudentDTO getStudentById(Long id);

    StudentDTO createNewStudent(AddStudentRequestDTO addStudentRequestDTO);
}
