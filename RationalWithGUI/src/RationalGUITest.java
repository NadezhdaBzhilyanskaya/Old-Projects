import static org.junit.Assert.*;

import org.junit.Test;


public class RationalGUITest {

	@Test
	public void testIsNumber() {
		String s1 = "Hello";
		String s2 = "34537265238457262";
		String s3 = "-10";
		String s4 = "62";
		String s5 = "-34537265238457262";
		
		assertFalse(RationalGUI.isNumber(s1));
		assertTrue(RationalGUI.isNumber(s2));
		assertTrue(RationalGUI.isNumber(s3));
		assertTrue(RationalGUI.isNumber(s4));
		assertTrue(RationalGUI.isNumber(s5));
	}

	@Test
	public void testIsTooBig() {
		String s1 = "1034534455";
		String s2 = "-238457262";
		String s3 = "-1034853963";
		String s4 = "62";
		
		assertTrue(RationalGUI.isTooBig(s1));
		assertTrue(RationalGUI.isTooBig(s3));
		assertFalse(RationalGUI.isTooBig(s2));
		assertFalse(RationalGUI.isTooBig(s4));
	}

}
