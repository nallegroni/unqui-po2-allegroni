package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MultioperadorTestCase {
	
	Multioperador multioperador;
	ArrayList<Integer> array;

	@BeforeEach
	void setUp() throws Exception {
		multioperador = new Multioperador();
		array = new ArrayList<Integer>();
		
		array.add(2);
		array.add(3);
		array.add(0);
		array.add(4);
		
	}

	@Test
	void testSuma() {
		int suma = multioperador.sumar(array);
		assertEquals(9, suma, "The number should be 9");
	}
	
	void testResta() {
		int resta = multioperador.restar(array);
		assertEquals(-5, resta, "The number should be -5");
	}
	
	void testMultiplicacion() {
		int multiplicacion = multioperador.multiplicar(array);
		assertEquals(0, multiplicacion, "The number should be 0");
	}

}
