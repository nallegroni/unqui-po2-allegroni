package ar.edu.unq.po2.tp2;

import java.time.LocalDate;

public class EmpleadoContratado extends Empleado {
	
	String numeroContrato;
	String medioDePago;
	
	private static final double retencionPorGastosAdministrativosContractuales = 50;
	
	public EmpleadoContratado(String nombre, String direccion, String estadoCivil, LocalDate fechaNacimiento,
			double sueldoBasico, String numeroContrato, String medioDePago) {
		super(nombre, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
		this.numeroContrato = numeroContrato;
		this.medioDePago = medioDePago;
	}

	@Override
	double calcularSueldoBruto() {
		return sueldoBasico;
	}

	@Override
	double calcularRetenciones() {
		return retencionPorGastosAdministrativosContractuales;
	}

	@Override
	void desgloceConceptosSueldoBruto(ReciboDeHaberes recibo, Empleado e) {
		// TODO Auto-generated method stub

	}

	@Override
	void desgloceConceptosRetenciones(ReciboDeHaberes recibo, Empleado e) {
		// TODO Auto-generated method stub

	}

}
