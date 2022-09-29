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
public class TransactionsResponseDTO {
    private Long id;
    private  Long date;
    private  Double amount;

    private Wallet wallet;

    private TransactionType transactionType;

}
