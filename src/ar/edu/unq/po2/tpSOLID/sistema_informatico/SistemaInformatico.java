package ar.edu.unq.po2.tpSOLID.sistema_informatico;

public class SistemaInformatico {
    private Banco banco;

    public SistemaInformatico() {
        this.banco = new Banco();
    }

    public void agregarCliente(Cliente cliente) {
        this.banco.agregarCliente(cliente);
    }

    public void agregarSolicitudDeCredito(SolicitudCredito solicitud) {
        this.banco.registrarSolicitudCredito(solicitud);
    }

    public double calcularMontoTotalADesembolsar() {
        return this.banco.calcularMontoADesembolsar();
    }
}
