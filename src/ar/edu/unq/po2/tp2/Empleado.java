package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.util.ArrayList;

abstract class Empleado {
	
	private String nombre;
	private String direccion;
	private String estadoCivil;
	private LocalDate fechaNacimiento;
	private double sueldoBasico;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public double getSueldoBasico() {
		return sueldoBasico;
	}

	public void setSueldoBasico(double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}

	public Empleado(String nombre, String direccion, String estadoCivil, LocalDate fechaNacimiento, double sueldoBasico) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.fechaNacimiento = fechaNacimiento;
		this.sueldoBasico = sueldoBasico;
	}

	public int getEdad() {
		LocalDate hoy = LocalDate.now();
		
		return (hoy.getYear() - fechaNacimiento.getYear());
	}
	
	abstract double sueldoBruto();

	abstract double retenciones();
	
	protected double obraSocial() {
		return this.sueldoBruto() * 0.10;
	}

	public double sueldoNeto() {
		return (this.sueldoBruto() - this.retenciones());
	}
	
	public abstract ArrayList<Concepto> conceptosSueldoBruto();
	
	public abstract ArrayList<Concepto> conceptosRetenciones();
	
	public ArrayList<Concepto> conceptos() {
		ArrayList<Concepto> conceptos = new ArrayList<Concepto>();
		conceptos.addAll(this.conceptosSueldoBruto());
		conceptos.addAll(this.conceptosRetenciones());
		return conceptos;
	}
}
