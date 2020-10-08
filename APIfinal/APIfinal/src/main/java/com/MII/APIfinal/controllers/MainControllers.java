/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.APIfinal.controllers;

import com.MII.APIfinal.entities.Account;
import com.MII.APIfinal.entities.TestInputLogin;
import com.MII.APIfinal.entities.TestOutputLogin;
import com.MII.APIfinal.entities.User;
import com.MII.APIfinal.services.AccountService;
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
    AccountService accountService;

    @PostMapping("/test")
    public User test(@RequestBody User user) {
//        System.out.println(user);
        return user;
    }

    @PostMapping("/login")
    public TestOutputLogin login(@RequestBody TestInputLogin inputLogin) {
//        TestOutputLogin outputLogin = new TestOutputLogin(account, "berhasil");
//        TestOutputLogin outputLogin = new TestOutputLogin(accountService.login(inputLogin.getUsername(), inputLogin.getPassword()), "login berhasil");

        return accountService.login(inputLogin.getUsername(), inputLogin.getPassword());
    }
}
