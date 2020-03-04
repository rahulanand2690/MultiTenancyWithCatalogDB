package com.example.TenantInfo.Controller;

import com.example.TenantInfo.Configurations.TenantConfiguration;
import com.example.TenantInfo.DbProperties;
import com.example.TenantInfo.Model.Account;
import com.example.TenantInfo.Service.TenantService;
import com.example.TenantInfo.TenantDetailResponse;
import com.example.TenantInfo.TenantIdentifier.TenantContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TenantController {
    @Autowired
    private TenantService service;

    @Autowired
    private TenantConfiguration tenantConfiguration;

    @RequestMapping("/getAccountData")
    public Iterable<Account> getAccountData() {
        return service.getAccountData();
    }

    //fetch connection data from another application

    @RequestMapping("/connectionData")
    public ResponseEntity<TenantDetailResponse> connectionData() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("tenantId", TenantContext.getCurrentTenant());
        HttpEntity<DbProperties> entity = new HttpEntity(httpHeaders);

        ResponseEntity<TenantDetailResponse> response = restTemplate.exchange(
                "http://localhost:9001/getTenantConnectionData", HttpMethod.GET, entity, TenantDetailResponse.class);

        return response;
    }

}
