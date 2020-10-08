/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.APIfinal.controllers;

import com.MII.APIfinal.services.rest.DataInputLogin;
import com.MII.APIfinal.services.rest.DataOutputLogin;
import com.MII.APIfinal.services.AccountService;
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
    AccountService accountService;

    @PostMapping("/login")
    public DataOutputLogin login(@RequestBody DataInputLogin inputLogin) {
        return accountService.login(inputLogin.getUsername(), inputLogin.getPassword());
    }
    
}
