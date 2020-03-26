package com.galvanize.japdemo;

import java.util.Optional;

import javax.transaction.Transactional;

import com.galvanize.japdemo.entities.Account;
import com.galvanize.japdemo.entities.CreditCard;
import com.galvanize.japdemo.entities.CreditCartType;
import com.galvanize.japdemo.entities.Customer;
import com.galvanize.japdemo.repositories.CustomerRepository;

import org.assertj.core.api.Assertions;
import org.hibernate.AssertionFailure;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;



/**
 * CustomerDBTest
 */
@ActiveProfiles(profiles = "test")
@SpringBootTest
@Transactional          //Rolls Back Transactions for every test (TEARDOWN)
public class CustomerDBTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void canSaveACustomer() {

        Customer customer = new Customer("John", "Doe", "john@web.de");
        customer = customerRepository.save(customer);

        Optional<Customer> persistedResult = customerRepository.findById(customer.getId());

        Assertions.assertThat(persistedResult.isPresent()).isTrue();
        Assertions.assertThat(persistedResult.get().getFirstname()).isEqualTo("John");
    }

    @Test
    public void canLinkCustomerWithAccountAndCreditCard() {
        Account account = new Account("12345");
        Customer customer = new Customer("Kari", "Mann", "km@web.de", account);

        CreditCard creditCard = new CreditCard("123456789", CreditCartType.MC);
        customer.getAccount().getCreditCards().add(creditCard);

        customer = customerRepository.save(customer);

        Optional<Customer> persistedResult = customerRepository.findById(customer.getId());

  


        Assertions.assertThat(persistedResult.isPresent()).isTrue();
        Assertions.assertThat(persistedResult.get().getAccount().getAccountNumber()).isEqualTo("12345");
        Assertions.assertThat(persistedResult.get().getAccount().getCreditCards()).isNotEmpty();
        Assertions.assertThat(persistedResult.get().getAccount().getCreditCards().contains(creditCard)).isTrue();
    }

    @Test 
    public void shouldFindCustomerByEmail() throws Exception {
        Customer customer = new Customer("Kari", "Mann", "km@web.de");
        customer = customerRepository.save(customer);

        Customer result = customerRepository.findByEmailContaining("km@web.de")
            .orElseThrow(() -> new AssertionFailure("should have found customer by email"));

        Assertions.assertThat(result.getId()).isEqualTo(customer.getId());
    }

    
}