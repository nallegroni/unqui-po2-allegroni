package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.util.ArrayList;

public class PlantaTemporaria extends Empleado {
	
	private LocalDate fechaFinDesignacion;
	private int cantidadHorasExtras;
	
	public PlantaTemporaria(String nombre, String direccion, String estadoCivil, LocalDate fechaNacimiento,
			double sueldoBasico, LocalDate fechaFinDesignacion, int cantidadHorasExtras) {
		super(nombre, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
		this.fechaFinDesignacion = fechaFinDesignacion;
		this.cantidadHorasExtras = cantidadHorasExtras;
	}

	public int getCantidadHorasExtras() {
		return cantidadHorasExtras;
	}

	@Override
	double sueldoBruto() {
		return getSueldoBasico() + this.aportePorHorasExtras(40);
	}
	
	public double aportePorHorasExtras(double valorHorasExtras) {
		return valorHorasExtras * getCantidadHorasExtras();
	}
	
	@Override
	public double retenciones() {
		return this.obraSocial() + this.aportesJubilatorios();
	}
	
	public double obraSocial() {
		return super.obraSocial() + (validarEdadMayorA(50) ? 25 : 0);
	}

	private boolean validarEdadMayorA(int edad) {
		return getEdad() > edad;
	}
	
	public double aportesJubilatorios() {
		return (this.sueldoBruto() * 0.10) + this.aportePorHorasExtras(5);
	}
	
	@Override
	public ArrayList<Concepto> conceptosSueldoBruto() {
		ArrayList<Concepto> conceptos = new ArrayList<>();
		conceptos.add(new Concepto("Sueldo Basico", this.getSueldoBasico()));
		conceptos.add(new Concepto("Aportes por Horas Extras", this.aportePorHorasExtras(40)));
		return conceptos;
	}
	
	@Override
	public ArrayList<Concepto> conceptosRetenciones(){
		ArrayList<Concepto> conceptos = new ArrayList<Concepto>();
		conceptos.add(new Concepto("Obra Social", this.obraSocial()));
		conceptos.add(new Concepto("Aportes Jubilatorios", this.aportesJubilatorios()));
		return conceptos;
	}
}
