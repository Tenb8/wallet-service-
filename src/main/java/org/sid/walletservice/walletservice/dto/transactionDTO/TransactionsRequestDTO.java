package org.sid.walletservice.walletservice.dto.transactionDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.walletservice.walletservice.entities.TransactionType;
import org.sid.walletservice.walletservice.entities.Wallet;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionsRequestDTO {
    private  Double amount;
    private TransactionType transactionType;

}
