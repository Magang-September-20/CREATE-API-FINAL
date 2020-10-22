/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.APIfinal.services;

import com.MII.APIfinal.entities.Account;
import com.MII.APIfinal.others.BCrypt;
import com.MII.APIfinal.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cadiize
 */
@Service
public class ChangePasswordService {

    @Autowired
    AccountRepository accountRepository;

    public String changePassword(Integer id, String oldPassword, String newPassword) {

        Account account = accountRepository.findById(id).get();

        if (BCrypt.checkpw(oldPassword, account.getPassword())) {
            
            account.setPassword(BCrypt.hashpw(newPassword, BCrypt.gensalt()));
            accountRepository.save(account);

            return "password changed";
        }

        return "wrong password";
    }

}
