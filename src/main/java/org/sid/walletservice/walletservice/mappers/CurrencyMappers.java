package org.sid.walletservice.walletservice.mappers;

import org.sid.walletservice.walletservice.dto.currencyDTO.CurrencyRequestDTO;
import org.sid.walletservice.walletservice.dto.currencyDTO.CurrencyResponseDTO;
import org.sid.walletservice.walletservice.dto.walletDTO.WalletResponseDTO;
import org.sid.walletservice.walletservice.entities.Currency;
import org.sid.walletservice.walletservice.entities.Wallet;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CurrencyMappers {
    public CurrencyResponseDTO fromCurrency(Currency currency){
        CurrencyResponseDTO currencyRequestDTO=new CurrencyResponseDTO();
        BeanUtils.copyProperties(currency,currencyRequestDTO);
        return currencyRequestDTO;
    }
    public  Currency toCurrency(CurrencyResponseDTO currencyResponseDTO){
        Currency currency=new Currency();
        BeanUtils.copyProperties(currencyResponseDTO,currency);
        return currency;
    }
}
