package ar.edu.unq.po2.tpSOLID.sistema_informatico;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SolicitudCreditoPersonalTestCase {

    private Cliente clienteApto;
    private Cliente clienteNoAptoSalarioAnual;
    private Cliente clienteNoAptoSalarioMensual;

    @BeforeEach
    void setUp() {
        // Cliente que cumple todas las condiciones
        clienteApto = new Cliente("Juan", "Perez", "Calle Falsa 123", 30, 100000); // 1.2M anual

        // Cliente que no cumple el requisito de salario anual
        clienteNoAptoSalarioAnual = new Cliente("Maria", "Gomez", "Av Siempre Viva 742", 40, 1000); // 12k anual

        // Cliente que cumple el salario anual pero no el mensual para la cuota
        clienteNoAptoSalarioMensual = new Cliente("Pedro", "Lopez", "Otra Calle 456", 35, 20000); // 240k anual
    }

    @Test
    void solicitudPersonalAceptableCuandoSeCumplenLasCondiciones() {
        SolicitudCredito solicitud = new SolicitudCreditoPersonal(clienteApto, 50000, 12);
        assertTrue(solicitud.esAceptable());
    }

    @Test
    void solicitudPersonalRechazadaPorIngresosAnualesInsuficientes() {
        SolicitudCredito solicitud = new SolicitudCreditoPersonal(clienteNoAptoSalarioAnual, 5000, 12);
        assertFalse(solicitud.esAceptable());
    }

    @Test
    void solicitudPersonalRechazadaCuandoLaCuotaSuperaEl70PorcientoDelIngresoMensual() {
        // Cuota: 15000 / 1 = 15000. 70% del sueldo de 20000 es 14000.
        SolicitudCredito solicitud = new SolicitudCreditoPersonal(clienteNoAptoSalarioMensual, 15000, 1);
        assertFalse(solicitud.esAceptable());
    }
}
