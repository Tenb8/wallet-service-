package org.sid.walletservice.walletservice.repositories;

import org.sid.walletservice.walletservice.entities.Currency;
import org.sid.walletservice.walletservice.entities.Wallet;
import org.sid.walletservice.walletservice.entities.WalletTransactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface CurrencyRepository extends JpaRepository<Currency,String> {






}
