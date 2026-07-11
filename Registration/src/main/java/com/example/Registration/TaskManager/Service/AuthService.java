package com.example.Registration.TaskManager.Service;

import com.example.Registration.TaskManager.Component.JWTUtil;
import com.example.Registration.TaskManager.Repository.UserRepository;
import com.example.Registration.TaskManager.dto.AuthResponse;
import com.example.Registration.TaskManager.dto.LoginRequest;
import com.example.Registration.TaskManager.dto.RegisterRequest;
import com.example.Registration.TaskManager.Modal.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTUtil jwtUtil;

    public  String register(RegisterRequest req){
  if(userRepository.existsByUserEmail(req.getEmail())){
      throw new RuntimeException("User Already Exists");
  }
  User user=new User();
  user.setUserEmail(req.getEmail());
  user.setUserName((req.getName()));
  user.setPassword(passwordEncoder.encode(req.getPassword()));
  user.setRole(User.RoleType.USER);
   userRepository.save(user);
        return "User saved successfully";
    }
    public AuthResponse login(LoginRequest log) throws AccessDeniedException {
        User user=userRepository.findByUserEmail(log.getEmail()).orElseThrow(()->new AccessDeniedException("User does  not exists"));
        if(!passwordEncoder.matches(log.getPassword(),user.getPassword())){
            throw new AccessDeniedException("Invalid Password");
        }
        String token=jwtUtil.generateToken(log.getEmail());
        return new AuthResponse(token, user.getUserEmail(),user.getRole().name());
    }


}
