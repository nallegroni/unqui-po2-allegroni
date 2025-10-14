package ar.edu.unq.po2.tpSOLID.sistema_informatico;

public class SolicitudCreditoHipotecario extends SolicitudCredito {
    private Propiedad garantia;

    public SolicitudCreditoHipotecario(Cliente cliente, float monto, int plazoEnMeses, Propiedad garantia) {
        super(cliente, monto, plazoEnMeses);
        this.garantia = garantia;
    }

    @Override
    public boolean esAceptable() {
        boolean montoNoSupera70PorcientoGarantia = this.monto <= (this.garantia.getValorFiscal() * 0.7);
        boolean cuotaNoSupera50PorcientoSueldo = this.getMontoCuota() <= (this.cliente.getSueldoNeto() * 0.5);
        int edadAlFinalizarCuotas = this.cliente.getEdad() + (this.plazoEnMeses / 12);
        boolean edadAlFinalizarNoSupera65 = edadAlFinalizarCuotas < 65;
        return montoNoSupera70PorcientoGarantia && cuotaNoSupera50PorcientoSueldo && edadAlFinalizarNoSupera65;
    }

}
