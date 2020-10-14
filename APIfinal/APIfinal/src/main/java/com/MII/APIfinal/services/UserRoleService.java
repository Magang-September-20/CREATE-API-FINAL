/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.APIfinal.services;

import com.MII.APIfinal.entities.UserRole;
import com.MII.APIfinal.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NAME
 */
@Service
public class UserRoleService {
    
    @Autowired
    UserRoleRepository service;
    
    public UserRole getRole(int user){
        return service.findById(user).get();
    }
}
