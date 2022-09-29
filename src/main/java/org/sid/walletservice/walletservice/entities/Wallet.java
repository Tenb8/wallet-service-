package org.sid.walletservice.walletservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity @Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Wallet {
@Id
    private String id;
    private Double balance;
    private Long date;
    private  String userId;
    @ManyToOne
    private  Currency currency;
    @OneToMany(mappedBy = "wallet")
    private List<WalletTransactions> transactionsList;

}
