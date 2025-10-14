package ar.edu.unq.po2.tpSOLID.sistema_informatico;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SolicitudCreditoHipotecarioTestCase {
    
    private Cliente clienteApto;
    private Cliente clienteNoAptoPorEdad;
    private Propiedad propiedadApta;

    @BeforeEach
    void setUp() {
        clienteApto = new Cliente("Ana", "Martinez", "Direccion", 45, 200000); // 2.4M anual
        clienteNoAptoPorEdad = new Cliente("Roberto", "Sanchez", "Direccion 2", 60, 200000);
        propiedadApta = new Propiedad("Casa", "Direccion Propiedad", 5000000);
    }

    @Test
    void unaSolicitudHipotecariaEsAceptableCuandoSeCumplenLasCondiciones() {
        SolicitudCredito solicitud = new SolicitudCreditoHipotecario(clienteApto, 3000000, 120, propiedadApta); // 10 años
        assertTrue(solicitud.esAceptable());
    }

    @Test
    void unaSolicitudHipotecariaEsRechazadaCuandoElClienteSuperaLos65AlFinalDelPlazo() {
        // A los 60, un crédito a 6 años (72 meses) lo haría terminar con 66.
        SolicitudCredito solicitud = new SolicitudCreditoHipotecario(clienteNoAptoPorEdad, 3000000, 72, propiedadApta);
        assertFalse(solicitud.esAceptable());
    }

    @Test
    void unaSolicitudHipotecariaEsRechazadaCuandoLaCuotaSuperaEl50PorcientoDelIngresoMensual() {
        // Sueldo mensual 200k. 50% es 100k. Cuota solicitada: 1.5M / 12 = 125k
        SolicitudCredito solicitud = new SolicitudCreditoHipotecario(clienteApto, 1500000, 12, propiedadApta);
        assertFalse(solicitud.esAceptable());
    }

    @Test
    void unaSolicitudHipotecariaEsRechazadaCuandoElMontoSuperaEl70PorcientoDelValorDeLaGarantia() {
        // Garantía de 5M. 70% es 3.5M. Se piden 4M.
        SolicitudCredito solicitud = new SolicitudCreditoHipotecario(clienteApto, 4000000, 120, propiedadApta);
        assertFalse(solicitud.esAceptable());
    }
}
