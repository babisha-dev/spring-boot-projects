package com.example.Registration.CollegeRegistration.Service;

import com.example.Registration.CollegeRegistration.Model.Login;
import com.example.Registration.CollegeRegistration.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;
    public Boolean validate(Login log){
    if (loginRepository.findByUserEmailAndPassword(log.getUserEmail(),log.getPassword())==null){
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"User Does Not Exist");
        }
    return true;
    }
}
