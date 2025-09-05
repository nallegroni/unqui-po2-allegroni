package ar.edu.unq.po2.tp2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpleadoTemporalTestCase {

private EmpleadoTemporal empleado;
	
	@BeforeEach
	void setUp() throws Exception {
		empleado = new EmpleadoTemporal("Ana Gomez", "Av. Siempreviva 742", "Soltera", LocalDate.of(1975, 3, 10), 1800, LocalDate.of(2025, 12, 31), 10);
	}

	@Test
	void testSueldoNeto() {
		double totalNeto = empleado.calcularSueldoNeto();

        assertEquals(1710, totalNeto);
	}
	
	@Test
	void testSueldoBruto() {
		double totalBruto = empleado.calcularSueldoBruto();

        assertEquals(2200, totalBruto);
	}
	
	@Test
	void testRetenciones() {
		double totalRetenciones = empleado.calcularRetenciones();

        assertEquals(490, totalRetenciones);
	}

}
