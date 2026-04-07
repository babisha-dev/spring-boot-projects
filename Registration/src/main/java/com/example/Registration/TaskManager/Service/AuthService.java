package com.example.Registration.TaskManager.Service;

import com.example.Registration.TaskManager.Component.JWTUtil;
import com.example.Registration.TaskManager.Repository.UserRepository;
import com.example.Registration.TaskManager.dto.AuthResponse;
import com.example.Registration.TaskManager.dto.LoginRequest;
import com.example.Registration.TaskManager.dto.RegisterRequest;
import com.example.Registration.TaskManager.dto.UserRequest;
import com.example.Registration.TaskManager.Modal.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JWTUtil jwtUtil;

    public  String register(RegisterRequest req){
  if(userRepository.existsByEmail(req.getEmail())){
      throw new RuntimeException("User Already Exists");
  }
  User user=new User();
  user.setUserEmail(req.getEmail());
  user.setUserName((req.getName()));
  user.setPassword(req.getPassword());
  user.setRole(User.RoleType.USER);
   userRepository.save(user);
        return "User saved successfully";
    }
    public AuthResponse login(LoginRequest log){
        User user=userRepository.findByUserEmail(log.getUserEmail()).orElseThrow(()->new RuntimeException("User does  not exists"));
        if(!passwordEncoder.matches(log.getPassword(),user.getPassword())){
            throw new RuntimeException("Invalid Exception");
        }
        String token=jwtUtil.generateToken(log.getUserEmail());
        return new AuthResponse(token, user.getUserEmail(),user.getRole());
    }

}
