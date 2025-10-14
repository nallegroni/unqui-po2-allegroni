package ar.edu.unq.po2.tpSOLID.sistema_informatico;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SistemaInformaticoTestCase {

    private SistemaInformatico sistema;
    private Cliente clienteApto;
    private Cliente clienteNoApto;
    private Propiedad propiedadApta;

    @BeforeEach
    void setUp() {
        sistema = new SistemaInformatico();
        clienteApto = new Cliente("Carlos", "García", "Dir", 30, 100000);
        clienteNoApto = new Cliente("Laura", "Fernandez", "Dir 2", 40, 1000); // No califica para nada
        propiedadApta = new Propiedad("Depto", "Prop Dir", 2000000);
    }

    @Test
    void elMontoADesembolsarEsCeroCuandoNoHaySolicitudes() {
        assertEquals(0, sistema.calcularMontoTotalADesembolsar());
    }

    @Test
    void elMontoADesembolsarSumaSoloLasSolicitudesAceptables() {
        // Solicitud Aceptable: Personal de 50,000
        SolicitudCredito aceptablePersonal = new SolicitudCreditoPersonal(clienteApto, 50000, 12);

        // Solicitud Aceptable: Hipotecaria de 1,000,000
        SolicitudCredito aceptableHipotecaria = new SolicitudCreditoHipotecario(clienteApto, 1000000, 120, propiedadApta);

        // Solicitud Rechazada: Personal de 20,000 (cliente no apto)
        SolicitudCredito rechazadaPersonal = new SolicitudCreditoPersonal(clienteNoApto, 20000, 24);

        sistema.agregarSolicitudDeCredito(aceptablePersonal);
        sistema.agregarSolicitudDeCredito(aceptableHipotecaria);
        sistema.agregarSolicitudDeCredito(rechazadaPersonal);

        // El monto total debe ser la suma de las dos aceptables (50,000 + 1,000,000)
        assertEquals(1050000, sistema.calcularMontoTotalADesembolsar());
    }
}
