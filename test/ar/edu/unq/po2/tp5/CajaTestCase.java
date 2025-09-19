package ar.edu.unq.po2.tp5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CajaTestCase {

    private Caja caja;
    private Producto harina;
    private Producto arroz;

    @BeforeEach
    public void setUp() {
        caja = new Caja();
        harina = new ProductoTradicional("Harina", 100, 10);
        arroz = new ProductoCooperativa("Arroz", 200, 5);
    }

    @Test
    public void testRegistrarProductoTradicional() {
        caja.registrarProducto(harina);

        assertEquals(100, caja.getMontoAPagar());
        assertEquals(9, harina.getStock());
    }

    @Test
    public void testRegistrarProductoCooperativa() {
        caja.registrarProducto(arroz);

        assertEquals(180, caja.getMontoAPagar()); // 200 con 10% desc
        assertEquals(4, arroz.getStock());
    }

    @Test
    public void testMultiplesProductos() {
        caja.registrarProducto(harina); // 100
        caja.registrarProducto(arroz);  // 180

        assertEquals(280, caja.getMontoAPagar());
        assertEquals(9, harina.getStock());
        assertEquals(4, arroz.getStock());
    }

    @Test
    public void testRegistrarProductoSinStock() {
        Producto productoSinStock = new ProductoTradicional("Leche", 50, 0);
        
        // Se verifica que se lance la excepcion al intenta registrar el producto sin stock
        assertThrows(IllegalStateException.class, () -> {
            caja.registrarProducto(productoSinStock);
        });
        
    }
}

