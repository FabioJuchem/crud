package br.com.fabio.domain;

import br.com.fabio.crud.domain.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    private Account account;

    private Account anotherAccount;

    @BeforeEach
    void setUp() {
        this.account = new Account();
        this.anotherAccount = new Account();
        account.setBalance(100.0);
        anotherAccount.setBalance(100.0);
    }

    @Test
    void shouldDeposit() {
        account.deposit(100.0);
        assertEquals(200.0, account.getBalance(), 000001);
    }

    @Test
    void shouldWithdraw() {
        account.withDraw(50.0);
        assertEquals(50.0, account.getBalance(), 000001);
    }

    @Test
    void shouldTransfer() {
        account.transfer(80.0, anotherAccount);
        assertEquals(20.0, account.getBalance(), 000001);
        assertEquals(180.0, anotherAccount.getBalance(), 000001);
    }

}
