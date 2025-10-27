package ar.edu.unq.po2.tpComposite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CaballeroTestCase {

    private Mapa mapa;
    private Punto inicio;
    private Caballero caballero;

    @BeforeEach
    void setUp() {
        mapa = new Mapa(10, 10);
        inicio = new Punto(0, 0);
        caballero = new Caballero(inicio, mapa); 
    }

    @Test
    @DisplayName("El caballero debe llegar al destino final")
    void testCaminarLlegaAlDestino() {
        Punto destino = new Punto(3, 4);
        caballero.caminar(destino);
        
        assertEquals(destino, caballero.getUbicacionActual());
    }

    @Test
    @DisplayName("El caballero debe alternar movimiento en X e Y (zigzag)")
    void testCalcularSiguientePasoHaceZigZag() {
        Punto destino = new Punto(2, 2);
        Punto posActual = new Punto(0, 0);

        // Debería moverse en Y (porque 'avanzandoLateralmente' es false al inicio)
        Punto paso1 = caballero.calcularSiguientePaso(posActual, destino);
        assertEquals(new Punto(0, 1), paso1); // Movió en Y
        posActual = paso1;

        // Debería moverse en X
        Punto paso2 = caballero.calcularSiguientePaso(posActual, destino);
        assertEquals(new Punto(1, 1), paso2); // Movió en X
        posActual = paso2;

        // Debería moverse en Y
        Punto paso3 = caballero.calcularSiguientePaso(posActual, destino);
        assertEquals(new Punto(1, 2), paso3); // Movió en Y
        posActual = paso3;
        
        // Debería moverse en X
        Punto paso4 = caballero.calcularSiguientePaso(posActual, destino);
        assertEquals(new Punto(2, 2), paso4); // Movió en X (Destino)
    }
}
