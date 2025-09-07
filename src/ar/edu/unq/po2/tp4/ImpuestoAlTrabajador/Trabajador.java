package ar.edu.unq.po2.tp4.ImpuestoAlTrabajador;

import java.util.ArrayList;

public class Trabajador {
	
	private ArrayList<Ingreso> ingresos;
	
	public Trabajador(ArrayList<Ingreso> ingresos) {
		this.ingresos = new ArrayList<>();
	}
	
	public double getTotalPercibido() {
		double totalPercibido = 0;
		for (Ingreso ingreso : ingresos) {
			totalPercibido += ingreso.getMonto();
		}
		return totalPercibido;
	}

	private double getMontoImponible() {
		double montoImponible = 0;
		for (Ingreso ingreso : ingresos) {
			montoImponible += ingreso.getMontoImponible();
		}
		return montoImponible;
	}
	
	private double getImpuestoAPagar() {
		return getMontoImponible() * 0.2;
	}

	public ArrayList<Ingreso> getIngresos() {
		return ingresos;
	}
}
