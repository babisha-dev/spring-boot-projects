package com.example.Registration.TaskManager.Controller;

import com.example.Registration.TaskManager.Modal.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tasks")
public class UserController {

    @GetMapping("/hello")
    public ResponseEntity<String> tasks(){
        User currUser=(User) SecurityContextHolder
                .getContext()
                .getAuthentication().
                getPrincipal();
        String msg= "Hello "+ currUser.getUserName();
        return ResponseEntity.status(200).body(msg);
    }
}
