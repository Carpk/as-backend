package com.thekleinbottle.as_backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thekleinbottle.as_backend.domain.DmarcRecord;
import com.thekleinbottle.as_backend.domain.DmarcRecordRepository;
import com.thekleinbottle.as_backend.domain.AppUser;
import com.thekleinbottle.as_backend.domain.AppUserRepository;
import com.thekleinbottle.as_backend.domain.Account;
import com.thekleinbottle.as_backend.domain.AccountRepository;

@SpringBootApplication
public class AsBackendApplication implements CommandLineRunner  {
	private static final Logger logger = LoggerFactory.getLogger(AsBackendApplication.class);
	private final DmarcRecordRepository repository;
	private final AppUserRepository userRepository;
	private final AccountRepository acctRepository;

	public AsBackendApplication(DmarcRecordRepository dmarcRepository, AppUserRepository userRepository,
			AccountRepository accountRepository) {
		this.repository = dmarcRepository; 
		this.userRepository = userRepository;
		this.acctRepository = accountRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AsBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Account acct = new Account();
		acctRepository.save(acct);

		AppUser user = new AppUser("JMahon", "John", "Mahoney", acct);
		userRepository.save(user);
		

		repository.save(new DmarcRecord("dmarc@thekleinbottle.com", null, "Reject", 
		null, null, null, null, null, 100, 86400, acct));

		for (DmarcRecord record : repository.findAll()) {
			logger.info("{} {} {}", record.getRua(), record.getPolicy(), record.getPct());
		}
	}

}
