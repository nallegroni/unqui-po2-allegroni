package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PointTestCase {
	
	private Point p1;
    private Point p2;
	
	@BeforeEach
	void setUp() throws Exception {
		p1 = new Point(3, 4);
        p2 = new Point(1, 2);
	}

	@Test
    public void testConstructorConParametros() {
        assertEquals(3, p1.getX());
        assertEquals(4, p1.getY());
    }

    @Test
    public void testConstructorPorDefecto() {
        Point p = new Point();
        assertEquals(0, p.getX());
        assertEquals(0, p.getY());
    }

    @Test
    public void testMoveTo() {
        p1.moveTo(5, 7);
        assertEquals(5, p1.getX());
        assertEquals(7, p1.getY());
    }

    @Test
    public void testAdd() {
        Point result = p1.add(p2);

        assertEquals(4, result.getX());
        assertEquals(6, result.getY());
    }

    @Test
    public void testAddNoModificaOriginales() {
        Point result = p1.add(p2);

        // p1 y p2 no deben modificarse
        assertEquals(3, p1.getX());
        assertEquals(4, p1.getY());
        assertEquals(1, p2.getX());
        assertEquals(2, p2.getY());

        // el resultado es un objeto distinto
        assertNotSame(p1, result);
        assertNotSame(p2, result);
    }
}
