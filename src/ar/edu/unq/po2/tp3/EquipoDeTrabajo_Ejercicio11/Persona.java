package ar.edu.unq.po2.tp3.EquipoDeTrabajo_Ejercicio11;


public class Persona {
	
	private String nombre;
	private String apellido;
	private int edad;
	
	public Persona(String nombre, String apellido, int edad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}
	
	public int getEdad() {
		return edad;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public boolean menorQue(Persona p) {
		return this.getEdad() < p.getEdad();
	}

}
