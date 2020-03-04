package com.example.TenantInfo.Service;

import com.example.TenantInfo.Model.Account;
import com.example.TenantInfo.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantService {
    @Autowired
    private AccountRepository repository;

    public Iterable<Account> getAccountData(){
        return repository.findAll();
    }
}
