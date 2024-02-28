import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class KalkulatorTest {

//    private int nilai1 = 3, nilai2 = 4;
    private int nilai1, nilai2;

    @BeforeAll
    void initClass() {

    }

    @BeforeEach
    void initMethod() {
        nilai1 = 3;
        nilai2 = 4;
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