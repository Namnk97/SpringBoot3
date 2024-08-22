package com.example.booking_online.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Account")
public class Account extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(name = "ACCOUNT_NAME")
    private String accountName;

    @Column(name = "PASSWD")
    private String passwd;

    @Column(name = "CODE_USER")
    private String codeUser;

    @Column(name = "FULL_NAME")
    private String fullName;


}
