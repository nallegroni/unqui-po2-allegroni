package ar.edu.unq.po2.tp5;

public abstract class Producto implements Cobrable {
	
	private String nombre;
	private double precioBase;
	private int stock;
	
	public Producto(String nombre, double precioBase, int stock) {
		this.nombre = nombre;
		this.precioBase = precioBase;
		this.stock = stock;
    }
	
	public String getNombre() {
		return nombre;
	}
	
	public double getPrecioBase() {
		return precioBase;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void decrementarStock() {
		if (stock <= 0) {
			throw new IllegalStateException("No hay stock disponible de " + nombre);
		}
		stock--;
	}
	
}
