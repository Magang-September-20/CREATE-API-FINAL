/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.APIfinal.repositories;

import com.MII.APIfinal.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author cadiize
 */
public interface UserRepository extends JpaRepository<User, Integer>{
    
}
