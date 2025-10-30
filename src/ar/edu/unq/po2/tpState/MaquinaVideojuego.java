package ar.edu.unq.po2.tpState;
public class MaquinaVideojuego {

    private Estado estadoActual;
    private int fichas;

    public MaquinaVideojuego() {
        this.estadoActual = new EstadoEncendido(this);
        this.fichas = 0;
    }

    public void oprimirBoton() {
        this.estadoActual.oprimirBoton();
    }

    public void insertarFicha() {
        this.estadoActual.insertarFicha();
    }

    public void incrementarFichas() {
        this.fichas += 1;
    }

    public void terminarJuego() {
        this.estadoActual.terminarJuego();
    }

    public Estado getEstadoActual() {
        return this.estadoActual;
    }

    public void setEstadoActual(Estado estado) {
        this.estadoActual = estado;
    }

    public int getFichas() {
        return this.fichas;
    }

    public void setFichas(int cantidad) {
        this.fichas = cantidad;
    }
}
