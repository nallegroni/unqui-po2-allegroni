package ar.edu.unq.po2.tp2;

import java.time.LocalDate;

public class EmpleadoTemporal extends Empleado {
	
	private LocalDate fechaFinDesignacion;
	private int horasExtras;
	
	private static final double pagoPorHoraExtra = 40;
	private static final double retencionPorHoraExtra = 5;
	
	public EmpleadoTemporal(String nombre, String direccion, String estadoCivil, LocalDate fechaNacimiento,
			double sueldoBasico, LocalDate fechaFinDesignacion, int horasExtras) {
		super(nombre, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
		this.fechaFinDesignacion = fechaFinDesignacion;
		this.horasExtras = horasExtras;
	}

	@Override
	double calcularSueldoBruto() {
		double pagoHorasExtras = horasExtras * pagoPorHoraExtra;
				
		return sueldoBasico + pagoHorasExtras;
	}

	@Override
	double calcularRetenciones() {
		double obraSocial = (0.10 * calcularSueldoBruto()) + (esMayorDe_Años(50) ? 25 : 0);
		double aportesJubilatorios = (0.10 * calcularSueldoBruto()) + (horasExtras * retencionPorHoraExtra);
		
		return obraSocial + aportesJubilatorios;
	}
	
	boolean esMayorDe_Años(int edad) {
		return calcularEdad(fechaNacimiento) > edad;
	}
	
	@Override
	public void desgloceConceptosSueldoBruto(ReciboDeHaberes recibo, Empleado e) {
		double pagoHorasExtras = horasExtras * pagoPorHoraExtra;    
		
        recibo.agregarConcepto(new Concepto("Sueldo Basico", sueldoBasico));
        recibo.agregarConcepto(new Concepto("Horas Extras", pagoHorasExtras));
        
	}
	
	@Override
	public void desgloceConceptosRetenciones(ReciboDeHaberes recibo, Empleado e) {
		double obraSocial = (0.10 * calcularSueldoBruto()) + (esMayorDe_Años(50) ? 25 : 0);
		double aportesJubilatorios = (0.10 * calcularSueldoBruto()) + (horasExtras * retencionPorHoraExtra);
		
		recibo.agregarConcepto(new Concepto("Obra Social", obraSocial));
		recibo.agregarConcepto(new Concepto("Aportes Jubilatorios", aportesJubilatorios));
	}

}
