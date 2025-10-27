package ar.edu.unq.po2.tpComposite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IngenieroTestCase {

    private Mapa mapa;
    private Punto inicio;

    @BeforeEach
    void setUp() {
        mapa = new Mapa(10, 10); 
        inicio = new Punto(0, 0);
    }

    @Test
    @DisplayName("El ingeniero debe moverse en diagonal (ruta corta)")
    void testCalcularSiguientePasoRutaCorta() {
        Ingeniero ingeniero = new Ingeniero(inicio, mapa, 20);
        Punto destino = new Punto(5, 5);

        Punto paso1 = ingeniero.calcularSiguientePaso(new Punto(0, 0), destino);
        assertEquals(new Punto(1, 1), paso1);

        Punto paso2 = ingeniero.calcularSiguientePaso(paso1, destino);
        assertEquals(new Punto(2, 2), paso2);
    }

    @Test
    @DisplayName("El ingeniero debe llegar al destino final")
    void testCaminarLlegaAlDestino() {
        Ingeniero ingeniero = new Ingeniero(inicio, mapa, 20);
        Punto destino = new Punto(3, 3);
        
        ingeniero.caminar(destino);
        
        assertEquals(destino, ingeniero.getUbicacionActual());
    }

    @Test
    @DisplayName("El ingeniero debe colocar lajas mientras camina")
    void testCaminarColocaLajas() {
        Ingeniero ingeniero = new Ingeniero(inicio, mapa, 20); // Tiene 20 lajas
        Punto destino = new Punto(2, 2);

        ingeniero.caminar(destino);

        assertTrue(mapa.hayLajaEn(new Punto(1, 1)));
        assertTrue(mapa.hayLajaEn(new Punto(2, 2)));
        assertFalse(mapa.hayLajaEn(inicio)); // No debe poner laja en el inicio
    }

    @Test
    @DisplayName("El ingeniero debe dejar de colocar lajas cuando se acaban")
    void testCaminarSeQuedaSinLajas() {
        Ingeniero ingeniero = new Ingeniero(inicio, mapa, 1);
        
        Punto destino = new Punto(3, 3);
        ingeniero.caminar(destino);

        assertTrue(mapa.hayLajaEn(new Punto(1, 1)));  // Colocó la primera laja
        assertFalse(mapa.hayLajaEn(new Punto(2, 2))); // Se quedó sin lajas
        assertFalse(mapa.hayLajaEn(new Punto(3, 3))); //
        
        assertEquals(0, ingeniero.getLajasRestantes());
        assertEquals(destino, ingeniero.getUbicacionActual()); // Debe llegar igual
    }

    @Test
    @DisplayName("El ingeniero no debe colocar laja si ya existe una")
    void testCaminarNoColocaLajaSobreOtra() {
        mapa.colocarLajaEn(new Punto(1, 1));

        Ingeniero ingeniero = new Ingeniero(inicio, mapa, 20);
        Punto destino = new Punto(2, 2);
        
        ingeniero.caminar(destino);

        // Verificamos que la laja de (2,2) se puso
        assertTrue(mapa.hayLajaEn(new Punto(2, 2)));
        
        // Verificamos que SÓLO usó 1 laja (para el punto 2,2)
        assertEquals(19, ingeniero.getLajasRestantes()); 
    }
}
