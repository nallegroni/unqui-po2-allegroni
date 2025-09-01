package ar.edu.unq.po2.tp2;

import java.util.HashSet;

public class Empresa {
	
	private String nombre;
	private String cuit;
	private HashSet<Empleado> empleados;
	private HashSet<ReciboDeHaberes> recibos;
	
	public Empresa(String nombre, String cuit) {
        this.nombre = nombre;
        this.cuit = cuit;
        this.empleados = new HashSet<Empleado>();
        this.recibos = new HashSet<ReciboDeHaberes>();
    }
	
	public void agregarEmpleado(Empleado e) {
        empleados.add(e);
    }
	
	public double calcularTotalSueldosNetos() {
		double totalSueldosNetos = 0;
		for (Empleado e : empleados) {
			totalSueldosNetos += e.calcularSueldoNeto();
		}
		return totalSueldosNetos;
	};
	
	public double calcularTotalSueldosBrutos() {
		double totalSueldosBrutos = 0;
		for (Empleado e : empleados) {
			totalSueldosBrutos += e.calcularSueldoBruto();
		}
		return totalSueldosBrutos;
	};
	
	public double calcularTotalRetenciones() {
		double totalRetenciones = 0;
		for (Empleado e : empleados) {
			totalRetenciones += e.calcularRetenciones();
		}
		return totalRetenciones;
	};
	
	public void liquidarSueldos() {
		for (Empleado e : empleados) {
			generarReciboPara(e);	
		}
	}
	
	private void generarReciboPara(Empleado e) {		
		ReciboDeHaberes recibo = new ReciboDeHaberes(e);
		this.desgloceConceptos(recibo, e);
		recibos.add(recibo);
		recibo.imprimirRecibo();
	}
	
	private void desgloceConceptos(ReciboDeHaberes recibo, Empleado e) {
		e.desgloceConceptosSueldoBruto(recibo, e);
		e.desgloceConceptosRetenciones(recibo, e);
	}
	
		
}
