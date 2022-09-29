package org.sid.walletservice.walletservice.mappers;

import org.sid.walletservice.walletservice.dto.transactionDTO.TransactionsResponseDTO;
import org.sid.walletservice.walletservice.entities.WalletTransactions;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TransactionMappers {
    public TransactionsResponseDTO fromTransaction(WalletTransactions walletTransactions){
        TransactionsResponseDTO transactionsResponseDTO=new TransactionsResponseDTO();
        BeanUtils.copyProperties(walletTransactions,transactionsResponseDTO);
        return transactionsResponseDTO;
    }
    public  WalletTransactions toTransaction(TransactionsResponseDTO transactionsResponse){
        WalletTransactions wallet=new WalletTransactions();
        BeanUtils.copyProperties(transactionsResponse,wallet);
        return wallet;
    }
}
