package com.revature.demojwtauth.controllers;

import com.revature.demojwtauth.exceptions.BadAuthenticationException;
import com.revature.demojwtauth.models.AuthDto;
import com.revature.demojwtauth.services.AuthService;
import com.revature.demojwtauth.services.TokenService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/public")
public class AuthController {
    private final TokenService tokenService;
    private final AuthService authService;

    @Autowired
    public AuthController(TokenService tokenService, AuthService authService) {
        this.tokenService = tokenService;
        this.authService = authService;
    }


    @PostMapping("/authenticate")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void login(@RequestBody AuthDto authDto, HttpServletResponse response) throws BadAuthenticationException{
        if(authService.authenticate(authDto)) {
            //create claims
            Map<String, String> claims = new HashMap<>();
            claims.put("username", authDto.getUsername());

            //generate token
            String token = tokenService.generateToken(claims);

            //store as cookie
            Cookie cookie = new Cookie("Authentication", token);
            cookie.setDomain("localhost");
            cookie.setPath("/");
            response.addCookie(cookie);

        } else {
            throw new BadAuthenticationException("username/password incorrect");
        }
    }

    @ExceptionHandler(BadAuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String badAuthentication(BadAuthenticationException e) {
        return e.getMessage();
    }




}
