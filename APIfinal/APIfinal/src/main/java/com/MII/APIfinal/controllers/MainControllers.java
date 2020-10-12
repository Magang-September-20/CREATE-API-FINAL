/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.APIfinal.controllers;

import com.MII.APIfinal.services.rest.DataInputLogin;
import com.MII.APIfinal.services.LoginService;
import com.MII.APIfinal.services.RegisterService;
import com.MII.APIfinal.services.rest.DataInputRegister;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sweje
 */
@RestController
public class MainControllers {

    @Autowired
    LoginService loginService;

    @Autowired
    RegisterService registerService;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody DataInputLogin inputLogin) {
        return loginService.login(inputLogin.getUsername(), inputLogin.getPassword());
    }

    @PostMapping("/register")
    public String register(@RequestBody DataInputRegister inputRegister) {
        return registerService.register(inputRegister.getName(),
                inputRegister.getEmail(),
                inputRegister.getUsername(),
                inputRegister.getPassword()
        );
    }
    
}
