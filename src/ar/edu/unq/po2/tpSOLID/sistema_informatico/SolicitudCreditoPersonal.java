package ar.edu.unq.po2.tpSOLID.sistema_informatico;

public class SolicitudCreditoPersonal extends SolicitudCredito {

    public SolicitudCreditoPersonal(Cliente cliente, float monto, int plazoEnMeses) {
        super(cliente, monto, plazoEnMeses);
    }

    @Override
    public boolean esAceptable() {
        boolean IngresosAnualesMinimos15000 = this.cliente.getSueldoNetoAnual() >= 15000;
        boolean cuotaNoSupera70PorcientoSueldo = this.getMontoCuota() <= (this.cliente.getSueldoNeto() * 0.7);
        return IngresosAnualesMinimos15000 && cuotaNoSupera70PorcientoSueldo;
    }

}
