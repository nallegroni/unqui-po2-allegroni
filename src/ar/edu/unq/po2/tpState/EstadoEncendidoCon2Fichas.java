package ar.edu.unq.po2.tpState;

public class EstadoEncendidoCon2Fichas extends Estado {

    public EstadoEncendidoCon2Fichas(MaquinaVideojuego maquina) {
        super(maquina);
    }

    @Override
    public void oprimirBoton() {
        System.out.println("Juego iniciado para 2 jugadores.");
        this.contexto.setEstadoActual(new EstadoJugando(this.contexto));
    }

    @Override
    public void insertarFicha() {
        System.out.println("No se pueden insertar más fichas. Ya hay 2 fichas.");
    }

    @Override
    public void terminarJuego() {
        System.out.println("No hay juego en curso.");
    }

}
