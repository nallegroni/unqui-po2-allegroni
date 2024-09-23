package ar.edu.unq.po3.tp3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp3.Disassembler;

class DisassemblerTestCase {

	Disassembler disassembler;
	ArrayList<Integer> array;
	
	@BeforeEach
	public void setUp() throws Exception {
		// Se crea el disassembler.
		disassembler = new Disassembler();
		// Se crea el array.
		array = new ArrayList<Integer>();
		// Se agregan los numeros al array.
		array.add(150);
		array.add(46);
		array.add(7777);
		array.add(143);
		}

	@Test
	public void testNumberWithMoreEvenDigits() {
		assertEquals(46, disassembler.getNumberWithMoreEvenDigits(array), "The number with more even digits should be 46");
		
	}
}
