package com.example.booking_online.repository;

import com.example.booking_online.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Account,Long> {
}
