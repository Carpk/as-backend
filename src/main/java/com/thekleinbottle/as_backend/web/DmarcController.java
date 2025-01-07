package com.thekleinbottle.as_backend.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thekleinbottle.as_backend.domain.DmarcRecord;
import com.thekleinbottle.as_backend.domain.DmarcRecordRepository;
  
@RestController
public class DmarcController {
    private final DmarcRecordRepository repository;

    public DmarcController(DmarcRecordRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/dmarc")
    public Iterable<DmarcRecord> getDmarcRecord() {
        return repository.findAll();
    }
    
}
