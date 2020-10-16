/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.APIfinal.controllers;

import com.MII.APIfinal.entities.User;
import com.MII.APIfinal.services.rest.DataInputLogin;
import com.MII.APIfinal.services.LoginService;
import com.MII.APIfinal.services.RegisterService;
import com.MII.APIfinal.services.UserService;
import com.MII.APIfinal.services.rest.DataInputRegister;
import com.MII.APIfinal.services.rest.UserGetAll;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody DataInputLogin inputLogin) {
        return loginService.login(inputLogin.getUsername(), inputLogin.getPassword());
    }
    
    @GetMapping("/getAll")
    public List<UserGetAll> getAll() {
        return loginService.getAllUser();
    }
    @GetMapping("/getEmployees")
    public List<UserGetAll> getEmployee() {
        return userService.getEmployee();
    }
    @GetMapping("/getUser")
    public List<UserGetAll> getUser() {
        return userService.getUser();
    }
    @GetMapping("/getHr")
    public List<UserGetAll> getHr() {
        return userService.getHr();
    }

    @PostMapping("/register")
    public User register(@RequestBody DataInputRegister inputRegister) {
        return registerService.register(inputRegister.getName(),
                inputRegister.getEmail(),
                inputRegister.getUsername(),
                inputRegister.getPassword()
        );
    }
    
}
