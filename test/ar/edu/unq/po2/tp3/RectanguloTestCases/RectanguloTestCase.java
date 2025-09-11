package ar.edu.unq.po2.tp3.RectanguloTestCases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp3.Point;
import ar.edu.unq.po2.tp3.Rectangulo_Ejercicio9.Rectangulo;

class RectanguloTestCase {

	private Rectangulo rectangulo;

    @BeforeEach
    public void setUp() {
        rectangulo = new Rectangulo(new Point(0,0), new Point(4,3));
    }

    @Test
    public void testArea() {
        assertEquals(12, rectangulo.getArea());
    }

    @Test
    public void testPerimetro() {
        assertEquals(14, rectangulo.getPerimetro());
    }

    @Test
    public void testOrientacionHorizontal() {
        assertTrue(rectangulo.esHorizontal());
        assertFalse(rectangulo.esVertical());
    }

    @Test
    public void testConstructorInvalido() {
        assertThrows(IllegalArgumentException.class, 
            () -> new Rectangulo(new Point(0,0), new Point(0,5)));
    }
}

