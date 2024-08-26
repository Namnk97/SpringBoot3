package com.example.booking_online.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Account")
public class Account extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(name = "ACCOUNT_NAME")
    private String accountName;

    @Column(name = "PASSWD")
    private String passwd;

    @Column(name = "CODE_USER")
    private String codeUser;

    @Column(name = "FULL_NAME")
    private String fullName;
    @Builder(builderMethodName = "accountBuilder")
    public Account(String createdBy, Date createdDate, String updatedBy, Date updatedDate, Long status, Long accountId, String accountName, String passwd, String codeUser, String fullName) {
        super(createdBy, createdDate, updatedBy, updatedDate, status);
        this.accountId = accountId;
        this.accountName = accountName;
        this.passwd = passwd;
        this.codeUser = codeUser;
        this.fullName = fullName;
    }
}
