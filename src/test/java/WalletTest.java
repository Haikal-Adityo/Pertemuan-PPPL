import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {
    Wallet dompet = new Wallet("Kal", new ArrayList<>(), 100);

    @Test
    void checkWallet() {
        dompet.checkWallet();
    }

    @Test
    void withdrawNormal() {
        int initialCash = dompet.getCash();
        int withdrawAmount = 55;
        int expectedCashAfterWithdrawn = initialCash - withdrawAmount;

        dompet.setCash(initialCash);
        dompet.withdraw(withdrawAmount);

        assertEquals(expectedCashAfterWithdrawn, dompet.getCash());
    }

    @Test
    void withdrawNegativeAmount() {
        int initialCash = dompet.getCash();
        int withdrawAmount = -150;

        assertThrows(Error.class, () -> {
            dompet.withdraw(withdrawAmount);
        });

        assertEquals(initialCash, dompet.getCash());
    }

    @Test
    void withdrawMoreThanBalance() {
        int initialCash = dompet.getCash();
        int withdrawAmount = 150;

        assertThrows(Error.class, () -> {
            dompet.withdraw(withdrawAmount);
        });

        assertEquals(initialCash, dompet.getCash());
    }

    @Test
    void depositPositive() {
        int initialCash = dompet.getCash();
        int depositAmount = 50;
        int expectedCashAfterDeposit = initialCash + depositAmount;

        dompet.setCash(initialCash);
        dompet.deposit(depositAmount);

        assertEquals(expectedCashAfterDeposit, dompet.getCash());
    }

    @Test
    void depositNegative() {
        int initialCash = dompet.getCash();
        int depositAmount = -50;

        assertThrows(Error.class, () -> {
            dompet.deposit(depositAmount);
        });

        assertEquals(initialCash, dompet.getCash());
    }

    @Test
    void addCards() {
        dompet.addCards("ABC", 1234567890);
        checkWallet();
    }

    @Test
    void addExistingCards() {
        dompet.addCards("ABC", 1234567890);
        assertThrows(Error.class, () -> {
            dompet.addCards("ABC", 1234567890);
        });
        checkWallet();
    }

    @Test
    void removeCardExisting() {
        dompet.addCards("ABC", 1234567890);
        dompet.removeCard(1234567890);
    }

    @Test
    void removeCardNotExisting() {
        assertThrows(Error.class, () -> {
            dompet.removeCard(1234567890);
        });
    }

}