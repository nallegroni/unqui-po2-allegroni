package ar.edu.unq.po2.tpSOLID.sistema_informatico;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cliente> clientes;
    private List<SolicitudCredito> solicitudes;

    public Banco() {
        this.clientes = new ArrayList<>();
        this.solicitudes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void registrarSolicitudCredito(SolicitudCredito solicitud) {
        this.solicitudes.add(solicitud);
    }

    /*public void evaluarSolicitudes() {
        for (SolicitudCredito solicitud : this.solicitudes) {
            if (solicitud.esAceptable()) {
                System.out.println("Solicitud ACEPTADA");
            } else {
                System.out.println("Solicitud RECHAZADA");
            }
        }
    }*/

    public double calcularMontoADesembolsar() {
        return this.solicitudes.stream()
                               .filter(SolicitudCredito::esAceptable)
                               .mapToDouble(SolicitudCredito::getMonto)
                               .sum();
    }

}
