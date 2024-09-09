package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.util.ArrayList;

public class ReciboDeHaberes {

	private String nombreEmpleado;
	private String direccion;
	private LocalDate fechaEmision;
	private double sueldoBruto;
	private double sueldoNeto;
	private ArrayList<Concepto> conceptos;
	
	public ReciboDeHaberes(Empleado empleado) {
		this.nombreEmpleado = empleado.getNombre();
		this.direccion = empleado.getDireccion();
		this.fechaEmision = LocalDate.now();
		this.sueldoBruto = empleado.sueldoBruto();
		this.sueldoNeto = empleado.sueldoNeto();
		this.conceptos = new ArrayList<Concepto>();
	}
	
	public ArrayList<Concepto> getConceptos() {
		return conceptos;
	}
	
	public void agregarConcepto(Concepto c) {
		conceptos.add(c);
	}
}
