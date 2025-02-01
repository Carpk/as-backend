package com.thekleinbottle.as_backend;

import java.util.Date;

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
import com.thekleinbottle.as_backend.domain.DmarcReport;
import com.thekleinbottle.as_backend.domain.DmarcReportRepository;
import com.thekleinbottle.as_backend.domain.DmarcItem;
import com.thekleinbottle.as_backend.domain.DmarcItemRepository;

@SpringBootApplication
public class AsBackendApplication implements CommandLineRunner  {
	private static final Logger logger = LoggerFactory.getLogger(AsBackendApplication.class);
	private final DmarcRecordRepository recordRepository;
	private final AppUserRepository userRepository;
	private final AccountRepository acctRepository;
	private final AssetRepository assetRepository;
	private final HelpTicketRepository ticketRepository;
	private final DmarcReportRepository reportRepository;
	private final DmarcItemRepository dItemRepository;


	public AsBackendApplication(DmarcRecordRepository recordRepository, AppUserRepository userRepository, AccountRepository accountRepository,
			AssetRepository assetRepository, HelpTicketRepository ticketRepository, DmarcReportRepository reportRepository, DmarcItemRepository dItemRepository) {
		this.recordRepository = recordRepository; 
		this.userRepository = userRepository;
		this.acctRepository = accountRepository;
		this.assetRepository = assetRepository;
		this.ticketRepository = ticketRepository;
		this.reportRepository = reportRepository;
		this.dItemRepository = dItemRepository;
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

		recordRepository.save(new DmarcRecord("dmarc@thekleinbottle.com", null, "Reject", 
		null, null, null, null, null, 100, 86400, acct));
		recordRepository.save(new DmarcRecord("me@shawnklein.net", null, "Quarantine", 
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

		DmarcReport report = new DmarcReport("Enterprise Outlook", "dmarc@micronoft.com", "c3bcff5cbaef4d9da62e9ea8a", 
			new Date(1734307200), new Date(1734393600), "chucksburgers.org", null, null, 
			"reject", null, acct);
		reportRepository.save(report);

		dItemRepository.save(new DmarcItem(1, "none", true, true, "10.1.1.20", "burtsburittos.net", 
			"chucksburgers.org", "chucksburgers.org", "chucksburgers.org", "selector 2", 
			"chucksburgers.org", "mfrom", report));
		dItemRepository.save(new DmarcItem(2, "reject", false, false, "10.1.87.20", "tomstacos.org", 
			"philspastries.is", "chucksburgers.org", "chucksburgers.org", "selector 2", 
			"chucksburgers.org", "mfrom", report));
		dItemRepository.save(new DmarcItem(1, "none", true, true, "10.50.38.20", "jimsjuice.net", 
			"chucksburgers.org", "chucksburgers.org", "chucksburgers.org", "selector 2", 
			"chucksburgers.org", "mfrom", report));

		DmarcReport report2 = new DmarcReport("Mimecast", "no-reply@mimecastreports.com", "5d9523a5ca19d1c613bf2f28246d6b54", 
			new Date(1734393600), new Date(1734479999), "chucksburgers.org", null, null, 
			"reject", null, acct);
		reportRepository.save(report2);

	}

}
