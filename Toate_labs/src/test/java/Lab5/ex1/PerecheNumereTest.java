package Lab5.ex1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PerecheNumereTest {

    @Test
    void isConsecutive() {
        PerecheNumere p = new PerecheNumere(1, 2);
        assertEquals(true,p.isConsecutive());
    }

    @Test
    void isConsecutive1() {
        PerecheNumere p = new PerecheNumere(1, 2);
        assertTrue(p.isConsecutive()==true);
    }

    @Test
    void isConsecutive2() {
        PerecheNumere p = new PerecheNumere(1, 2);
        assertFalse(p.isConsecutive()!=true);
    }

    @Test
    void cmmdc() {
        PerecheNumere p = new PerecheNumere(1, 2);
        assertEquals(1,p.cmmdc());
    }

    @Test
    void cmmdc1() {
        PerecheNumere p = new PerecheNumere(1, 2);
        assertTrue(p.cmmdc()==1);
    }

    @Test
    void cmmdc2() {
        PerecheNumere p = new PerecheNumere(1, 2);
        assertFalse(p.cmmdc()!=1);
    }


    @Test
    void isSumaCifrelorEgala() {
        PerecheNumere p = new PerecheNumere(1, 2);
        assertEquals(false,p.isSumaCifrelorEgala());
    }

    @Test
    void isSumaCifrelorEgala1() {
        PerecheNumere p = new PerecheNumere(1, 2);
        assertTrue(p.isSumaCifrelorEgala()==false);
    }

    @Test
    void isSumaCifrelorEgala2() {
        PerecheNumere p = new PerecheNumere(1, 2);
        assertFalse(p.isSumaCifrelorEgala()!=false);
    }

    @Test
    void isNumarCifrePareEgale() {
        PerecheNumere p = new PerecheNumere(1, 2);
        assertEquals(false,p.isNumarCifrePareEgale());
    }

    @Test
    void isNumarCifrePareEgale2() {
        PerecheNumere p = new PerecheNumere(1, 2);
        assertTrue(p.isNumarCifrePareEgale()==false);
    }

    @Test
    void isNumarCifrePareEgale1() {
        PerecheNumere p = new PerecheNumere(1, 2);
        assertFalse(p.isNumarCifrePareEgale()!=false);
    }
}