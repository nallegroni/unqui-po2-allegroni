package ar.edu.unq.po2.tpComposite;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

// Necesario para que Mockito funcione con JUnit 5
@ExtendWith(MockitoExtension.class)
class EjercitoTestCase {

    private Ejercito ejercitoPrincipal;
    private Mapa mapa;
    private Punto puntoInicioEjercito;
    private Punto destino;

    @BeforeEach
    void setUp() {
        mapa = new Mapa(20, 20);
        puntoInicioEjercito = new Punto(0, 0);
        destino = new Punto(10, 10);

        ejercitoPrincipal = new Ejercito(puntoInicioEjercito, mapa);
    }

    @Test
    @DisplayName("Un ejército vacío no debe lanzar error al caminar")
    void testCaminarEjercitoVacio() {
        // El test pasa si la siguiente línea no lanza ninguna excepción
        assertDoesNotThrow(() -> {
            ejercitoPrincipal.caminar(destino);
        });
    }

    @Test
    @DisplayName("El ejército debe dar la orden de caminar a todos sus miembros directos")
    void testCaminarDelegaAMiembros() {
        // Creamos "Mocks" de personajes
        Personaje miembro1 = mock(Ingeniero.class);
        Personaje miembro2 = mock(Caballero.class);
        
        ejercitoPrincipal.agregarMiembro(miembro1);
        ejercitoPrincipal.agregarMiembro(miembro2);

        ejercitoPrincipal.caminar(destino);

        // Verificamos que se llamó al método 'caminar' en CADA mock, exactamente 1 vez, y con el destino correcto.
        verify(miembro1, times(1)).caminar(destino);
        verify(miembro2, times(1)).caminar(destino);
    }

    @Test
    @DisplayName("El ejército debe delegar la orden a miembros anidados (recursividad)")
    void testCaminarDelegaAMiembrosAnidados() {
        // Miembro directo del ejército principal
        Personaje ingeMock = mock(Ingeniero.class);
        // Miembro del sub-ejército
        Personaje cabaMock = mock(Caballero.class);
        // Creamos un SUB-EJÉRCITO real
        Punto puntoInicioSubEjercito = new Punto(5, 5);
        Ejercito subEjercito = new Ejercito(puntoInicioSubEjercito, mapa);
        
        // Añadimos el caballero al sub-ejército
        subEjercito.agregarMiembro(cabaMock);

        // Añadimos el ingeniero y el sub-ejército al ejército principal
        ejercitoPrincipal.agregarMiembro(ingeMock);
        ejercitoPrincipal.agregarMiembro(subEjercito);
        
        ejercitoPrincipal.caminar(destino);

        // Verificamos que el ejército principal llamó a su ingeniero
        verify(ingeMock, times(1)).caminar(destino);
        
        // Verificamos que el caballero fue llamado. Esto prueba que:
        // 1. El ejército principal llamó a 'caminar' en 'subEjercito'.
        // 2. 'subEjercito' a su vez llamó a 'caminar' en 'cabaMock'.
        // Esto confirma que la recursividad funciona.
        verify(cabaMock, times(1)).caminar(destino);
    }
}