package ar.edu.unq.po2.tp2;

import java.time.LocalDate;

public class PlantaPermanente extends Empleado {

	public PlantaPermanente(String nombre, String direccion, String estadoCivil, LocalDate fechaNacimiento,
			double sueldoBasico) {
		super(nombre, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
		// TODO Auto-generated constructor stub
	}

	private int cantidadHijos;
	private int añoAntiguedad;
	

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
		// TODO Auto-generated method stub
		return (this.getSueldoBasico() + this.salarioFamiliar())  ;
	}
	
	public double salarioFamiliar() {
		return this.asignacionPorHijo() + this.asignacionPorConyuge() + this.antiguedad();
	}
	
	public double asignacionPorHijo() {
		return  150 * getCantidadHijos();
	}

	public double asignacionPorConyuge() {
		 if (this.getEstadoCivil() == "Casado") {
			 	return 100;
			} else {
				return 0; 
			}
	}
	
	public double antiguedad() {
		return 50 * getAñoAntiguedad();
	}
	
	@Override
	double retenciones() {
		// TODO Auto-generated method stub
		return this.obraSocial() + this.aportesJubilatorios();
	}

	public double obraSocial() {
		return (this.sueldoBruto() * 10 / 100) + (20 * getCantidadHijos()) ;
	}
	
	public double aportesJubilatorios() {
		return this.sueldoBruto() * 15 / 100;
	}
}
