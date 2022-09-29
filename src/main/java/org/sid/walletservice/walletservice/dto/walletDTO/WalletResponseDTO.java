package org.sid.walletservice.walletservice.dto.walletDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.walletservice.walletservice.entities.Currency;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WalletResponseDTO {
    private String id;
    private Double balance;
    private Long date;
    private  String userId;
    private Currency currency;

}
