package ar.edu.unq.po2.tp3;

import java.time.LocalDate;
import java.time.Period;

public class Persona {
	
	private String nombre;
	private LocalDate fechaNacimiento;
	
	public Persona(String nombre, LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public int getEdad() {
		return Period.between(fechaNacimiento, LocalDate.now()).getYears();
	}

	public String getNombre() {
		return nombre;
	}
	
	public boolean menorQue(Persona p) {
		return this.getEdad() < p.getEdad();
	}
	
	
}
