package com.thekleinbottle.as_backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thekleinbottle.as_backend.domain.DmarcRecord;
import com.thekleinbottle.as_backend.domain.DmarcRecordRepository;
import com.thekleinbottle.as_backend.domain.HelpTicket;
import com.thekleinbottle.as_backend.domain.AppUser;
import com.thekleinbottle.as_backend.domain.AppUserRepository;
import com.thekleinbottle.as_backend.domain.Account;
import com.thekleinbottle.as_backend.domain.AccountRepository;
import com.thekleinbottle.as_backend.domain.Asset;
import com.thekleinbottle.as_backend.domain.AssetRepository;
import com.thekleinbottle.as_backend.domain.HelpTicket;
import com.thekleinbottle.as_backend.domain.HelpTicketRepository;

@SpringBootApplication
public class AsBackendApplication implements CommandLineRunner  {
	private static final Logger logger = LoggerFactory.getLogger(AsBackendApplication.class);
	private final DmarcRecordRepository dmarcRepository;
	private final AppUserRepository userRepository;
	private final AccountRepository acctRepository;
	private final AssetRepository assetRepository;
	private final HelpTicketRepository ticketRepository;

	public AsBackendApplication(DmarcRecordRepository dmarcRepository, AppUserRepository userRepository,
			AccountRepository accountRepository, AssetRepository assetRepository, HelpTicketRepository ticketRepository) {
		this.dmarcRepository = dmarcRepository; 
		this.userRepository = userRepository;
		this.acctRepository = accountRepository;
		this.assetRepository = assetRepository;
		this.ticketRepository = ticketRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AsBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Account acct = new Account();
		acctRepository.save(acct);

		AppUser user = new AppUser("admin", "$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", 
			"ADMIN", "John", "Mahoney", acct);
		AppUser user2 = new AppUser("user", "$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", 
			"USER", "Tim", "Tom", acct);
		userRepository.save(user);
		userRepository.save(user2);

		dmarcRepository.save(new DmarcRecord("dmarc@thekleinbottle.com", null, "Reject", 
		null, null, null, null, null, 100, 86400, acct));
		dmarcRepository.save(new DmarcRecord("me@shawnklein.net", null, "Quarantine", 
		null, null, null, null, null, 75, 86400, acct));

		assetRepository.save(new Asset("D127", "FloorR1D3", null, "Asus P570", null, null,
			"i7-13770k", null, acct, user));
		assetRepository.save(new Asset("B1632", "OfficeD23", null, "AsRock q175", null, "X32C18A",
			"i5-11760", "Quadro p1200", acct, user2));
		assetRepository.save(new Asset("R184", "Room134", null, "lenovo p5", null, "M64D752",
			"i9-8870", null, acct, user2));

		ticketRepository.save(new HelpTicket("Ticket 1", "ticket text", user2));
		ticketRepository.save(new HelpTicket("Ticket 2", "ticket text", user2));
		ticketRepository.save(new HelpTicket("Ticket 3", "ticket text", user2));
		ticketRepository.save(new HelpTicket("Ticket 4", "ticket text", user2));
		ticketRepository.save(new HelpTicket("Ticket 5", "ticket text", user2));
		ticketRepository.save(new HelpTicket("Ticket 6", "ticket text", user2));

	}

}
