package com.example.Registration.CollegeRegistration.Controller;

import com.example.Registration.CollegeRegistration.Model.Login;
import com.example.Registration.CollegeRegistration.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<Boolean> validate(@RequestBody Login log){
        return ResponseEntity.ok().body(loginService.validate(log));
    }
}
