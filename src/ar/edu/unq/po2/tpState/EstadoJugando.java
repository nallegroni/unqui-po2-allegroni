package ar.edu.unq.po2.tpState;

public class EstadoJugando extends Estado {

    public EstadoJugando(MaquinaVideojuego maquina) {
        super(maquina);
    }

    @Override
    public void oprimirBoton() {
        System.out.println("El juego ya está en curso.");
    }

    @Override
    public void insertarFicha() {
        System.out.println("No se pueden insertar fichas durante el juego.");
    }

    @Override
    public void terminarJuego() {
        System.out.println("Juego terminado.");
        this.contexto.setFichas(0);
        this.contexto.setEstadoActual(new EstadoEncendido(this.contexto));
    }

}
