package com.galvanize.japdemo.repositories;

import com.galvanize.japdemo.entities.Account;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * AccountRepository
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
}