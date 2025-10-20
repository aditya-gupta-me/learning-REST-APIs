package com.example.project.LearningRESTAPIs.dto;

//DTO stands for Data Transfer Object
//to put it simple -> it is used to transfer data between layer
//(like from our API controller to the service layer or between our app and the client)
//DTO only contains data, no business logic
//advantages: -Decoupling, -Security, -Flexility, -Validation

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//the below annotation is used to create boilerplate for
//constructor, getters & setters, hashCode etc. methods

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Long id;
    private String name;
    private String email;
}
