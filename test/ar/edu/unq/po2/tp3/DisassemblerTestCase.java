package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DisassemblerTestCase {
	
	Disassembler disassembler;
	ArrayList<Integer> array;
	
	@BeforeEach
	public void setUp() throws Exception {
		disassembler = new Disassembler();
		array = new ArrayList<Integer>();
		
		array.add(26);
		array.add(428);
		array.add(13);
		array.add(8889);
		array.add(1922);
		
	}

	@Test
	public void testDisassembler() {
		int amount = disassembler.numeroConMasDigitosPares(array);
		
		assertEquals(428, amount, "The number with more even digits should be 428");
	}

}
