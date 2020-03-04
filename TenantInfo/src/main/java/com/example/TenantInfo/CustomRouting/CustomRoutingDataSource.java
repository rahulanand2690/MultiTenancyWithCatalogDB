package com.example.TenantInfo.CustomRouting;

import com.example.TenantInfo.TenantIdentifier.TenantContext;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class CustomRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attr!=null) {
            String tenantId = TenantContext.getCurrentTenant();
            return tenantId;
        } else {
            return "hdfc";             // default data source
        }
    }
}
