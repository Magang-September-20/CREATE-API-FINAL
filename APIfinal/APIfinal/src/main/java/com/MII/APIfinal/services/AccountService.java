/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.APIfinal.services;

import com.MII.APIfinal.entities.Account;
import com.MII.APIfinal.entities.TestOutputLogin;
import com.MII.APIfinal.others.BCrypt;
import com.MII.APIfinal.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cadiize
 */
@Service
public class AccountService {

    @Autowired
    AccountRepository repository;

    public TestOutputLogin login(String username, String password) {
        String hashedPassword = repository.getPasswordByUsername(username);
        String verification = null;
        TestOutputLogin outputLogin = new TestOutputLogin();
        
        if (BCrypt.checkpw(password, hashedPassword)) {
            outputLogin.setAccount(repository.getAccount(username));
            verification = "Login berhasil";
        } else {
            verification = "login gagal";
        }

        outputLogin.setVerification(verification);

        return outputLogin;
    }

}
