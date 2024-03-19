package com.revature.demojwtauth.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class SecureController {
    //This controller has methods which require the presence of our auth token in a cookie
    @GetMapping("/secret")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public String getSecretInformation(@CookieValue("Authorization") String token) {

    }


}
