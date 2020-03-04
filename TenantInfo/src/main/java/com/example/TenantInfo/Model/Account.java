package com.example.TenantInfo.Model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Account {
    @Id
    @Column(name = "accountno")
    private int AccountNo;
    @Column(name = "accounttype")
    private String Accounttype;
    @Column(name = "balance")
    private int Balance;
    @Column(name = "bankname")
    private String BankName;

}
