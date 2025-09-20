package ar.edu.unq.po2.tp5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CajaTestCase {

    private Caja caja;
    private Producto harina;
    private Producto arroz;
    private Agencia agencia;

    @BeforeEach
    public void setUp() {
        caja = new Caja();
        harina = new ProductoTradicional("Harina", 100, 10);
        arroz = new ProductoCooperativa("Arroz", 200, 5);
        agencia = new AgenciaRecaudadora("ARCA");
    }

    @Test
    public void testRegistrarProductoTradicional() {
        caja.registrar(harina);

        assertEquals(100, caja.getMontoTotalAPagar());
        assertEquals(9, harina.getStock());
    }

    @Test
    public void testRegistrarProductoCooperativa() {
        caja.registrar(arroz);

        assertEquals(180, caja.getMontoTotalAPagar()); // 200 con 10% desc
        assertEquals(4, arroz.getStock());
    }

    @Test
    public void testMultiplesProductos() {
        caja.registrar(harina); // 100
        caja.registrar(arroz);  // 180

        assertEquals(280, caja.getMontoTotalAPagar());
        assertEquals(9, harina.getStock());
        assertEquals(4, arroz.getStock());
    }

    @Test
    public void testRegistrarProductoSinStock() {
        Producto productoSinStock = new ProductoTradicional("Leche", 50, 0);
        
        // Se verifica que se lance la excepcion al intenta registrar el producto sin stock
        assertThrows(IllegalStateException.class, () -> {
            caja.registrar(productoSinStock);
        });
        
    }
    
    @Test
    public void registrarFacturaServicio() {
    	FacturaServicio servicio = new FacturaServicio(2 ,100);
        caja.registrar(servicio);

        assertEquals(200, caja.getMontoTotalAPagar());
    }
    
    @Test
    public void registrarFacturaImpuesto() {
    	FacturaImpuesto impuesto = new FacturaImpuesto(500);
        caja.registrar(impuesto);

        assertEquals(500, caja.getMontoTotalAPagar());
    }
    
    @Test
    void testProductosYFacturas() {
    	FacturaServicio servicio = new FacturaServicio(3, 50); // 150
        FacturaImpuesto impuesto = new FacturaImpuesto(400);    // 400

        caja.registrar(harina); // 100
        caja.registrar(arroz);  // 180
        caja.registrar(servicio);
        caja.registrar(impuesto);

        assertEquals(830, caja.getMontoTotalAPagar());
    }
}

