package ar.edu.unq.po2.tp5;

import java.util.ArrayList;
import java.util.List;

public class Caja {
	
	private List<Cobrable> items;
	private double montoTotalAPagar;
	
	public Caja() {
		this.items = new ArrayList<>();
		this.montoTotalAPagar = 0;
	}
	
	public void registrar(Cobrable c) {
		if (c instanceof Producto p) {
			registrarProducto(p);
		} else if (c instanceof Factura f) {
			registrarFactura(f);
		}
	}
	
	public void registrarFactura(Factura f) {
		f.notificarAgencia();
		montoTotalAPagar += f.getMontoAPagar();
		items.add(f);
	}
	
	public void registrarProducto(Producto p) {
		if (p.getStock() <= 0) {
			throw new IllegalStateException("No hay stock disponible de " + p.getNombre());
		}
		montoTotalAPagar += p.getMontoAPagar();
		p.decrementarStock();
		items.add(p);
		
	}
	
	public List<Cobrable> getItems() {
		return items;
	}
	
	public double getMontoTotalAPagar() {
		return montoTotalAPagar;
	}
}
