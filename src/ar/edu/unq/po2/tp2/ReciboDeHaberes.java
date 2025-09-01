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
		this.sueldoBruto = empleado.calcularSueldoBruto();
		this.sueldoNeto = empleado.calcularSueldoNeto();
		this.conceptos = new ArrayList<Concepto>();
	}
	
	public ArrayList<Concepto> getConceptos() {
		return conceptos;
	}
	
	public void agregarConcepto(Concepto c) {
		conceptos.add(c);
	}

	public void imprimirRecibo() {
		System.out.println("----------------------------------");
		System.out.println("Recibo de Haberes");
        System.out.println("Empleado: " + nombreEmpleado);
        System.out.println("Direccion: " + direccion);
        System.out.println("Fecha: " + fechaEmision);
        System.out.println("Sueldo Bruto: " + sueldoBruto);
        System.out.println("Sueldo Neto: " + sueldoNeto);
        System.out.println("Conceptos:");
        for (Concepto c : conceptos) {
            System.out.println(" - " + c.getDescripcion() + ": $" + c.getMonto());
        }
        System.out.println("----------------------------------");
	}
}
