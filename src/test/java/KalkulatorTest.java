import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class KalkulatorTest {

    private int nilai1 = 3, nilai2 = 4;

    @AfterEach
    void clean() {
        // Untuk reset
        nilai1 = 3;
    }

    @BeforeEach
    void initMethod() {
        // Untuk persiapan
        nilai1 = 3;
    }

    @Test
    void penjumlahanPositif() {
        Kalkulator kalk = new Kalkulator(nilai1,nilai2);
        // excpected value 3+4 adalah 7
        nilai1 = kalk.penjumlahan();
        assertEquals(7, nilai1);
    }

    @Test
    void penjumlahanNegatif() {
        Kalkulator kalk = new Kalkulator(nilai1,nilai2);
        // excpected value -3+(-4) adalah -7
        nilai1 = kalk.penjumlahan();
        assertEquals(7, nilai1);
    }
}