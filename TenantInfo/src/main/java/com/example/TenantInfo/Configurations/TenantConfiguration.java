package com.example.TenantInfo.Configurations;

import com.example.TenantInfo.CustomRouting.CustomRoutingDataSource;
import com.example.TenantInfo.CustomRouting.MasterService;
import com.example.TenantInfo.DbProperties;
import com.example.TenantInfo.TenantDetailResponse;
import com.example.TenantInfo.TenantIdentifier.TenantContext;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.net.ConnectException;


@Component
public class TenantConfiguration {

    @Bean
    public DataSource dataSource() {
        connectionData();
        TenantDetailResponse tenantDetailResponse = connectionData();
        CustomRoutingDataSource customDataSource = new CustomRoutingDataSource();
        customDataSource.setTargetDataSources(MasterService.getDataSourceHashMap(tenantDetailResponse));
        return customDataSource;
    }


    @Cacheable(value = "AllTenantDatas")
    public TenantDetailResponse connectionData() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("tenantId", TenantContext.getCurrentTenant());
        HttpEntity<DbProperties> entity = new HttpEntity(httpHeaders);

        try {
            ResponseEntity<TenantDetailResponse> response = restTemplate.exchange(
                    "http://localhost:9001/getAllTenantConnectionData", HttpMethod.GET, entity, TenantDetailResponse.class);


            DbProperties dbProperties = new DbProperties();
            TenantDetailResponse allresponse = (TenantDetailResponse) response.getBody();
            TenantDetailResponse details = allresponse;
            return allresponse;
        } catch (Exception e) {
            System.out.println("!!!!!   unable to fetch data from Tenant details Microservice" + e.getMessage());

        }
        return null;

    }
}
