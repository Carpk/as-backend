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
import com.thekleinbottle.as_backend.domain.Asset;
import com.thekleinbottle.as_backend.domain.AssetRepository;

@SpringBootApplication
public class AsBackendApplication implements CommandLineRunner  {
	private static final Logger logger = LoggerFactory.getLogger(AsBackendApplication.class);
	private final DmarcRecordRepository dmarcRepository;
	private final AppUserRepository userRepository;
	private final AccountRepository acctRepository;
	private final AssetRepository assetRepository;

	public AsBackendApplication(DmarcRecordRepository dmarcRepository, AppUserRepository userRepository,
			AccountRepository accountRepository, AssetRepository assetRepository) {
		this.dmarcRepository = dmarcRepository; 
		this.userRepository = userRepository;
		this.acctRepository = accountRepository;
		this.assetRepository = assetRepository;
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
		

		dmarcRepository.save(new DmarcRecord("dmarc@thekleinbottle.com", null, "Reject", 
		null, null, null, null, null, 100, 86400, acct));

		dmarcRepository.save(new DmarcRecord("me@shawnklein.net", null, "Quarantine", 
		null, null, null, null, null, 100, 86400, acct));

		assetRepository.save(new Asset("D127", "FloorR1D3", null, "Asus P570", null, null,
		"i7-13770k", null, null, user));


		for (DmarcRecord record : dmarcRepository.findAll()) {
			logger.info("{} {} {}", record.getRua(), record.getPolicy(), record.getPct());
		}


		// Asset(String number, String name, String make, String model, String serial, Account account) {
	}

}
