package com.example.project.LearningRESTAPIs.controller;

import com.example.project.LearningRESTAPIs.dto.AddStudentRequestDTO;
import com.example.project.LearningRESTAPIs.dto.StudentDTO;
import com.example.project.LearningRESTAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//to create bean we use -> @RestController
//RestController is made from two controller annotations
//-Controller is used to make it Controller and helps in handler mapping
//-ResponseBody is used to return the response in JSON format
@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    //    used to create a mapping i.e. creating a 'get' request mapper

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
//        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudent());
        return ResponseEntity.ok(studentService.getAllStudent());
    }


    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createNewStudent(@RequestBody AddStudentRequestDTO addStudentRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDTO));

    }
}
