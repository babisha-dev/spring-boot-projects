package com.example.Registration.CollegeRegistration.Controller;

import com.example.Registration.CollegeRegistration.Model.Subject;
import com.example.Registration.CollegeRegistration.Service.SubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SubjectController {
    private SubjectService subjectService;
    public SubjectController(SubjectService subjectService){
        this.subjectService=subjectService;
    }
    @PostMapping("/subjects")
    public ResponseEntity<Subject> addSubject(@RequestBody Subject subject){
        return ResponseEntity.status(201).body(subjectService.addSubject(subject));
    }
}
