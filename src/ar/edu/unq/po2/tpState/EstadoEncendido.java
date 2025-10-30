package ar.edu.unq.po2.tpState;

public class EstadoEncendido extends Estado {
    
    public EstadoEncendido(MaquinaVideojuego maquina) {
        super(maquina);
    }

    @Override
    public void oprimirBoton() {
        this.contexto.setEstadoActual(new EstadoEncendidoSinFichas(this.contexto));
        System.out.println("Ingrese una ficha.");
    }

    public void insertarFicha() {
        System.out.println("Primero debe oprimir el botón para iniciar.");
    }

    public void terminarJuego() {
        System.out.println("No hay juego en curso.");
    }

}
