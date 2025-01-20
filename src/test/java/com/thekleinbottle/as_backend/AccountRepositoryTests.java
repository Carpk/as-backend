package com.thekleinbottle.as_backend;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.thekleinbottle.as_backend.domain.Account;
import com.thekleinbottle.as_backend.domain.AccountRepository;

@DataJpaTest
public class AccountRepositoryTests {
    @Autowired
    private AccountRepository repository;

    @Test
    void saveAccount() {
        repository.save(new Account("ACME"));
        assertThat(repository.findByName("ACME").isPresent()).isTrue();
    }

    // @Test
    // void deleteAccount() {
    //     repository.save(new Account("ACME"));
    //     repository.deleteAll();
    //     assertThat(repository.count()).isEqualTo(0);
    // }


}
