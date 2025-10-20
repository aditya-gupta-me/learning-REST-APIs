package com.example.project.LearningRESTAPIs.controller;

import com.example.project.LearningRESTAPIs.dto.AddStudentRequestDTO;
import com.example.project.LearningRESTAPIs.dto.StudentDTO;
import com.example.project.LearningRESTAPIs.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity<StudentDTO> createNewStudent(@RequestBody @Valid AddStudentRequestDTO addStudentRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody AddStudentRequestDTO addStudentRequestDTO){
        return ResponseEntity.ok((studentService.updateStudent(id, addStudentRequestDTO)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentDTO> updatePartialStudent(@PathVariable Long id,
                                                     @RequestBody Map<String, Object> updates){
        return ResponseEntity.ok((studentService.updatePartialStudent(id, updates)));
    }
}
