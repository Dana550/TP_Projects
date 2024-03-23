package org.example.Model;

import junit.framework.TestCase;

public class MonomialTest extends TestCase {

    public void testGetExponent() {

        Monomial m1=new Monomial(3, 7);
        assertEquals(3, m1.getExponent());

        Monomial m2=new Monomial(3, 7);
        assertEquals(3, m2.getExponent());

        Monomial m3=new Monomial(3, 7);
        assertEquals(3, m3.getExponent());
    }

    public void testGetCoefficient() {
        Monomial m1=new Monomial(2,4);
        assertEquals(4.0, m1.getCoefficient());

        Monomial m2=new Monomial(5,6);
        assertEquals(6.0, m2.getCoefficient());

        Monomial m3=new Monomial(8,4);
        assertEquals(4.0, m3.getCoefficient());
    }

    public void testSetExponent() {
        Monomial m1=new Monomial(3,2);
        m1.setCoefficient(6);
        assertEquals(6.0, m1.getCoefficient());
    }
    public void testSetCoefficient() {
        Monomial m1=new Monomial(3,2);
        m1.setCoefficient(6);
        assertEquals(6.0, m1.getCoefficient());

    }
    public void testAddMonom() {

        Monomial m1=new Monomial(4,3);
        Monomial m2=new Monomial(4,7);
        m1.addMonom(m2);
        assertEquals(m1.toString(),"+10.0x^4");

    }

    public void testSubMonom() {
        Monomial m1=new Monomial(4,3);
        Monomial m2=new Monomial(4,7);
        m1.subMonom(m2);
        assertEquals(m1.toString(),"-4.0x^4");
    }

    public void testMulMonom() {
        Monomial m1=new Monomial(4,3);
        Monomial m2=new Monomial(4,7);
        m1.mulMonom(m2);
        assertEquals(m1.toString(),"+21.0x^8");
    }

}


