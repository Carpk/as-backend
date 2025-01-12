package com.thekleinbottle.as_backend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DmarcRecordRepository extends CrudRepository <DmarcRecord, Long> {

    List<DmarcRecord> findByPolicy(String policy);

}
