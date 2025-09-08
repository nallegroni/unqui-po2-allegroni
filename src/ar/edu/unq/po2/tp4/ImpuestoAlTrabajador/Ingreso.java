package ar.edu.unq.po2.tp4.ImpuestoAlTrabajador;

public class Ingreso {
	
	private int mes;
	private String concepto;
	protected double monto;
	
	public Ingreso(int mes, String concepto, double monto) {
		this.mes = mes;
		this.concepto = concepto;
		this.monto = monto;
	}
	
	public double getMonto() {
		return monto;
	}
	
	public double getMontoImponible() {
		return monto;
	}

	public int getMes() {
		return mes;
	}

	public String getConcepto() {
		return concepto;
	}
}
