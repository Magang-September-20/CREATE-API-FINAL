/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.APIfinal.services.rest;

import lombok.Data;

/**
 *
 * @author NAME
 */
@Data
public class DataOutputUser {
    
    private UserOutput user;

    public DataOutputUser(UserOutput user) {
        this.user = user;
    }

    public DataOutputUser() {
        
    }
}
