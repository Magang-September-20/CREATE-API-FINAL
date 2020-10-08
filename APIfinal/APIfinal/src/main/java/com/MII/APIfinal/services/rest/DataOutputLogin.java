/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.APIfinal.services.rest;

import com.MII.APIfinal.entities.Account;
import lombok.Data;

/**
 *
 * @author cadiize
 */
@Data
public class DataOutputLogin {
    
    private Account account;
    private String status;

    public DataOutputLogin(Account account, String verification) {
        this.account = account;
        this.status = verification;
    }

    public DataOutputLogin() {
    }
    
}
