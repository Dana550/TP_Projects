package org.example.Model;

import junit.framework.TestCase;

public class OperationsTest extends TestCase {

    public void testAdd() {
        Monomial m1=new Monomial(2, 3);
        Monomial m2=new Monomial(1, 2);
        Polynomial pol1=new Polynomial();
        Polynomial pol2=new Polynomial();
        pol1.addMonomToPolynom(m1);
        pol1.addMonomToPolynom(m2);
        pol2.addMonomToPolynom(m1);

        Polynomial res1=new Polynomial();
        res1=Operations.add(pol1,pol2);
        assertEquals(res1.toString(), "+6.0x^2+2.0x^1");

    }

    public void testSub() {
        Monomial m1=new Monomial(2, 3);
        Monomial m2=new Monomial(1, 2);
        Polynomial pol1=new Polynomial();
        Polynomial pol2=new Polynomial();
        pol1.addMonomToPolynom(m1);
        pol1.addMonomToPolynom(m2);
        pol2.addMonomToPolynom(m1);

        Polynomial res1=new Polynomial();
        res1=Operations.sub(pol1,pol2);
        assertEquals(res1.toString(), "+2.0x^1");
    }

    public void testMul() {
        Monomial m1=new Monomial(2, 3);
        Monomial m2=new Monomial(1, 2);
        Polynomial pol1=new Polynomial();
        Polynomial pol2=new Polynomial();
        pol1.addMonomToPolynom(m1);
        pol1.addMonomToPolynom(m2);
        pol2.addMonomToPolynom(m1);

        Polynomial res1=new Polynomial();
        res1=Operations.mul(pol1,pol2);
        assertEquals(res1.toString(), "+9.0x^4+6.0x^3");
    }

    public void testDeriv() {
        Monomial m1=new Monomial(2, 3);
        Monomial m2=new Monomial(1, 2);
        Polynomial pol1=new Polynomial();
        pol1.addMonomToPolynom(m1);
        pol1.addMonomToPolynom(m2);

        Polynomial res1=new Polynomial();
        res1=Operations.deriv(pol1);
        assertEquals(res1.toString(), "+6.0x^1+2.0x^0");
    }

    public void testInteg() {
        Monomial m1=new Monomial(3, 3);
        Monomial m2=new Monomial(2, 3);
        Polynomial pol1=new Polynomial();
        pol1.addMonomToPolynom(m1);
        pol1.addMonomToPolynom(m2);

        Polynomial res1=new Polynomial();
        res1=Operations.integ(pol1);
        assertEquals(res1.toString(), "+0.75x^4+0.75x^3");
    }
}