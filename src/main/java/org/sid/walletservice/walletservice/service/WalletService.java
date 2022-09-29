package org.sid.walletservice.walletservice.service;

import org.sid.walletservice.walletservice.dto.walletDTO.WalletRequestDTO;
import org.sid.walletservice.walletservice.entities.Currency;
import org.sid.walletservice.walletservice.entities.TransactionType;
import org.sid.walletservice.walletservice.entities.Wallet;
import org.sid.walletservice.walletservice.entities.WalletTransactions;
import org.sid.walletservice.walletservice.repositories.CurrencyRepository;
import org.sid.walletservice.walletservice.repositories.TransactionRepository;
import org.sid.walletservice.walletservice.repositories.WalletRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
public class WalletService {
    private CurrencyRepository currencyRepository;
    private WalletRepository walletRepository;
    private TransactionRepository transactionRepository;
    public WalletService(CurrencyRepository currencyRepository, WalletRepository walletRepository, TransactionRepository transactionRepository) {
        this.currencyRepository = currencyRepository;
        this.walletRepository = walletRepository;
        this.transactionRepository = transactionRepository;
    }


    public  void   loadData() throws IOException {
        URI uri=new ClassPathResource("example-currencies-fr.csv").getURI();
        Path path= Paths.get(uri);
       List<String>lines= Files.readAllLines(path);
        for (int i = 1; i <lines.size() ; i++) {
            String []line  =lines.get(i).split(";");
            Currency currency =Currency.builder()
                    .code(line[0])
                    .name(line[1])
                    .salePrice(Double.parseDouble( line[2]))
                    .purchasePrice(Double.parseDouble(line[3]))
                    .symbol(line[4])
                    .build();

            currencyRepository.save(currency);
        }

            Stream.of("USD","EUR","AFN","ADA").forEach(currencyCode->{
                Currency currency= currencyRepository.findById(currencyCode)
                 .orElseThrow(()->new RuntimeException(String.format( "Currency %s not found",currencyCode)));

                    Wallet wallet = Wallet.builder()
                            .id(UUID.randomUUID().toString())
                            .balance(1000 * Math.random())
                            .currency(currency)
                            .date(System.currentTimeMillis())
                            .userId("user1")
                            .build();

                    walletRepository.save(wallet);

            });

walletRepository.findAll().forEach(wallet->{



        WalletTransactions debiTransactions = WalletTransactions.builder()
                .date(System.currentTimeMillis())
                .amount(10 * Math.random())
                .wallet(wallet)
                .transactionType(TransactionType.DEBIT )
                .build();
        transactionRepository.save(debiTransactions);
        wallet.setBalance(wallet.getBalance()-debiTransactions.getAmount());
walletRepository.save(wallet);

        WalletTransactions creditTransactions = WalletTransactions.builder()
//                .id(Long.parseLong(UUID.randomUUID().toString()))
                .amount(10 * Math.random())
                .wallet(wallet)
                .date(System.currentTimeMillis())
                .transactionType(TransactionType.CREDIT )
                .build();
        transactionRepository.save(creditTransactions);
        wallet.setBalance(wallet.getBalance()+creditTransactions.getAmount());
        walletRepository.save(wallet);

});
    }
    public void loadWallet() {
        Stream.of("USD","EUR","AFN","ADA").forEach(c->{
            Currency currency=currencyRepository.findById(c)
                    .orElseThrow(()->new RuntimeException(String.format("Not found")));
            Wallet wallet=new Wallet();
            wallet.setBalance(3000.3);
            wallet.setId(UUID.randomUUID().toString());
            wallet.setCurrency(currency);
            walletRepository.save(wallet);
        });

        walletRepository.findAll().forEach(wallet->{



            WalletTransactions debiTransactions = WalletTransactions.builder()
                    .date(System.currentTimeMillis())
                    .amount(10 * Math.random())
                    .wallet(wallet)
                    .transactionType(TransactionType.DEBIT )
                    .build();
            transactionRepository.save(debiTransactions);
            wallet.setBalance(wallet.getBalance()-debiTransactions.getAmount());
            walletRepository.save(wallet);

            WalletTransactions creditTransactions = WalletTransactions.builder()
//                .id(Long.parseLong(UUID.randomUUID().toString()))
                    .amount(10 * Math.random())
                    .wallet(wallet)
                    .date(System.currentTimeMillis())
                    .transactionType(TransactionType.CREDIT )
                    .build();
            transactionRepository.save(creditTransactions);
            wallet.setBalance(wallet.getBalance()+creditTransactions.getAmount());
            walletRepository.save(wallet);

        });
    }
        public Wallet addWallet(WalletRequestDTO walletDto){
        Currency currency=currencyRepository.findById(walletDto.getCurrency()).orElseThrow(
                ()->new RuntimeException(String.format("currency  %s not found"))
        );
            Wallet wallet=new Wallet();
            wallet.setBalance(walletDto.getBalance());
            wallet.setCurrency(currency);
            wallet.setId(UUID.randomUUID().toString());
            wallet.setDate(System.currentTimeMillis());
       Wallet w=     walletRepository.save(wallet);
            return w;

    }
}
