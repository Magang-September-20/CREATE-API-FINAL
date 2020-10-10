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
 * @author sweje
 */
@Data
public class ListGetAll {
    private List<DataOutputLogin> dataOutput;

    public ListGetAll() {
    }

    public ListGetAll(List<DataOutputLogin> dataOutput) {
        this.dataOutput = dataOutput;
    }
    
}
