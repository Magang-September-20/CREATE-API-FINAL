/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.APIfinal.services;

import com.MII.APIfinal.entities.User;
import com.MII.APIfinal.entities.UserRole;
import com.MII.APIfinal.repositories.UserRepository;
import com.MII.APIfinal.services.rest.UserGetAll;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pannavr
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    
//   public List<User> getEmployee(){
////        List<UserGetAll> userOutputLogins = new ArrayList<>();
//        
//        
////        for (User user : users) {
////            UserGetAll outputLogin = new UserGetAll(
////                    user.getId(),
////                    user.getName(),
////                    user.getEmail(),
////                    user.getUserRoleList());
////            );
//            return userRepository.getEmployee();
//        }
//        return userOutputLogins;

    
    private static List<String> getStringRoles(List<UserRole> userRoles) {
        
        List<String> strings = new ArrayList<>();

        for (UserRole userRole : userRoles) {
            strings.add(userRole.getRole().getName());
        }

        return strings;
    }
    public List<UserGetAll> getEmployee(){
        List<UserGetAll> userOutputLogins = new ArrayList<>();
        List<User> users = userRepository.getEmployee();
        
        for (User user : users) {
            UserGetAll outputLogin = new UserGetAll(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    getStringRoles(user.getUserRoleList())
            );
            userOutputLogins.add(outputLogin);
        }
        return userOutputLogins;
    }
    public List<UserGetAll> getUser(){
        List<UserGetAll> userOutputLogins = new ArrayList<>();
        List<User> users = userRepository.getUser();
        
        for (User user : users) {
            UserGetAll outputLogin = new UserGetAll(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    getStringRoles(user.getUserRoleList())
            );
            userOutputLogins.add(outputLogin);
        }
        return userOutputLogins;
    }
    public List<UserGetAll> getHr(){
        List<UserGetAll> userOutputLogins = new ArrayList<>();
        List<User> users = userRepository.getHr();
        
        for (User user : users) {
            UserGetAll outputLogin = new UserGetAll(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    getStringRoles(user.getUserRoleList())
            );
            userOutputLogins.add(outputLogin);
        }
        return userOutputLogins;
    }
    
    public int countUser(){
    return userRepository.countUser();
    }
}
