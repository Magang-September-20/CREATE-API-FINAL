/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.APIfinal.services;

import com.MII.APIfinal.entities.User;
import com.MII.APIfinal.repositories.UserRepository;
import com.MII.APIfinal.services.rest.UserOutputLogin;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class UserService {
   @Autowired UserRepository ur;
   @Autowired LoginService ls;
   
   public List<UserOutputLogin> getAll(){
       List<User> listUser = ur.findAll();
       List<UserOutputLogin> listUserOutput = new ArrayList<>();
       
       for (User user : listUser) {
           UserOutputLogin temp = new UserOutputLogin(user.getId(),
                   user.getName(),
                   user.getEmail(),
                   ls.getStringRoles(user.getUserRoleList()));
           listUserOutput.add(temp);
       }
       return listUserOutput;
       
   }
}
