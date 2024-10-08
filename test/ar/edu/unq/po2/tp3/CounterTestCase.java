package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CounterTestCase {

	Counter counter;
	
	@BeforeEach
	public void setUp() throws Exception {
		// Se crea el contador.
		counter = new Counter();
		// Se agregan los numeros. Un solo par y nueve impares.
		counter.addNumber(1);
		counter.addNumber(3);
		counter.addNumber(5);
		counter.addNumber(7);
		counter.addNumber(9);
		counter.addNumber(1);
		counter.addNumber(1);
		counter.addNumber(1);
		counter.addNumber(1);
		counter.addNumber(4);
		}
			
	@Test
	void testEvenNumbers() {
		int amount = counter.getEvenOcurrences();
		assertEquals(1, amount, "There should be 1 even number");
	}

	@Test
	void testOddNumbers() {
		int amount = counter.getOddOcurrences();
		assertEquals(9, amount, "There should be 9 odd numbers");
	}
	
	@Test
	void testMultiple() {
		int multiples = counter.getMultipleOf(2);
		assertEquals(1, multiples, "There should be 1 multiple");
	}
	
}
