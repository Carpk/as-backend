package com.thekleinbottle.as_backend.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface DmarcRecordRepository extends CrudRepository <DmarcRecord, Long> {

    List<DmarcRecord> findByPolicy(String policy);
}
