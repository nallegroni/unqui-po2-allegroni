package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.time.Period;

public abstract class Empleado {

	protected String nombre;
	protected String direccion;
	protected String estadoCivil;
	protected LocalDate fechaNacimiento;
	protected double sueldoBasico;
	
	public Empleado(String nombre, String direccion, String estadoCivil, LocalDate fechaNacimiento, double sueldoBasico) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.fechaNacimiento = fechaNacimiento;
		this.sueldoBasico = sueldoBasico;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public int calcularEdad(LocalDate fechaNacimiento) {
		return Period.between(fechaNacimiento, LocalDate.now()).getYears();
	}
	
	protected abstract double calcularSueldoBruto();
	
	protected abstract double calcularRetenciones();
	
	public double calcularSueldoNeto() {
		return calcularSueldoBruto() - calcularRetenciones();
	}
	
	protected abstract void desgloceConceptosSueldoBruto(ReciboDeHaberes recibo, Empleado e);
	protected abstract void desgloceConceptosRetenciones(ReciboDeHaberes recibo, Empleado e);
}
