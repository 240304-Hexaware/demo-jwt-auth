package com.revature.demojwtauth.controllers;

import com.revature.demojwtauth.services.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class SecureController {
    //This controller has methods which require the presence of our auth token in a cookie

    private TokenService tokenService;

    @Autowired
    public SecureController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @GetMapping("/secret")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public void getSecretInformation(HttpServletRequest req, @CookieValue(value = "Authentication") String token) {

        Jws<Claims> parsedClaims = tokenService.parseToken(token);
        String username = parsedClaims.getPayload().get("username", String.class);
        System.out.println(parsedClaims);
        System.out.println(username);

    }


}
