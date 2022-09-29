package org.sid.walletservice.walletservice.mappers;

import org.sid.walletservice.walletservice.dto.transactionDTO.TransactionsResponseDTO;
import org.sid.walletservice.walletservice.dto.walletDTO.WalletResponseDTO;
import org.sid.walletservice.walletservice.entities.Wallet;
import org.sid.walletservice.walletservice.entities.WalletTransactions;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class WalletMappers {
    public WalletResponseDTO fromWallet(Wallet wallet){
    WalletResponseDTO walletResponseDTO=new WalletResponseDTO();
        BeanUtils.copyProperties(wallet,walletResponseDTO);
        return walletResponseDTO;
    }
    public  Wallet toWallet(WalletResponseDTO walletResponseDTO){
        Wallet wallet=new Wallet();
        BeanUtils.copyProperties(wallet,walletResponseDTO);
        return wallet;
    }
}
