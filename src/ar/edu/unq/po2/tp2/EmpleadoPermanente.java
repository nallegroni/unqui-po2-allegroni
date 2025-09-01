package ar.edu.unq.po2.tp2;

import java.time.LocalDate;

public class EmpleadoPermanente extends Empleado {
	
	private int cantidadHijos;
	private int añosAntiguedad;
	private boolean conyuge;
	
	private static final double asignacionPorHijo = 150;
    private static final double asignacionPorConyuge = 100;
    private static final double asignacionPorAñoAntiguedad = 50;
    private static final double retencionPorHijo = 20;
	
	public EmpleadoPermanente(String nombre, String direccion, String estadoCivil, LocalDate fechaNacimiento,
			double sueldoBasico, int cantidadHijos, int añosAntiguedad, boolean conyuge) {
		super(nombre, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
		this.cantidadHijos = cantidadHijos;
		this.añosAntiguedad = añosAntiguedad;
		this.conyuge = conyuge;
	}

	@Override
	double calcularSueldoBruto() {
		double sueldoFamiliar = (cantidadHijos * asignacionPorHijo) + (conyuge ? asignacionPorConyuge : 0);
		double antiguedad = (añosAntiguedad * asignacionPorAñoAntiguedad);
		
		return sueldoBasico + sueldoFamiliar + antiguedad;
	}

	@Override
	double calcularRetenciones() {
		double obraSocial = (0.10 * calcularSueldoBruto()) + (cantidadHijos * retencionPorHijo);
		double aportesJubilatorios = 0.15 * calcularSueldoBruto();
		
		return obraSocial + aportesJubilatorios;
	}

	@Override
	public void desgloceConceptosSueldoBruto(ReciboDeHaberes recibo, Empleado e) {
		double sueldoFamiliar = (cantidadHijos * asignacionPorHijo) + (conyuge ? asignacionPorConyuge : 0);
		double antiguedad = (añosAntiguedad * asignacionPorAñoAntiguedad);
		
		recibo.agregarConcepto(new Concepto("Sueldo Basico", sueldoBasico));
        recibo.agregarConcepto(new Concepto("Sueldo Familiar", sueldoFamiliar));
        recibo.agregarConcepto(new Concepto("Antiguedad", antiguedad));
	}
	
	@Override
	public void desgloceConceptosRetenciones(ReciboDeHaberes recibo, Empleado e) {
		double obraSocial = (0.10 * calcularSueldoBruto()) + (cantidadHijos * retencionPorHijo);
		double aportesJubilatorios = 0.15 * calcularSueldoBruto();
		
		recibo.agregarConcepto(new Concepto("Obra Social", obraSocial));
		recibo.agregarConcepto(new Concepto("Aportes Jubilatorios", aportesJubilatorios));
	}
}
