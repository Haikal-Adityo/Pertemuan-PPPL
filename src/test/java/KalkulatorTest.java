import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KalkulatorTest {

    @Test
    void penjumlahanPositif() {
        Kalkulator kalk = new Kalkulator(3,4);
        // excpected value 3+4 adalah 7
        int hasil = kalk.penjumlahan();
        assertEquals(7, hasil);
    }

    @Test
    void penjumlahanNegatif() {
        Kalkulator kalk = new Kalkulator(-3,-4);
        // excpected value -3+(-4) adalah -7
        int hasil = kalk.penjumlahan();
        assertEquals(-7, hasil);
    }
}