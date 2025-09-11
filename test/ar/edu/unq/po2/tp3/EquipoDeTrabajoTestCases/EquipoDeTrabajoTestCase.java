package ar.edu.unq.po2.tp3.EquipoDeTrabajoTestCases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp3.EquipoDeTrabajo_Ejercicio11.*;

class EquipoDeTrabajoTestCase {

	    EquipoDeTrabajo equipo;

	    @BeforeEach
	    public void setUp() {
	        equipo = new EquipoDeTrabajo("Dev team");
	    }

	    @Test
	    public void testCrearPersona() {
	        Persona person = new Persona("Julia", "Martinez", 25);

	        assertEquals("Julia", person.getNombre());
	        assertEquals("Martinez", person.getApellido());
	        assertEquals(25, person.getEdad());
	    }

	    @Test
	    public void testAgregarIntegrantesYPromedioEdad() {
	        equipo.agregarIntegrante(new Persona("Julia", "Martinez", 25));
	        equipo.agregarIntegrante(new Persona("Alberto", "Rodriguez", 30));
	        equipo.agregarIntegrante(new Persona("Carlos", "Silva", 28));
	        equipo.agregarIntegrante(new Persona("Florencia", "Miranda", 35));
	        equipo.agregarIntegrante(new Persona("Eva", "Fuentes", 40));

	        // El promedio esperado = (25 + 30 + 28 + 35 + 40) / 5 = 31.6
	        double promedioEsperado = (25 + 30 + 28 + 35 + 40) / 5;

	        assertEquals(promedioEsperado, equipo.getPromedioEdad());
	    }

	    @Test
	    public void testPromedioEdadEquipoVacio() {
	        assertEquals(0.0, equipo.getPromedioEdad());
	    }
}
