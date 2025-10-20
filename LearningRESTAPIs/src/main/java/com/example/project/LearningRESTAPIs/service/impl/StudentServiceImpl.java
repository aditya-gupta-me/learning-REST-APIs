package com.example.project.LearningRESTAPIs.service.impl;

import com.example.project.LearningRESTAPIs.dto.AddStudentRequestDTO;
import com.example.project.LearningRESTAPIs.dto.StudentDTO;
import com.example.project.LearningRESTAPIs.entity.Student;
import com.example.project.LearningRESTAPIs.repository.StudentRepository;
import com.example.project.LearningRESTAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<StudentDTO> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        return students
                .stream()
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .toList();
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not " +
                "found " +
                "with " +
                "ID: " + id));
        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public StudentDTO createNewStudent(AddStudentRequestDTO addStudentRequestDTO) {
        Student newStudent = modelMapper.map(addStudentRequestDTO, Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDTO.class);
    }
}
