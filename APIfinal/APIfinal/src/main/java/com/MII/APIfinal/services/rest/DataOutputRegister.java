    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.APIfinal.services.rest;

import lombok.Data;

/**
 *
 * @author cadiize
 */
@Data
public class DataOutputRegister {
    
    private String status;

    public DataOutputRegister(String status) {
        this.status = status;
    }

    public DataOutputRegister() {
        
    }
}