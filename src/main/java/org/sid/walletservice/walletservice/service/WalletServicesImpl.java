package org.sid.walletservice.walletservice.service;

import org.sid.walletservice.walletservice.dto.currencyDTO.CurrencyRequestDTO;
import org.sid.walletservice.walletservice.dto.currencyDTO.CurrencyResponseDTO;
import org.sid.walletservice.walletservice.dto.transactionDTO.TransactionsRequestDTO;
import org.sid.walletservice.walletservice.dto.transactionDTO.TransactionsResponseDTO;
import org.sid.walletservice.walletservice.dto.walletDTO.WalletRequestDTO;
import org.sid.walletservice.walletservice.dto.walletDTO.WalletResponseDTO;
import org.sid.walletservice.walletservice.entities.Currency;
import org.sid.walletservice.walletservice.entities.TransactionType;
import org.sid.walletservice.walletservice.entities.Wallet;
import org.sid.walletservice.walletservice.entities.WalletTransactions;
import org.sid.walletservice.walletservice.mappers.CurrencyMappers;
import org.sid.walletservice.walletservice.mappers.TransactionMappers;
import org.sid.walletservice.walletservice.mappers.WalletMappers;
import org.sid.walletservice.walletservice.repositories.CurrencyRepository;
import org.sid.walletservice.walletservice.repositories.TransactionRepository;
import org.sid.walletservice.walletservice.repositories.WalletRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@Transactional
public class WalletServicesImpl implements WalletServices {

    private WalletRepository walletRepository;
    private CurrencyRepository currencyRepository;
    private TransactionRepository transactionRepository;
    private WalletMappers walletMappers;
    private WalletService service;
    private TransactionMappers transactionMappers;
    private CurrencyMappers currencyMappers;

    public WalletServicesImpl(WalletRepository walletRepository,
                              CurrencyRepository currencyRepository,
                              TransactionRepository transactionRepository,
                              WalletMappers walletMappers,
                              WalletService service, TransactionMappers transactionMappers,
                              CurrencyMappers currencyMappers) {
        this.walletRepository = walletRepository;
        this.currencyRepository = currencyRepository;
        this.transactionRepository = transactionRepository;
        this.walletMappers = walletMappers;
        this.service = service;
        this.transactionMappers = transactionMappers;
        this.currencyMappers = currencyMappers;
    }


    @Override
    public WalletResponseDTO addWallet(WalletRequestDTO walletRequestDTO) {
        Currency currency = currencyRepository.findById(walletRequestDTO.getCurrency()).orElseThrow(() ->
                new RuntimeException(String.format("Not pass ")));
        Wallet wallet = Wallet.builder()
                .id(UUID.randomUUID().toString())
                .balance(walletRequestDTO.getBalance())
                .currency(currency)
                .userId("tenena")
                .date(System.currentTimeMillis())
                .build();
        Wallet saveWallet = walletRepository.save(wallet);
        WalletResponseDTO walletResponseDTO = walletMappers.fromWallet(saveWallet);
        return walletResponseDTO;
    }

    @Override
    public CurrencyResponseDTO addCurrency(CurrencyRequestDTO currencyRequestDTO) {
        return null;
    }

    @Override
    public TransactionsResponseDTO addTransaction(TransactionsRequestDTO transactionsRequestDTO) {
        return null;
    }

    @Override
    public void loadWallet() throws IOException{
        Stream.of("USD","EUR","AFN","ADA").forEach(c->{
            Currency currency=currencyRepository.findById(c)
                    .orElseThrow(()->new RuntimeException(String.format("Not found")));
            Wallet wallet=new Wallet();
            wallet.setBalance(3000.3);
            wallet.setDate(System.currentTimeMillis());
            wallet.setUserId("John");
            wallet.setId(UUID.randomUUID().toString());
            wallet.setCurrency(currency);
          walletRepository.save(wallet);
        });
     }
     @Override
    public void loadTransaction() throws IOException{





    }
    @Override
    public void loadData() throws IOException {
        URI uri = new ClassPathResource("example-currencies-fr.csv").getURI();
        Path path = Paths.get(uri);
        List<String> lines = Files.readAllLines(path);
        for (int i = 1; i < lines.size(); i++) {
            String[] line = lines.get(i).split(";");
            Currency currency = Currency.builder()
                    .code(line[0])
                    .name(line[1])
                    .salePrice(Double.parseDouble(line[2]))
                    .purchasePrice(Double.parseDouble(line[3]))
                    .symbol("Yac")
                    .build();
            currencyRepository.save(currency);

        }

    }
}