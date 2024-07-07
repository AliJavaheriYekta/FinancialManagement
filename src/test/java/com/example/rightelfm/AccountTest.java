package com.example.rightelfm;

import com.example.rightelfm.models.Account;
import com.example.rightelfm.models.User;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {

    private Account account;
    private User mockUser;

    @BeforeEach
    public void setUp() {
        mockUser = mock(User.class); // Mocking the User entity
        account = new Account();
        account.setId(1L);
        account.setAccountNo("ACC001");
        account.setAccountName("Savings Account");
        account.setAccountBalance(1000.0);
        account.setUser(mockUser);
    }

    @Test
    public void testAccountEntity() {
        assertEquals(1L, account.getId());
        assertEquals("ACC001", account.getAccountNo());
        assertEquals("Savings Account", account.getAccountName());
        assertEquals(1000.0, account.getAccountBalance());
        assertEquals(mockUser, account.getUser()); // Validate the User relationship
    }

    @Test
    public void testSettersAndGetters() {
        account.setAccountNo("ACC002");
        account.setAccountName("Checking Account");
        account.setAccountBalance(1500.0);

        assertEquals("ACC002", account.getAccountNo());
        assertEquals("Checking Account", account.getAccountName());
        assertEquals(1500.0, account.getAccountBalance());
    }
}

