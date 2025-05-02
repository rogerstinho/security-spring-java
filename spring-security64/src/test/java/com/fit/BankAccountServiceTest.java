package com.fit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authorization.AuthorizationDeniedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest
class BankAccountServiceTest {

    @Autowired
    BankAccountService bankAccountService;


    @Test
    @WithUserRoger
    void findByIdWhenGranted() {
        BankAccount bankAccount = bankAccountService.getById(1);
        assertThat(bankAccount).isNotNull();
    }

    @Test
    @WithUserAccountant
    void findByIdWhenAccountant() {
        BankAccount bankAccount = bankAccountService.getById(1);
        assertThat(bankAccount).isNotNull();
    }

    @Test
    @WithUserRoger
    void getByIdWhenGranted() {
        BankAccount bankAccount = bankAccountService.getById(1);
        assertThat(bankAccount).isNotNull();
    }

    @Test
    @WithUserRoger
    void saveIdWhenGranted() {
        bankAccountService.save(new BankAccount(2, "roger", "123", 1234));
    }

    @Test
    @WithUserAli
    void saveIdWhenDenied() {
        assertThatExceptionOfType(AuthorizationDeniedException.class).isThrownBy(
                () -> bankAccountService.save(new BankAccount(2, "roger", "123", 1234)));
    }

    @Test
    @WithUserRoger
    void updateIdWhenGranted() {
        bankAccountService.save(new BankAccount(2, "roger", "123", 1234));
    }

    @Test
    @WithUserAli
    void updateIdWhenDenied() {
        assertThatExceptionOfType(AuthorizationDeniedException.class)
                .isThrownBy(() -> bankAccountService.save(new BankAccount(2, "roger", "123", 1234)));
    }

    @Test
    @WithUserAccountant
    void findAccountNumberWhenAccountant() {
        BankAccount account = bankAccountService.findById(1);
        assertThat(account.getAccountNumber()).isEqualTo("****");
    }

    @Test
    @WithUserRoger
    void findAccountNumberWhenRob() {
        BankAccount account = bankAccountService.findById(1);
        assertThat(account.getAccountNumber()).isEqualTo("1234");
    }

    @Test
    @WithUserAli
    void findByWhenDenied() {
        assertThatExceptionOfType(AuthorizationDeniedException.class)
                .isThrownBy(() -> bankAccountService.findById(1));
    }

    @Test
    @WithUserAli
    void getByWhenDenied() {
        assertThatExceptionOfType(AuthorizationDeniedException.class)
                .isThrownBy(() -> bankAccountService.getById(1));
    }

}