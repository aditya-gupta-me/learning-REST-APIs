package com.example.project.LearningRESTAPIs.service;

import com.example.project.LearningRESTAPIs.dto.AddStudentRequestDTO;
import com.example.project.LearningRESTAPIs.dto.StudentDTO;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentDTO> getAllStudent();

    StudentDTO getStudentById(Long id);

    StudentDTO createNewStudent(AddStudentRequestDTO addStudentRequestDTO);

    void deleteStudentById(Long id);

    StudentDTO updateStudent(Long id, AddStudentRequestDTO addStudentRequestDTO);

    StudentDTO updatePartialStudent(Long id, Map<String, Object> updates);
}
