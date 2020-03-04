package com.example.TenantData.Service;

import com.example.TenantData.Model.TenantDetails;
import com.example.TenantData.Repository.TenantDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantDetailService {
    @Autowired
    private TenantDetailRepository repository;

    public TenantDetails getTenantConnectionData(String tenantName){
        return repository.findByname(tenantName);
    }

    public List<TenantDetails> getAllTenantData(){
        return (List<TenantDetails>) repository.findAll();
    }
}
