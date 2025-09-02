package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HigherMultipleTestCase {
	
	HigherMultiple higherMultiple;
	
	@BeforeEach
	void setUp() throws Exception {
		higherMultiple = new HigherMultiple();
	}

	@Test
	void test() {
		int number = higherMultiple.HigherMultipleBetween(3, 9);
		
		assertEquals(999, number, "The number should be 999");
	}

}
