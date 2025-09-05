package ar.edu.unq.po2.tp4;

public class ProductoPrimeraNecesidad extends Producto {

	public ProductoPrimeraNecesidad(String nombre, double precio, boolean esPrecioCuidado) {
		super(nombre, precio, esPrecioCuidado);
		// TODO Auto-generated constructor stub
	}

	public ProductoPrimeraNecesidad(String nombre, double precio) {
		super(nombre, precio);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double getPrecio() {
		return super.getPrecio()*0.9;
	}

}
