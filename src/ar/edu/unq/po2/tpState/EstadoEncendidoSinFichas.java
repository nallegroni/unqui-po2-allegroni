package ar.edu.unq.po2.tpState;

public class EstadoEncendidoSinFichas extends Estado {

    public EstadoEncendidoSinFichas(MaquinaVideojuego maquina) {
        super(maquina);
    }

    @Override
    public void oprimirBoton() {
        System.out.println("Ingrese una ficha.");
    }

    @Override
    public void insertarFicha() {
        this.contexto.incrementarFichas();
        this.contexto.setEstadoActual(new EstadoEncendidoCon1Ficha(this.contexto));
    }

    @Override
    public void terminarJuego() {
        System.out.println("No hay juego en curso.");
    }

}
