/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.APIfinal.services;

import com.MII.APIfinal.entities.Account;
import com.MII.APIfinal.services.rest.DataOutputLogin;
import com.MII.APIfinal.others.BCrypt;
import com.MII.APIfinal.repositories.AccountRepository;
import com.MII.APIfinal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cadiize
 */
@Service
public class LoginService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    UserRepository userRepository;

    public DataOutputLogin login(String username, String password) {
        DataOutputLogin outputLogin = new DataOutputLogin();
        Account account = accountRepository.getAccountByUsername(username);

        if (account == null) {
            return new DataOutputLogin(null, "failed");
        }
        
        if (BCrypt.checkpw(password, account.getPassword())) {
            outputLogin.setUser(userRepository.findById(account.getId()).get());
            outputLogin.setStatus("success");
        } else {
            outputLogin.setStatus("failed");
        }

        return outputLogin;
    }

}
