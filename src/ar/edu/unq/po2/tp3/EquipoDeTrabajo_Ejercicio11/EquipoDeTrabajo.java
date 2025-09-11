package ar.edu.unq.po2.tp3.EquipoDeTrabajo_Ejercicio11;

import java.util.HashSet;

public class EquipoDeTrabajo {

	private String nombre;
	private HashSet<Persona> integrantes;
	
	public EquipoDeTrabajo(String nombre) {
		this.nombre = nombre;
		this.integrantes = new HashSet<Persona>();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void agregarIntegrante(Persona p) {
		integrantes.add(p);
	}
	
	public double getPromedioEdad() {
		if (integrantes.isEmpty()) {
            return 0;
        }
        int edadTotal = 0;
        for (Persona p : integrantes) {
            edadTotal += p.getEdad();
        }
        return edadTotal / integrantes.size();
	}
}
