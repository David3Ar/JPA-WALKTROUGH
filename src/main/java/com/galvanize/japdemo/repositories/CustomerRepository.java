package com.galvanize.japdemo.repositories;

import java.util.Optional;

import com.galvanize.japdemo.entities.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CustomerRepository
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmailContaining (String email);
}