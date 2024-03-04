import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WalletTest {

    Wallet dompet;

    @BeforeAll
    void initClass() {
        dompet = new Wallet("Kal", new ArrayList<>(), 100);
    }

    @AfterEach
    void cleanup() {
        dompet = new Wallet("Kal", new ArrayList<>(), 100);
    }

    @Test
    void checkWallet() {
        dompet.checkWallet();
    }

    @Test
    void testWithdrawNormal() {
        int initialCash = dompet.getCash();
        int withdrawAmount = 55;
        int expectedCashAfterWithdrawn = initialCash - withdrawAmount;

        dompet.setCash(initialCash);
        dompet.withdraw(withdrawAmount);

        assertEquals(expectedCashAfterWithdrawn, dompet.getCash());
    }

    @Test
    void testWithdrawNegativeAmount() {
        int initialCash = dompet.getCash();
        int withdrawAmount = -150;

        assertThrows(Error.class, () -> {
            dompet.withdraw(withdrawAmount);
        });

        assertEquals(initialCash, dompet.getCash());
    }

    @Test
    void testWithdrawMoreThanBalance() {
        int initialCash = dompet.getCash();
        int withdrawAmount = 150;

        assertThrows(Error.class, () -> {
            dompet.withdraw(withdrawAmount);
        });

        assertEquals(initialCash, dompet.getCash());
    }

    @Test
    void testDepositPositive() {
        int initialCash = dompet.getCash();
        int depositAmount = 50;
        int expectedCashAfterDeposit = initialCash + depositAmount;

        dompet.setCash(initialCash);
        dompet.deposit(depositAmount);

        assertEquals(expectedCashAfterDeposit, dompet.getCash());
    }

    @Test
    void testDepositNegative() {
        int initialCash = dompet.getCash();
        int depositAmount = -50;

        assertThrows(Error.class, () -> {
            dompet.deposit(depositAmount);
        });

        assertEquals(initialCash, dompet.getCash());
    }

    @Test
    void testAddCards() {
        dompet.addCards("ABC", 1234567890);
        dompet.checkWallet();
    }

    @Test
    void testAddExistingCards() {
        dompet.addCards("ABC", 1234567890);
        assertThrows(Error.class, () -> {
            dompet.addCards("ABC", 1234567890);
        });
        checkWallet();
    }

    @Test
    void testRemoveExistingCard() {
        dompet.addCards("ABC", 1234567890);
        dompet.removeCard(1234567890);
        dompet.checkWallet();
    }

    @Test
    void testRemoveNonExistingCard() {
        assertThrows(Error.class, () -> {
            dompet.removeCard(1234567890);
        });
    }

// *    Untuk melakukan test yang berkonflik apabila tidak memakai AfterEach
//    @Test
//    void testAddCards() {
//        dompet.addCards("ABC", 1234567890);
//    }
//
//    @Test
//    void testRemoveExistingCard() {
//        dompet.addCards("ABC", 1234567890);
//        dompet.removeCard(1234567890);
//    }

}