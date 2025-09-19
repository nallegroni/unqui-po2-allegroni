package ar.edu.unq.po2.tp5;

import java.util.ArrayList;
import java.util.List;

public class Caja {
	
	private List<Producto> productos;
	private double montoAPagar;
	
	public Caja() {
		this.productos = new ArrayList<>();
		this.montoAPagar = 0;
	}
	
	public void registrarProducto(Producto p) {
		if (p.getStock() <= 0) {
			throw new IllegalStateException("No hay stock disponible de " + p.getNombre());
		}
		montoAPagar += p.getPrecioFinal();
		p.decrementarStock();
		productos.add(p);
		
	}
	
	public List<Producto> getProductos() {
		return productos;
	}
	
	public double getMontoAPagar() {
		return montoAPagar;
	}
}
