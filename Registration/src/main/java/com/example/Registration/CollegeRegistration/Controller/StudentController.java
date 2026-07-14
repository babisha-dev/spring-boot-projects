package com.example.Registration.CollegeRegistration.Controller;

import com.example.Registration.CollegeRegistration.Model.Student;
import com.example.Registration.CollegeRegistration.Service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import  java.util.List;
@RestController
@RequestMapping("/api")
@Tag(
        name ="Student Management",
        description = "APIs to manage student records"
)
public class StudentController {
    @Autowired
    StudentService studentService;

   @Operation(summary = "create a new student")
    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(student));
    }
    @Operation(summary = "Retrieve students by their ID")
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id){
        return ResponseEntity.ok(studentService.getStudent(id));
    }

    @Operation(summary="Get all Students bu their category", description = "return a list of students based on their category")
    @ApiResponses(value={
            @ApiResponse(responseCode="200",
                         description = "successfully retrieved"),
            @ApiResponse(responseCode = "500",
                         description = "Internal Server Error")
    })
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getByCategory(@RequestParam String category){
        return ResponseEntity.ok(studentService.findByCategory(category));
    }
}
