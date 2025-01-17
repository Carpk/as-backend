package com.thekleinbottle.as_backend.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {

    List<AppUser> findByAccount(Account account);

    Optional<AppUser> findByUsername(String username);
}
