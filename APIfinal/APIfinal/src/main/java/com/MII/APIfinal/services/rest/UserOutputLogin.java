/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.APIfinal.services.rest;

import java.util.List;
import lombok.Data;

/**
 *
 * @author cadiize
 */
@Data
public class UserOutputLogin {

    int id;
    String name, email;
    List<String> roles;

    public UserOutputLogin(int id, String name, String email, List<String> roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.roles = roles;
    }
    
}
