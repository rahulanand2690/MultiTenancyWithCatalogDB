package com.example.TenantInfo.CustomRouting;

import com.example.TenantInfo.DbProperties;
import com.example.TenantInfo.TenantDetailResponse;
import com.example.TenantInfo.TenantDetails;
import com.example.TenantInfo.TenantIdentifier.TenantContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MasterService {

    public static Map<Object, Object> getDataSourceHashMap(TenantDetailResponse details) {

        HashMap hashMap = new HashMap();
        for (TenantDetails temp : details.getTenantDetails()) {
            System.out.println(temp);
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("org.postgresql.Driver");
            dataSource.setUrl(temp.getUrl());
            dataSource.setUsername(temp.getUsername());
            dataSource.setPassword(temp.getPassword());
            hashMap.put(temp.getName(), dataSource);
        }
        return hashMap;
    }

}
