/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.APIfinal.services;

import com.MII.APIfinal.services.rest.DataOutputLogin;
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

    public DataOutputLogin login(String username, String password) {
        DataOutputLogin outputLogin = new DataOutputLogin();
        
        if (BCrypt.checkpw(password, repository.getPasswordByUsername(username))) {
            outputLogin.setAccount(repository.getAccount(username));
            outputLogin.setStatus("success");
        } else {
            outputLogin.setStatus("failed");
        }

        return outputLogin;
    }

}
