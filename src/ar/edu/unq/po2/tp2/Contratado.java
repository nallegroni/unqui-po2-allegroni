package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.util.ArrayList;

public class Contratado extends Empleado {

	public Contratado(String nombre, String direccion, String estadoCivil, LocalDate fechaNacimiento,
			double sueldoBasico, int numeroContrato, String medioPago) {
		super(nombre, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
		this.numeroContrato = numeroContrato;
		this.medioPago = medioPago;
	}

	private int numeroContrato;
	private String medioPago;
	
	@Override
	double sueldoBruto() {
		// TODO Auto-generated method stub
		return this.getSueldoBasico();
	}

	@Override
	public double retenciones() {
		double gastosAdministrativosContractuales = 50;
		return gastosAdministrativosContractuales;
	}

	@Override
	public ArrayList<Concepto> conceptosSueldoBruto() {
		ArrayList<Concepto> conceptos = new ArrayList<>();
		conceptos.add(new Concepto("Sueldo Basico", this.getSueldoBasico()));
		return conceptos;
	}

	@Override
	public ArrayList<Concepto> conceptosRetenciones(){
		ArrayList<Concepto> conceptos = new ArrayList<Concepto>();
		conceptos.add(new Concepto("Gastos Administrativos Contractuales", this.retenciones()));
		return conceptos;
	}
	
}
