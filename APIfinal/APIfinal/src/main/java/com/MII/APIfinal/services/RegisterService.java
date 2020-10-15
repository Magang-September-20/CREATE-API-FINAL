/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.APIfinal.services;

import com.MII.APIfinal.entities.Account;
import com.MII.APIfinal.entities.Role;
import com.MII.APIfinal.entities.User;
import com.MII.APIfinal.entities.UserRole;
import com.MII.APIfinal.others.BCrypt;
import com.MII.APIfinal.repositories.AccountRepository;
import com.MII.APIfinal.repositories.RoleRepository;
import com.MII.APIfinal.repositories.UserRepository;
import com.MII.APIfinal.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cadiize
 */
@Service
public class RegisterService {
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    AccountRepository accountRepository;
    
    @Autowired
    UserRoleRepository userRoleRepository;
    
    @Autowired
    RoleRepository roleRepository;
    
    public User register(String name, String email, String username, String password){
        
        if(accountRepository.getAccountByUsername(username) == null && accountRepository.getAccountByEmail(email) == null){
            //save user
            User newUser = userRepository.save(new User(0, name, email));

            //save account
            accountRepository.save(new Account(newUser.getId(), username, BCrypt.hashpw(password, BCrypt.gensalt())));

            //save role
            userRoleRepository.save(new UserRole(newUser.getId(), newUser, new Role(4)));
            
            return newUser;
        }
        else{
            return null;
        }
    }
    
}
