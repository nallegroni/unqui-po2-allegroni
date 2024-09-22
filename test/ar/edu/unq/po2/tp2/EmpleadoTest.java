package ar.edu.unq.po2.tp2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class EmpleadoTest {

	Empresa ml;
	PlantaPermanente lucas;
	PlantaTemporaria juan;
	Contratado nico;
	
	@BeforeEach
	@Test
	void setup() throws Exception {
		lucas = new PlantaPermanente("lucas","Martinez 146", "Soltero", LocalDate.of(1999, 01, 04), 700000, 1, 25);
		juan = new PlantaTemporaria("juan","Conesa 755", "Soltero", LocalDate.of(2002, 01, 17), 700000, LocalDate.of(2024, 12, 24), 15);
		nico = new Contratado("nico", "mitre 55", "Casado", LocalDate.of(2000, 05, 21), 750000, 2500, "Cheque");
		ml = new Empresa("mercadolibre", 2068794689);
		ml.contratarEmpleado(juan);
		ml.contratarEmpleado(lucas);
		ml.contratarEmpleado(nico);
	}

	@Test
	void edadesDeEmpleados() {
		assertEquals(22, juan.getEdad());
	}
	
	@Test
	void valoresPlantaPermanente() {
		assertEquals(701400, lucas.sueldoBruto());
		assertEquals(175370, lucas.retenciones());
		assertEquals(526030, lucas.sueldoNeto());
	}
	
	@Test
	void valoresPlantaTemporaria() {
		assertEquals(700600, juan.sueldoBruto());
		assertEquals(140195, juan.retenciones());
		assertEquals(560405, juan.sueldoNeto());
	}
	
	@Test
	void valoresContratado() {
		assertEquals(750000, nico.sueldoBruto());
		assertEquals(50, nico.retenciones());
		assertEquals(749950, nico.sueldoNeto());
	}
	
	@Test
	void sizeRecibosHaberes() {
		ml.liquidacionDeSueldos();
		assertEquals(ml.getRecibosDeHaberes().size(), 3);
	}
}



