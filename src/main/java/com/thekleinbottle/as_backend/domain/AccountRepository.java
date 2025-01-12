package com.thekleinbottle.as_backend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long>{
    
    // List<Account> findByDmarcRecords(List<DmarcRecord> dmarcRecords);
    
}
