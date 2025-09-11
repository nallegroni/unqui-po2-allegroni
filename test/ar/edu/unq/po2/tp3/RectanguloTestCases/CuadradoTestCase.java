package ar.edu.unq.po2.tp3.RectanguloTestCases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp3.Point;
import ar.edu.unq.po2.tp3.Rectangulo_Ejercicio9.Cuadrado;

class CuadradoTestCase {

	@Test
    public void testAreaYPerimetroCuadrado() {
		Cuadrado c = new Cuadrado(new Point(0,0), 5);
        assertEquals(25, c.getArea());
        assertEquals(20, c.getPerimetro());
    }

}
