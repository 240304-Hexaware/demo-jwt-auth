package com.revature.demojwtauth.services;

import com.revature.demojwtauth.models.AuthDto;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    //for now we will just hard code the user
    public boolean authenticate(AuthDto authDto) {
        return authDto.getUsername().equals("username")
                && authDto.getPassword().equals("password");
    }
}
