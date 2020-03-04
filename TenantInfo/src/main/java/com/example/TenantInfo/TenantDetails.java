package com.example.TenantInfo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "tenantdbdetails")
public class TenantDetails {
    @Id
    private int tenantid;
    public String driverclassname;
    public String url;
    public String name;
    public String username;
    public String password;

}
