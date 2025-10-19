package com.example.project.LearningRESTAPIs.controller;

import com.example.project.LearningRESTAPIs.dto.StudentDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//to create bean we use -> @RestController
//RestController is made from two controller annotations
//-Controller is used to make it Controller and helps in handler mapping
//-ResponseBody is used to return the response in JSON format
@RestController
public class StudentController {
//    used to create a mapping i.e. creating a 'get' request mapper

    @GetMapping("/students")
    public StudentDTO getStudent(){
        return new StudentDTO(1L, "Charles Babbage", "charles@example.com");
    }
}
