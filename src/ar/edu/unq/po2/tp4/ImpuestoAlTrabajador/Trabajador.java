package ar.edu.unq.po2.tp4.ImpuestoAlTrabajador;

import java.util.ArrayList;

public class Trabajador {
	
	private ArrayList<Ingreso> ingresos;
	
	public Trabajador() {
		this.ingresos = new ArrayList<>();
	}
	
	public double getTotalPercibido() {
		double totalPercibido = 0;
		for (Ingreso ingreso : ingresos) {
			totalPercibido += ingreso.getMonto();
		}
		return totalPercibido;
	}

	protected double getTotalMontoImponible() {
		double totalMontoImponible = 0;
		for (Ingreso ingreso : ingresos) {
			totalMontoImponible += ingreso.getMontoImponible();
		}
		return totalMontoImponible;
	}
	
	protected double getImpuestoAPagar() {
		return getTotalMontoImponible() * 0.2;
	}
	
	protected void addIngreso(Ingreso ingreso) {
		ingresos.add(ingreso);
	}

	public ArrayList<Ingreso> getIngresos() {
		return ingresos;
	}
}
