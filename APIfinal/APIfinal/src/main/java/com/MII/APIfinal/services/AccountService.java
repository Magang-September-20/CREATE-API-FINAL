/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.APIfinal.services;

import com.MII.APIfinal.entities.Account;
import com.MII.APIfinal.repositories.AccountRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Acer
 */
@Service
public class AccountService {
    @Autowired AccountRepository accountRepository;
    
    public List<Account> getAll(){
        return accountRepository.findAll();
    }
    
    public Account getById(int id){
        return accountRepository.findById(id).get();
    }
    
    public Account save(Account account){
        return accountRepository.save(account);
    }
    
    public void delete(int id){
        accountRepository.delete(new Account(id));
    }
}
