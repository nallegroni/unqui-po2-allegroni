package ar.edu.unq.po2.tp4.ImpuestoAlTrabajador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IngresoTestCase {
	
	Ingreso ingreso;
	IngresoPorHora ingresoPorHora;
	
	@BeforeEach
	void setUp() throws Exception {
		ingreso = new Ingreso(12, "Sueldo", 900000);
		ingresoPorHora = new IngresoPorHora(12, "Horas Extras", 60000, 4);
	}

	@Test
	void testIngreso() {
		assertEquals(900000, ingreso.getMonto());
	}
	
	@Test
	void testIngresoPorHora() {
		assertEquals(60000, ingresoPorHora.getMonto());
	}
	

}
