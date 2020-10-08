/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.APIfinal.entities;

import lombok.Data;

/**
 *
 * @author cadiize
 */
@Data
public class TestOutputLogin {
    
    private Account account;
    private String verification;

    public TestOutputLogin(Account account, String verification) {
        this.account = account;
        this.verification = verification;
    }

    public TestOutputLogin() {
    }
    
}
