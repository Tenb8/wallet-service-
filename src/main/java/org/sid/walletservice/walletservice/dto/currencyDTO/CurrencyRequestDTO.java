package org.sid.walletservice.walletservice.dto.currencyDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyRequestDTO {


    private String name;
    private  String symbol;
    private  Double salePrice;
    private  Double purchasePrice;
}
