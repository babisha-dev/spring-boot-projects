package com.example.Registration.TaskManager.Controller;

import com.example.Registration.TaskManager.Modal.User;
import com.example.Registration.TaskManager.Service.AuthService;
import com.example.Registration.TaskManager.dto.AuthResponse;
import com.example.Registration.TaskManager.dto.LoginRequest;
import com.example.Registration.TaskManager.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest user){
        String msg=authService.register(user);
        return ResponseEntity.status(201).body(msg);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse>  login(@RequestBody LoginRequest log) throws AccessDeniedException {
        return ResponseEntity.status(200).body(authService.login(log));
    }

}
