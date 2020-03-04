package com.example.TenantInfo.Repository;

import com.example.TenantInfo.Model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {
}
