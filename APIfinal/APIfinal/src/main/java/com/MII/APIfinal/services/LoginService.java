/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.APIfinal.services;

import com.MII.APIfinal.entities.Account;
import com.MII.APIfinal.entities.User;
import com.MII.APIfinal.entities.UserRole;
import com.MII.APIfinal.others.BCrypt;
import com.MII.APIfinal.repositories.AccountRepository;
import com.MII.APIfinal.repositories.UserRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

    public Map<String, Object> login(String username, String password) {

        Map<String, Object> outputLogin = new HashMap<>();
        Account account = accountRepository.getAccountByUsername(username);

        // check if username not found
        if (account != null) {
            // check password
            if (BCrypt.checkpw(password, account.getPassword())) {
                User user = userRepository.findById(account.getId()).get();
                Map<String, Object> outputUser = new LinkedHashMap<>();

                outputUser.put("id", user.getId());
                outputUser.put("name", user.getName());
                outputUser.put("email", user.getEmail());
                outputUser.put("roles", getStringRoles(user.getUserRoleList()));

                outputLogin.put("user", outputUser);
                outputLogin.put("status", "success");
            } else {
                outputLogin.put("status", "wrong password");
            }
        } else {
            outputLogin.put("status", "username not found");
        }

        return outputLogin;
    }

    private static List<String> getStringRoles(List<UserRole> userRoles) {
        
        List<String> strings = new ArrayList<>();

        for (UserRole userRole : userRoles) {
            strings.add(userRole.getRole().getName());
        }

        return strings;
    }

}
