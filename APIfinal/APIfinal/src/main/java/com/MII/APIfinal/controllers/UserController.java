/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.APIfinal.controllers;

import com.MII.APIfinal.entities.User;
import com.MII.APIfinal.entities.UserRole;
import com.MII.APIfinal.services.UserRoleService;
import com.MII.APIfinal.services.UserService;
import com.MII.APIfinal.services.rest.DataOutputUser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author NAME
 */
@RestController
@RequestMapping("user/")
public class UserController {
    @Autowired UserService userService;
    @Autowired UserRoleService userRoleService;
    
    @CrossOrigin(origins = "http://localhost:8089")
    @GetMapping("getAll")
    public List<User> getAll(){
        return  userService.getAll();
    }
    
    @GetMapping("getById/{id}")
    public DataOutputUser getById(@PathVariable("id") int id){
        return userService.getById(id);
    }
    
    @PostMapping("save")
    public User save(@RequestBody User user){
        return userService.save(user);
    }
    
    @GetMapping("getId/{email}")
    public int getById(@PathVariable("email") String email){
        return userService.getId(email);
    }
    
    @GetMapping("getRole/{id}")
    public List<String> getRole(@PathVariable("id") int id){
        return userService.getById(id).getUser().getRoles();
    }
    
}
