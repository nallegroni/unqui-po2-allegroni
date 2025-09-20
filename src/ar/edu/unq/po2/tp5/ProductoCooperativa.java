package ar.edu.unq.po2.tp5;

public class ProductoCooperativa extends Producto {
	
	private double descuento;
	
	public ProductoCooperativa(String nombre, double precioBase, int stock) {
		super(nombre, precioBase, stock);
		this.descuento = getPrecioBase() * 0.10;
	}

	@Override
	public double getMontoAPagar() {
		return getPrecioBase() - descuento;
	}

}
