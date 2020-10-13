/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.APIfinal.controllers;

import com.MII.APIfinal.entities.Account;
import com.MII.APIfinal.others.BCrypt;
import com.MII.APIfinal.services.AccountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Acer
 */
@RestController
@RequestMapping("account/")
public class AccountController {
    @Autowired AccountService accountService;
    
    @CrossOrigin(origins = "http://localhost:8089")
    @GetMapping("getAll")
    public List<Account> getAll(){
        return  accountService.getAll();
    }
    
    @GetMapping("getById/{id}")
    public Account getById(@PathVariable("id") int id){
        return accountService.getById(id);
    }
    
    @PostMapping("save")
    public Account save(@RequestBody Account account){
        String hashedPassword = BCrypt.hashpw(account.getPassword(), BCrypt.gensalt());
        account.setPassword(hashedPassword);
        return accountService.save(account);
    }
    
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") int id){
       accountService.delete(id);
       return "Account berhasil dihapus";
    }
    
}
