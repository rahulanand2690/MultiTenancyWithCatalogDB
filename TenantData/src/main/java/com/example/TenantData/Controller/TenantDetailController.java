package com.example.TenantData.Controller;

import com.example.TenantData.Model.TenantDetailResponse;
import com.example.TenantData.Model.TenantDetails;
import com.example.TenantData.Service.TenantDetailService;
import com.example.TenantData.TenantIdentifier.TenantContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TenantDetailController {
    @Autowired
    public TenantDetailService service;

    //fetch tenant connection data based on headder
    @RequestMapping("/getTenantConnectionData")
    public TenantDetails getTenantConnectionData() {
        return service.getTenantConnectionData(TenantContext.getCurrentTenant());
    }

    //fetch all tenant connection datas
    @RequestMapping("/getAllTenantConnectionData")
    public TenantDetailResponse AllTenantConnectionData() {
        TenantDetailResponse tenantDetailResponse = new TenantDetailResponse();
        tenantDetailResponse.setTenantDetails(service.getAllTenantData());
        return tenantDetailResponse;

    }



}
