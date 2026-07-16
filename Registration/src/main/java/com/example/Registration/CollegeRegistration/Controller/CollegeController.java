package com.example.Registration.CollegeRegistration.Controller;

import com.example.Registration.CollegeRegistration.Model.College;
import com.example.Registration.CollegeRegistration.Service.CollegeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api")
@Tag(name="college management", description="APIs for creating,retrieval of college records")
public class CollegeController {
    @Autowired
    CollegeService collegeService;
    @PostMapping("/college")
    @Operation(summary = "Add new college", description = "Creates a new college record on database. Returns the persistent object with generated ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Created successfully",content = @Content(schema=@Schema(implementation = College.class))),
            @ApiResponse(responseCode = "400",description = "Invalid Input",content = @Content),
            @ApiResponse(responseCode = "500",description = "Internal Server Error",content = @Content)
    })
    public ResponseEntity<College> addCollege(@RequestBody  College college){
        return ResponseEntity.status(201).body(collegeService.addCollege(college));
    }

    @GetMapping("/college")
    @Operation(summary = "Get college by state", description = "Return the list of colleges that matches the given state.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description ="Retrieval Successful",content = @Content(mediaType = "application/json",schema = @Schema(implementation = College.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content),
            @ApiResponse(responseCode = "404", description = "No college found",content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid state parameter",content = @Content)


    })
    public ResponseEntity<List<College>> getByState(@RequestParam String state){
        return ResponseEntity.ok(collegeService.getByState(state));
    }

}
