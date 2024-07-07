package com.example.rightelfm.repositories;

import com.example.rightelfm.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository <Account, Long> {
}
