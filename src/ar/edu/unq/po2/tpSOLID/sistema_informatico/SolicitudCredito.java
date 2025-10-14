package ar.edu.unq.po2.tpSOLID.sistema_informatico;

public abstract class SolicitudCredito {

    protected Cliente cliente;
    protected float monto;
    protected int plazoEnMeses;

    public SolicitudCredito(Cliente cliente, float monto, int plazoEnMeses) {
        this.cliente = cliente;
        this.monto = monto;
        this.plazoEnMeses = plazoEnMeses;
    }

    public float getMonto() {
        return monto;
    }

    public float getMontoCuota() {
        return this.monto / this.plazoEnMeses;
    }

    public abstract boolean esAceptable();

}
