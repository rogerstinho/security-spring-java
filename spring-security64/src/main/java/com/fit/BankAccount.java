package com.fit;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authorization.method.HandleAuthorizationDenied;

@Getter
@Setter
public class BankAccount {
    private final int id;
    private final String owner;
    private final String accountNumber;
    private long balance;

    public BankAccount(int id, String owner, String accountNumber, long balance) {
        this.id = id;
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @PreWriteBankAccount("this")
    @HandleAuthorizationDenied(handlerClass = MaskAuthorizationDeniedHandler.class)
    public String getAccountNumber() {
        return accountNumber;
    }
}
