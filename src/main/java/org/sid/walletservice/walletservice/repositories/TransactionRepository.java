package org.sid.walletservice.walletservice.repositories;

import org.sid.walletservice.walletservice.entities.WalletTransactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TransactionRepository extends JpaRepository<WalletTransactions,Long> {
}
