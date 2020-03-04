package com.example.TenantData.Repository;

import com.example.TenantData.Model.TenantDetails;
import org.springframework.data.repository.CrudRepository;

public interface TenantDetailRepository extends CrudRepository<TenantDetails, Integer> {
    public TenantDetails findByname(String tenantName);
}
