package uebung03.polynomial;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PolynomialTest {
    private final Polynomial p1 = new Polynomial(new int[]{1, 2, 3, 4});
    private final Polynomial p2 = new Polynomial(new int[]{0, 0, 0});
    private final Polynomial p3 = new Polynomial(new int[]{3});
    private final Polynomial p4 = new Polynomial();
    private final Polynomial p5 = Polynomial.constant(5);
    private final Polynomial p6 = new Polynomial(new int[]{0, -1, 2, +3, -2, 0, 1});

    @Test
    public void testDegree() {
        assertEquals(3, p1.getDegree());
        assertEquals(0, p2.getDegree());
        assertEquals(0, p3.getDegree());
    }

    @Test
    public void testToString() {
        assertEquals("4*x^3 + 3*x^2 + 2*x + 1", p1.toString());
        assertEquals("0", p2.toString());
        assertEquals("3", p3.toString());
        assertEquals("x", p4.toString());
        assertEquals("5", p5.toString());
        assertEquals("x^6 - 2*x^4 + 3*x^3 + 2*x^2 - x", p6.toString());
    }

    @Test
    public void testAdd() {
        assertEquals("x^6 - 2*x^4 + 7*x^3 + 5*x^2 + x + 1", p1.add(p6).toString());
    }

    @Test
    public void testSub() {
        assertEquals("-x^6 + 2*x^4 + x^3 + x^2 + 3*x + 1", p1.sub(p6).toString());
        assertEquals("0", p6.sub(p6).toString());
    }

    @Test
    public void testMult() {
        assertEquals("16*x^6 + 24*x^5 + 25*x^4 + 20*x^3 + 10*x^2 + 4*x + 1", p1.mult(p1).toString());
        assertEquals("4*x^9 + 3*x^8 - 6*x^7 + 7*x^6 + 13*x^5 + 6*x^4 + 4*x^3 - x", p1.mult(p6).toString());
    }

    @Test
    public void testOverloaded() {
        assertEquals("4*x^3 + 3*x^2 + 2*x + 6", p1.add(5).toString());
        assertEquals("x^6 - 2*x^4 + 3*x^3 + 2*x^2 - x - 5", p6.sub(5).toString());
        assertEquals("20*x^3 + 15*x^2 + 10*x + 5", p1.mult(5).toString());
    }

    @Test
    public void testExp() {
        assertEquals("1024*x^15 + 3840*x^14 + 8320*x^13 + 13280*x^12 + 16660*x^11 + 17203*x^10 + 14970*x^9 + 11085*x^8 + 7040*x^7 + 3830*x^6 + 1772*x^5 + 690*x^4 + 220*x^3 + 55*x^2 + 10*x + 1",
                     p1.exp(5).toString());
    }

    @Test
    public void testApply() {
        assertEquals(1, p1.apply(0));
        assertEquals(10, p1.apply(1));
        assertEquals(49, p1.apply(2));
        assertEquals(3804, p6.apply(4));
    }
}
