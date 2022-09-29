package org.sid.walletservice.walletservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data @AllArgsConstructor @NoArgsConstructor @Builder
//@Inheritance( strategy = InheritanceType.SINGLE_TABLE)
public class WalletTransactions {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  Long date;
    private  Double amount;
    @ManyToOne
    private Wallet wallet;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

}
