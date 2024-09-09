package ar.edu.unq.po2.tp2;

public class Concepto {
	
	private String item;
	private double monto;
	
	public Concepto(String item, double monto) {
		this.item = item;
		this.monto = monto;
	}

	public String getItem() {
		return item;
	}

	public double getMonto() {
		return monto;
	}
}
