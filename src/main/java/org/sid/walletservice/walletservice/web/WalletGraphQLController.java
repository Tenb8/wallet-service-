package org.sid.walletservice.walletservice.web;

import org.sid.walletservice.walletservice.dto.walletDTO.WalletRequestDTO;
import org.sid.walletservice.walletservice.entities.Wallet;
import org.sid.walletservice.walletservice.repositories.WalletRepository;
import org.sid.walletservice.walletservice.service.WalletService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class WalletGraphQLController {
    private WalletRepository walletRepository;
    private WalletService walletService;

    public WalletGraphQLController(WalletRepository walletRepository, WalletService walletService) {
        this.walletRepository = walletRepository;
        this.walletService = walletService;
    }
    @QueryMapping
    public List<Wallet> userWallets(){
        return walletRepository.findAll();
    }
    @QueryMapping
    public  Wallet walletById(@Argument String id){
        return walletRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("wallet %s not found")));
    }
    @MutationMapping
public Wallet saveWallet( @Argument WalletRequestDTO walletRequestDTO){
        return  walletService.addWallet(walletRequestDTO);
}

}
