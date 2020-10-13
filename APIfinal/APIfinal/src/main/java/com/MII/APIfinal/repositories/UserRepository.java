/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.APIfinal.repositories;

import com.MII.APIfinal.entities.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author cadiize
 */
public interface UserRepository extends JpaRepository<User, Integer>{
    @Query(value = "SELECT * FROM user",nativeQuery = true)
    public List<User> getAll();
}
