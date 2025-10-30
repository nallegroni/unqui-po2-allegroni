package ar.edu.unq.po2.tpState;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MaquinaVideojuegoTest {

    private MaquinaVideojuego maquina;

    @BeforeEach
    void setUp() {
        maquina = new MaquinaVideojuego();
    }

    @Test
    @DisplayName("La máquina inicia en EstadoEncendido y con 0 fichas")
    void testEstadoInicial() {
        assertEquals(0, maquina.getFichas());
        // Verificamos que la clase del estado inicial sea la correcta
        assertInstanceOf(EstadoEncendido.class, maquina.getEstadoActual());
    }

    @Test
    @DisplayName("Flujo completo: Iniciar juego para 1 jugador y terminarlo")
    void testFlujoJuegoUnJugador() {
        // Estado inicial: Encendido
        assertInstanceOf(EstadoEncendido.class, maquina.getEstadoActual());

        // Evento: Oprimir botón
        maquina.oprimirBoton();
        // Nuevo Estado: SinFichas
        assertInstanceOf(EstadoEncendidoSinFichas.class, maquina.getEstadoActual());

        // Evento: Insertar ficha
        maquina.insertarFicha();
        // Nuevo Estado: Con1Ficha
        assertInstanceOf(EstadoEncendidoCon1Ficha.class, maquina.getEstadoActual());
        assertEquals(1, maquina.getFichas());

        // Evento: Oprimir botón
        maquina.oprimirBoton();
        // Nuevo Estado: Jugando
        assertInstanceOf(EstadoJugando.class, maquina.getEstadoActual());

        // Evento: Terminar juego
        maquina.terminarJuego();
        // Nuevo Estado: Encendido (vuelve al inicio)
        assertInstanceOf(EstadoEncendido.class, maquina.getEstadoActual());
        // Verifica que las fichas se reiniciaron
        assertEquals(0, maquina.getFichas());
    }

    @Test
    @DisplayName("Flujo completo: Iniciar juego para 2 jugadores y terminarlo")
    void testFlujoJuegoDosJugadores() {
        // Pasos previos
        maquina.oprimirBoton(); // -> SinFichas
        maquina.insertarFicha(); // -> Con1Ficha

        // Insertar segunda ficha
        maquina.insertarFicha();
        // Nuevo Estado: Con2Fichas
        assertInstanceOf(EstadoEncendidoCon2Fichas.class, maquina.getEstadoActual());
        assertEquals(2, maquina.getFichas());

        // Oprimir botón
        maquina.oprimirBoton();
        // Nuevo Estado: Jugando
        assertInstanceOf(EstadoJugando.class, maquina.getEstadoActual());

        // Terminar juego
        maquina.terminarJuego();
        // Nuevo Estado: Encendido
        assertInstanceOf(EstadoEncendido.class, maquina.getEstadoActual());
        assertEquals(0, maquina.getFichas());
    }

    @Test
    @DisplayName("Test de acciones inválidas (no deberían cambiar el estado)")
    void testAccionesInvalidas() {
        // 1. Intentar insertar ficha en EstadoEncendido (antes de oprimir botón)
        maquina.insertarFicha();
        // Estado no debe cambiar
        assertInstanceOf(EstadoEncendido.class, maquina.getEstadoActual());
        assertEquals(0, maquina.getFichas());

        // 2. Intentar oprimir botón repetidamente en EstadoSinFichas
        maquina.oprimirBoton(); // -> SinFichas
        maquina.oprimirBoton(); // Intento inválido
        // Estado no debe cambiar
        assertInstanceOf(EstadoEncendidoSinFichas.class, maquina.getEstadoActual());

        // 3. Intentar insertar más de 2 fichas
        maquina.insertarFicha(); // -> Con1Ficha
        maquina.insertarFicha(); // -> Con2Fichas
        maquina.insertarFicha(); // Intento inválido (ya tiene 2)
        // Estado no debe cambiar
        assertInstanceOf(EstadoEncendidoCon2Fichas.class, maquina.getEstadoActual());
        assertEquals(2, maquina.getFichas());

        // 4. Intentar insertar ficha mientras se juega
        maquina.oprimirBoton(); // -> Jugando
        maquina.insertarFicha(); // Intento inválido
        assertInstanceOf(EstadoJugando.class, maquina.getEstadoActual());
        assertEquals(2, maquina.getFichas()); // Fichas no cambian
    }
}
