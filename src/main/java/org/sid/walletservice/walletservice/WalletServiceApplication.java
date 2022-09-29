package org.sid.walletservice.walletservice;

import org.sid.walletservice.walletservice.entities.Currency;
import org.sid.walletservice.walletservice.entities.Wallet;
import org.sid.walletservice.walletservice.repositories.CurrencyRepository;
import org.sid.walletservice.walletservice.repositories.WalletRepository;
import org.sid.walletservice.walletservice.service.WalletService;
import org.sid.walletservice.walletservice.service.WalletServicesImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
@Transactional
public class WalletServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(WalletServicesImpl walletService){
		return args -> {
			walletService.loadData();
walletService.loadWallet();
walletService.loadTransaction();

		};

	}
}
