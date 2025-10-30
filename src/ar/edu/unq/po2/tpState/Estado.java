package ar.edu.unq.po2.tpState;

public abstract class Estado {

    protected MaquinaVideojuego contexto;

    public Estado(MaquinaVideojuego contexto) {
        this.contexto = contexto;
    }

    public abstract void oprimirBoton();

    public abstract void insertarFicha();

    public abstract void terminarJuego();

}
