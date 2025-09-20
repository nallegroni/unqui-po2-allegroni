package ar.edu.unq.po2.tp5;

public class ProductoTradicional extends Producto {

	public ProductoTradicional(String nombre, double precioBase, int stock) {
		super(nombre, precioBase, stock);
	}

	@Override
	public double getMontoAPagar() {
		return getPrecioBase();
	}

}
