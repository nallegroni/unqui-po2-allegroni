package ar.edu.unq.po2.tp2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpresaTestCase {
	
	private Empresa ml;
	private Empleado e1;
	private Empleado e2;
	private Empleado e3;
	
	@BeforeEach
	void setUp() throws Exception {
		ml = new Empresa("Mercado Libre", "30-70308853-4");
		
		e1 = new EmpleadoPermanente("Juan Perez", "Calle 123", "Casado", LocalDate.of(1980, 5, 20), 2000, 2, 10);
        e2 = new EmpleadoTemporal("Ana Gomez", "Av. Siempreviva 742", "Soltera", LocalDate.of(1975, 3, 10), 1800, LocalDate.of(2025, 12, 31), 10);
        e3 = new EmpleadoContratado("Luis Lopez", "San Martín 500", "Soltero", LocalDate.of(1990, 7, 15), 1500, "C-123", "Transferencia");
        
        ml.agregarEmpleado(e1);
        ml.agregarEmpleado(e2);
        ml.agregarEmpleado(e3);
	}
	
	@Test
	public void testCalcularTotalSueldoNeto() {
        double totalNeto = ml.calcularTotalSueldosNetos();

        assertEquals(5295, totalNeto);
    }
	
	@Test
	public void testLiquidacionSueldos() {
		assertTrue(ml.getRecibos().isEmpty());
		
		ml.liquidarSueldos();
		assertEquals(3, ml.getRecibos().size());
	}
	

}
