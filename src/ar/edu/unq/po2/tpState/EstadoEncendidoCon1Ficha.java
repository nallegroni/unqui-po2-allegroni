package ar.edu.unq.po2.tpState;

public class EstadoEncendidoCon1Ficha extends Estado {

    public EstadoEncendidoCon1Ficha(MaquinaVideojuego maquina) {
        super(maquina);
    }

    @Override
    public void oprimirBoton() {
        System.out.println("Juego iniciado para 1 jugador.");
        this.contexto.setEstadoActual(new EstadoJugando(this.contexto));
    }

    @Override
    public void insertarFicha() {
        this.contexto.incrementarFichas();
        this.contexto.setEstadoActual(new EstadoEncendidoCon2Fichas(this.contexto));
    }

    @Override
    public void terminarJuego() {
        System.out.println("No hay juego en curso.");
    }

}
