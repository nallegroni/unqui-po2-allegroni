package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.util.HashSet;

public class Empresa {

	private String nombre;
	private int CUIT;
	private HashSet<Empleado> empleados;
	private HashSet<ReciboDeHaberes> recibosDeHaberes;
	
	public Empresa(String nombre, int CUIT) {
		this.nombre = nombre;
		this.CUIT = CUIT;
		this.empleados = new HashSet<Empleado>();
		this.recibosDeHaberes = new HashSet<ReciboDeHaberes>();
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getCUIT() {
		return CUIT;
	}

	public HashSet<Empleado> getEmpleados() {
		return empleados;
	}

	public HashSet<ReciboDeHaberes> getRecibosDeHaberes() {
		return recibosDeHaberes;
	}

	public void contratarEmpleado(Empleado e) {
		empleados.add(e);
	}
	
	public double totalSueldosNetos() {
		double totalSueldosNetos = 0;
		for (Empleado e : empleados) {
			totalSueldosNetos += e.sueldoNeto();
		}
		return totalSueldosNetos;
	}
	
	public double totalSueldosBrutos() {
		double totalSueldosBrutos = 0;
		for (Empleado e : empleados) {
			totalSueldosBrutos += e.sueldoBruto();
		}
		return totalSueldosBrutos;
	}
	
	public double totalRetenciones() {
		double totalRetenciones = 0;
		for (Empleado e : empleados) {
			totalRetenciones += e.retenciones();
		}
		return totalRetenciones;
	}
	
	public void liquidacionDeSueldos() {
		for (Empleado e : empleados) {
			this.generarReciboPara(e);
		}
	}
	
	private void generarReciboPara(Empleado e) {
		ReciboDeHaberes recibo = new ReciboDeHaberes(e);
		this.desgloceConceptos(recibo, e);
		recibosDeHaberes.add(recibo);
	}
	
	private void desgloceConceptos(ReciboDeHaberes recibo, Empleado e) {
		for (Concepto c : e.conceptos()) {
			recibo.agregarConcepto(c);
		}
	}
}
