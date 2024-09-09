package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.util.ArrayList;

public class PlantaPermanente extends Empleado {

	private int cantidadHijos;
	private int añoAntiguedad;
	
	public PlantaPermanente(String nombre, String direccion, String estadoCivil, LocalDate fechaNacimiento,
			double sueldoBasico, int cantidadHijos, int añoAntiguedad) {
		super(nombre, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
		this.cantidadHijos = cantidadHijos;
		this.añoAntiguedad = añoAntiguedad;
	}

	public int getCantidadHijos() {
		return cantidadHijos;
	}

	public void setCantidadHijos(int cantidadHijos) {
		this.cantidadHijos = cantidadHijos;
	}

	public int getAñoAntiguedad() {
		return añoAntiguedad;
	}

	public void setAñoAntiguedad(int añoAntiguedad) {
		this.añoAntiguedad = añoAntiguedad;
	}

	@Override
	double sueldoBruto() {
		return (this.getSueldoBasico() + this.salarioFamiliar())  ;
	}
	
	public double salarioFamiliar() {
		return this.asignacionPorHijo() + this.asignacionPorConyuge() + this.aportePorAntiguedad();
	}
	
	public double asignacionPorHijo() {
		int valorPorHijo = 150;
		return  valorPorHijo * getCantidadHijos();
	}

	public double asignacionPorConyuge() {
		 return (this.getEstadoCivil() == "Casado") ? 100 : 0; 
	}
	
	public double aportePorAntiguedad() {
		int valorPorAñoAntiguedad = 50;
		return valorPorAñoAntiguedad * getAñoAntiguedad();
	}
	
	@Override
	public double retenciones() {
		return this.obraSocial() + this.aportesJubilatorios();
	}
	
	public double obraSocial() {
		return super.obraSocial() + (20 * getCantidadHijos()) ;
	}
	
	public double aportesJubilatorios() {
		return this.sueldoBruto() * 0.15;
	}

	@Override
	public ArrayList<Concepto> conceptosSueldoBruto() {
		ArrayList<Concepto> conceptos = new ArrayList<>();
		conceptos.add(new Concepto("Sueldo Basico", this.getSueldoBasico()));
		conceptos.add(new Concepto("Asignación por hijo", this.asignacionPorHijo()));
		conceptos.add(new Concepto("Asignación por cónyuge", this.asignacionPorConyuge()));
		conceptos.add(new Concepto("Aporte por antiguedad", this.aportePorAntiguedad()));
		return conceptos;
	}

	@Override
	public ArrayList<Concepto> conceptosRetenciones(){
		ArrayList<Concepto> conceptos = new ArrayList<Concepto>();
		conceptos.add(new Concepto("Obra Social", this.obraSocial()));
		conceptos.add(new Concepto("Aportes Jubilatorios", this.aportesJubilatorios()));
		return conceptos;
	};
}
