package ar.edu.unq.po2.tp4;

import java.util.ArrayList;

public class Supermercado {

	private String nombre;
	private String direccion;
	ArrayList<Producto> productos = new ArrayList<Producto>();
	
	public Supermercado(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	public Integer getCantidadDeProductos() {
		return productos.size();
	}
	
	public void agregarProducto(Producto prod) {
		productos.add(prod);
	}
	
	public double getPrecioTotal() {
		double precioTotal = 0;
		for (Producto prod : productos) {
			precioTotal += prod.getPrecio();
		}
		return precioTotal;
	}

}
