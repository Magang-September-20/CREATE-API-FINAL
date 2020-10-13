/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.APIfinal.services;

import com.MII.APIfinal.entities.Account;
import com.MII.APIfinal.entities.User;
import com.MII.APIfinal.entities.UserRole;
import com.MII.APIfinal.services.rest.DataOutputLogin;
import com.MII.APIfinal.others.BCrypt;
import com.MII.APIfinal.repositories.AccountRepository;
import com.MII.APIfinal.repositories.UserRepository;
import com.MII.APIfinal.services.rest.UserOutputLogin;
import java.util.ArrayList;
import java.util.List;
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
            User user = userRepository.findById(account.getId()).get();
            UserOutputLogin userOutputLogin = new UserOutputLogin(user.getId(),
                    user.getName(),
                    user.getEmail(),
                    getStringRoles(user.getUserRoleList()));
            outputLogin.setUser(userOutputLogin);
            outputLogin.setStatus("success");
        } else {
            outputLogin.setStatus("failed");
        }

        return outputLogin;
    }
    
    private static List<String> getStringRoles(List<UserRole> userRoles){
        List<String> strings = new ArrayList<>();
        
        for (UserRole userRole : userRoles) {
            strings.add(userRole.getRole().getName());
        }
        
        return strings;
    }
    

    public List<UserOutputLogin> getAllUser2(){
        List<UserOutputLogin> userOutputLogins = new ArrayList<>();
        List<User> users = userRepository.getAll();
        
        for (User user : users) {
            UserOutputLogin outputLogin = new UserOutputLogin(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    getStringRoles(user.getUserRoleList())
            );
            userOutputLogins.add(outputLogin);
        }
        return userOutputLogins;
    }

}
