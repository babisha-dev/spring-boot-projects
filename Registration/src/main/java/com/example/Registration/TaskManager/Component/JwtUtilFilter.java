package com.example.Registration.TaskManager.Component;

import com.example.Registration.TaskManager.Modal.User;
import com.example.Registration.TaskManager.Repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.example.Registration.TaskManager.Component.JWTUtil;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtUtilFilter extends OncePerRequestFilter {
           private final JWTUtil jwtUtil;
           private  final UserRepository userRepository;

@Override
    protected  void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterchain) throws ServletException, IOException{
    String AuthHeader= req.getHeader("Authorization"); // Authorization is a key in header we will get  the value of it.
    if(AuthHeader==null || !AuthHeader.startsWith("Bearer ")){
        filterchain.doFilter(req, res);
        return;
    }
    String token=AuthHeader.substring(7);
    if(!jwtUtil.isTokenValid(token)){
        filterchain.doFilter(req,res);
        return;
    }
    String email=jwtUtil.extractEmail(token);
 User user=   userRepository.findByUserEmail(email).orElse(null);
 if(user!=null){
     UsernamePasswordAuthenticationToken AuthToken= new UsernamePasswordAuthenticationToken(
             user,
             null,
             List.of(new SimpleGrantedAuthority("ROLE_"+ user.getRole().name()))
     );
     SecurityContextHolder.getContext().setAuthentication(AuthToken);
 }
 filterchain.doFilter(req,res);

    }

}
