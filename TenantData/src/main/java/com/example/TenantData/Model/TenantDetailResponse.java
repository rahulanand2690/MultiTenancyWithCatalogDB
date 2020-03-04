package com.example.TenantData.Model;

import lombok.Data;

import java.util.List;

@Data
public class TenantDetailResponse {
    private List<TenantDetails> tenantDetails;
}
