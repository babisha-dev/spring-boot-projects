package com.example.Registration.Repository;

import com.example.Registration.Model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository  extends JpaRepository<Login,Long> {
    Login findByUserEmailAndPassword(String userEmail,String password);
}
