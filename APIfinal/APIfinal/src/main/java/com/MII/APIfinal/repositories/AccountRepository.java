/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.APIfinal.repositories;

import com.MII.APIfinal.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cadiize
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
    
    @Query(value = "SELECT * FROM `account` WHERE `username` = ?1", nativeQuery = true)
    public Account getAccount(String username);
    
    @Query(value = "SELECT `password` FROM `account` WHERE `username` = ?1", nativeQuery = true)
    public String getPasswordByUsername(String username);
}
