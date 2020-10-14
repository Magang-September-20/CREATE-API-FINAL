/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.APIfinal.services;

import com.MII.APIfinal.entities.User;
import com.MII.APIfinal.entities.UserRole;
import com.MII.APIfinal.repositories.UserRepository;
import com.MII.APIfinal.services.rest.DataOutputUser;
import com.MII.APIfinal.services.rest.UserOutput;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NAME
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public DataOutputUser getById(int id) {
        DataOutputUser output = new DataOutputUser();
        User user = userRepository.findById(id).get();
        UserOutput userOutput = new UserOutput(user.getId(),
                user.getName(),
                user.getEmail(),
                getStringRoles(user.getUserRoleList()));
        output.setUser(userOutput);
        return output;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public int getId(String email) {
        return userRepository.getId(email);
    }
    
    private static List<String> getStringRoles(List<UserRole> userRoles) {
        List<String> strings = new ArrayList<>();

        for (UserRole userRole : userRoles) {
            strings.add(userRole.getRole().getName());
        }

        return strings;
    }
}
