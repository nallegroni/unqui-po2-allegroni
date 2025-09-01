package ar.edu.unq.po2.tp2;

public class Concepto {
	private String descripcion;
	private double monto;
	
	public Concepto(String descripcion, double monto) {
		this.descripcion = descripcion;
		this.monto = monto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getMonto() {
		return monto;
	}
}
