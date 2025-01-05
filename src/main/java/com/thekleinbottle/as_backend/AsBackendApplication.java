package com.thekleinbottle.as_backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thekleinbottle.as_backend.domain.DmarcRecord;
import com.thekleinbottle.as_backend.domain.DmarcRecordRepository;
import com.thekleinbottle.as_backend.domain.Admin;
import com.thekleinbottle.as_backend.domain.AdminRepository;

@SpringBootApplication
public class AsBackendApplication implements CommandLineRunner  {
	private static final Logger logger = LoggerFactory.getLogger(AsBackendApplication.class);
	private final DmarcRecordRepository repository;
	private final AdminRepository arepository;

	public AsBackendApplication(DmarcRecordRepository dRepository, AdminRepository aRepository) {
		this.repository = dRepository; 
		this.arepository = aRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AsBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Admin admin = new Admin("JMahon", "John", "Mahoney");
		arepository.save(admin);

		repository.save(new DmarcRecord("dmarc@thekleinbottle.com", null, "Reject", 
		null, null, null, null, null, 100, 86400, admin));

		for (DmarcRecord record : repository.findAll()) {
			logger.info("{} {} {}", record.getRua(), record.getPolicy(), record.getPct());
		}
	}

}
