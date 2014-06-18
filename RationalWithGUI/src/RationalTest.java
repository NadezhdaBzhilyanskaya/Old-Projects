import static org.junit.Assert.*;

import org.junit.Test;


public class RationalTest {
	
	@Test(expected=java.lang.IllegalArgumentException.class)
	public void testRationalCtorFromString() {
		Rational number = new Rational("1", "0");
	}

	@Test
	public void testSimplify() {
		Rational r1 = new Rational(2,4);
		Rational r2 = new Rational(1,2);
		Rational r3 = new Rational(1,3);
		Rational r4 = r1.simplify();
		Rational r5 = new Rational(-5,-10);
		Rational r6 = new Rational(1,-3);
		Rational r7 = new Rational(-1,3);
		Rational r8 = r5.simplify();
		Rational r9 = r6.simplify();
		
		assertTrue(r4.equals(r2));
		assertTrue(r8.equals(r2));
		assertTrue(r9.equals(r7));
		assertFalse(r4.equals(r3));
	}

	@Test
	public void testSubtract() {
		Rational r1 = new Rational(1,2);
		Rational r2 = new Rational(1,4);
		Rational r3 = new Rational(1,4);
		Rational r5 = r1.subtract(r2);
		
		assertTrue(r5.equals(r3));
	}
	

	@Test
	public void testAdd() {
		Rational r1 = new Rational(1,2);
		Rational r2 = new Rational(1,4);
		Rational r3 = new Rational(3,4);
		Rational r4 = new Rational(1,3);
		Rational r5 = r1.add(r2);
		
		assertTrue(r5.equals(r3));
		assertFalse(r5.equals(r4));
	}

	@Test
	public void testMultiply() {
		Rational r1 = new Rational(1,2);
		Rational r2 = new Rational(1,4);
		Rational r3 = new Rational(1,8);
		Rational r5 = r1.multiply(r2);
		
		assertTrue(r5.equals(r3));
	}

	@Test
	public void testDivide() {
		Rational r1 = new Rational(1,2);
		Rational r2 = new Rational(1,4);
		Rational r3 = new Rational(2,1);
		Rational r5 = r1.divide(r2);

		assertTrue(r5.equals(r3));
	}
	
	@Test
	public void testequals() {
		Rational r1 = new Rational(33,44);
		Rational r2 = new Rational(1,44);
		Rational r3 = new Rational(33,44);
		
		assertFalse(r1.equals(r2));
	}
	
	@Test
	public void testequalsDifferentRepresentation() {
		Rational r1 = new Rational(33,44);
		Rational r2 = new Rational(33*123,44*123);
		
		assertTrue(r1.equals(r2));
	}

}
