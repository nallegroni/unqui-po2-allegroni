package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HigherMultipleTestCase {

	HigherMultiple hm;
	
	@BeforeEach
	public void setUp() throws Exception {
		// Se crea el higherMultiple.
		hm = new HigherMultiple();
	}
	
	@Test
	void testHigherMultiple() {
		assertEquals(999, hm.higherMultipleOf(3, 9), "The result should be 999");
		assertEquals(910, hm.higherMultipleOf(7, 13), "The result should be 1000");
	}
	
	@Test
	void testNoHigherMultiple() {
		assertEquals(-1, hm.higherMultipleOf(1001, 1002), "The result should be -1");
	}

}
