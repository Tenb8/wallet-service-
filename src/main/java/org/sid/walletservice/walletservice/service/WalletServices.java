package org.sid.walletservice.walletservice.service;

import org.sid.walletservice.walletservice.dto.currencyDTO.CurrencyRequestDTO;
import org.sid.walletservice.walletservice.dto.currencyDTO.CurrencyResponseDTO;
import org.sid.walletservice.walletservice.dto.transactionDTO.TransactionsRequestDTO;
import org.sid.walletservice.walletservice.dto.transactionDTO.TransactionsResponseDTO;
import org.sid.walletservice.walletservice.dto.walletDTO.WalletRequestDTO;
import org.sid.walletservice.walletservice.dto.walletDTO.WalletResponseDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface WalletServices {
      WalletResponseDTO addWallet(WalletRequestDTO walletRequestDTO) throws IOException;
    CurrencyResponseDTO addCurrency(CurrencyRequestDTO currencyRequestDTO);
    TransactionsResponseDTO addTransaction(TransactionsRequestDTO transactionsRequestDTO);
    void loadWallet() throws IOException;

    void loadTransaction() throws IOException;

    void   loadData() throws IOException;
}
