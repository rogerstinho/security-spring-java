package com.fit;

import org.springframework.stereotype.Service;


@Service
public class BankAccountService {

    @PostReadBankAccount
//    @AuthorizeReturnObject
    public BankAccount findById(int id) {
        return new BankAccount(id, "roger", "1234", 15_000_000);
    }

    @PostReadBankAccount
//    @AuthorizeReturnObject
    public BankAccount getById(int id) {
        return findById(id);
    }

    @PreWriteBankAccount("#bankAccount")
    public void save(BankAccount bankAccount) {
        // to be implemented
    }

    @PreWriteBankAccount("#account")
    public void update(BankAccount account) {
        // to be implemented
    }
}
