import static org.junit.Assert.*;

import org.junit.Test;


public class UtilsTest {

	@Test
	public void testIsNumber() {
		String s1 = "Hello";
		String s2 = "34537265238457262";
		String s3 = "-10";
		String s4 = "62";
		String s5 = "-34537265238457262";
		
		assertFalse(Utils.isNumber(s1));
		assertTrue(Utils.isNumber(s2));
		assertTrue(Utils.isNumber(s3));
		assertTrue(Utils.isNumber(s4));
		assertTrue(Utils.isNumber(s5));
	}

	@Test
	public void testIsTooBig() {
		String s1 = "1034534455";
		String s2 = "-238457262";
		String s3 = "-1034853963";
		String s4 = "62";
		
		assertTrue(Utils.isTooBig(s1));
		assertTrue(Utils.isTooBig(s3));
		assertFalse(Utils.isTooBig(s2));
		assertFalse(Utils.isTooBig(s4));
	}

}
