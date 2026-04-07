package com.example.Registration.Controller;

import com.example.Registration.Model.Login;
import com.example.Registration.Service.LoginService;
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
