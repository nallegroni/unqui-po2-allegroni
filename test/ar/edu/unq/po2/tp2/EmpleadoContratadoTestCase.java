package ar.edu.unq.po2.tp2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpleadoContratadoTestCase {

private EmpleadoContratado empleado;
	
	@BeforeEach
	void setUp() throws Exception {
		empleado = new EmpleadoContratado("Luis Lopez", "San Martín 500", "Soltero", LocalDate.of(1990, 7, 15), 1500, "C-123", "Transferencia");
	}

	@Test
	void testSueldoNeto() {
		double totalNeto = empleado.calcularSueldoNeto();

        assertEquals(1450, totalNeto);
	}
	
	@Test
	void testSueldoBruto() {
		double totalBruto = empleado.calcularSueldoBruto();

        assertEquals(1500, totalBruto);
	}
	
	@Test
	void testRetenciones() {
		double totalRetenciones = empleado.calcularRetenciones();

        assertEquals(50, totalRetenciones);
	}

}
