package org.sid.walletservice.walletservice.repositories;

import org.sid.walletservice.walletservice.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Currency;
import java.util.List;

@RepositoryRestResource
public interface WalletRepository extends JpaRepository<Wallet,String> {
//    @RestResource(path = "/byCurrency")
//    List<Wallet> findByUserId(@Param("u") String userId);

}
