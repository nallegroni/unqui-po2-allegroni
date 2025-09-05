package ar.edu.unq.po2.tp2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpleadoPermanenteTestCase {
	
	private EmpleadoPermanente empleado;
	
	@BeforeEach
	void setUp() throws Exception {
		empleado = new EmpleadoPermanente("Juan Perez", "Calle 123", "Casado", LocalDate.of(1980, 5, 20), 2000, 2, 10);
	}

	@Test
	void testSueldoNeto() {
		double totalNeto = empleado.calcularSueldoNeto();

        assertEquals(2135, totalNeto);
	}
	
	@Test
	void testSueldoBruto() {
		double totalBruto = empleado.calcularSueldoBruto();

        assertEquals(2900, totalBruto);
	}
	
	@Test
	void testRetenciones() {
		double totalRetenciones = empleado.calcularRetenciones();

        assertEquals(765, totalRetenciones);
	}
}
