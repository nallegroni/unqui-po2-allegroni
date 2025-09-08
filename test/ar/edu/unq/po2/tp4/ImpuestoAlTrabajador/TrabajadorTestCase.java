package ar.edu.unq.po2.tp4.ImpuestoAlTrabajador;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrabajadorTestCase {
	
	Trabajador trabajador;
	Ingreso ingreso1;
	Ingreso ingreso2;
	Ingreso ingreso3;
	IngresoPorHora ingresoPorHora;
	
	@BeforeEach
	void setUp() throws Exception {
		
		trabajador = new Trabajador();
		
		ingreso1 = new Ingreso(12, "Sueldo", 900000);
		ingreso2 = new Ingreso(11, "Sueldo", 900000);
		ingreso3 = new Ingreso(10, "Sueldo", 900000);
		ingresoPorHora = new IngresoPorHora(12, "Horas Extras", 60000, 4);
				
		trabajador.addIngreso(ingreso1);
		trabajador.addIngreso(ingreso2);
		trabajador.addIngreso(ingreso3);
		trabajador.addIngreso(ingresoPorHora);
	}

	@Test
	void testTotalPercibido() {
		double totalPercibido = trabajador.getTotalPercibido();
		assertEquals(2760000, totalPercibido);
	}
	
	@Test
	void testMontoImponible() {
		double montoImponible = trabajador.getTotalMontoImponible();
		assertEquals(2700000, montoImponible);
	}
	
	@Test
	void testImpuestoAPagar() {
		double impuestoAPagar = trabajador.getImpuestoAPagar();
		assertEquals(2700000 * 0.2, impuestoAPagar);
	}

}
