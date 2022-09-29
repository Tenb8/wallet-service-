package org.sid.walletservice.walletservice.web;

import org.sid.walletservice.walletservice.entities.Currency;
import org.sid.walletservice.walletservice.entities.Wallet;
import org.sid.walletservice.walletservice.entities.WalletTransactions;
import org.sid.walletservice.walletservice.mappers.CurrencyMappers;
import org.sid.walletservice.walletservice.mappers.TransactionMappers;
import org.sid.walletservice.walletservice.mappers.WalletMappers;
import org.sid.walletservice.walletservice.repositories.CurrencyRepository;
import org.sid.walletservice.walletservice.repositories.TransactionRepository;
import org.sid.walletservice.walletservice.repositories.WalletRepository;
import org.sid.walletservice.walletservice.service.WalletServices;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Transactional
@RestController
@RequestMapping("/api")
public class WalletController {

    private WalletRepository walletRepository;

    private CurrencyRepository currencyRepository;

    private TransactionRepository transactionRepository;

    private WalletServices services;

    private CurrencyMappers currencyMappers;

    private WalletMappers walletMappers;

    private TransactionMappers transactionMappers;

    public WalletController(WalletRepository walletRepository, CurrencyRepository currencyRepository,
                            TransactionRepository transactionRepository, WalletServices services) {
        this.walletRepository = walletRepository;
        this.currencyRepository = currencyRepository;
        this.transactionRepository = transactionRepository;
        this.services = services;
    }

    @GetMapping("/currency")
public List<Currency> currencyList ()  {

 return currencyRepository.findAll();

}
@GetMapping("/wallet")
public List<Wallet> userWallets(){
    return walletRepository.findAll();
}

@GetMapping("/transaction")
public List<WalletTransactions> fromTransaction ()  {

        return transactionRepository.findAll();

    }
}
