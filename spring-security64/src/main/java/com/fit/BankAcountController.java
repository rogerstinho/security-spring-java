package com.fit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankAcountController {

    private final BankAccountService bankAccountService;

    public BankAcountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/account/{id}")
    BankAccount findbyId(@PathVariable int id) {
        return bankAccountService.findById(id);
    }
}
