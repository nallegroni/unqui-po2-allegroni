package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CounterTestCase {
	private Counter counter;
	
	/**
	* Crea un escenario de test básico, que consiste en un contador
	* con 10 enteros
	*
	* @throws Exception
	*/
	@BeforeEach
	public void setUp() throws Exception {
		
		//Se crea el contador
		counter = new Counter();
		
		//Se agregan los numeros. Un solo par y nueve impares
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
	
	//Verifica la cantidad de pares
	@Test
	public void testEvenNumbers() {
		// Getting the even occurrences
		int amount = counter.getEvenOcurrences();
		// I check the amount is the expected one
		assertEquals(1, amount, "There should be 1 even numbers");
	}

	//Verifica la cantidad de impares
	@Test
	void testOddNumbers() {
		int amount = counter.getOddOcurrences();
		assertEquals(9, amount, "There should be 9 odd numbers");
	}
	
	//Verifica la cantidad de multiplos de n
	@Test
	void testMultiple() {
		int multiples = counter.countMultipleOf(2);
		assertEquals(1, multiples, "There should be 1 multiple");
	}

}
