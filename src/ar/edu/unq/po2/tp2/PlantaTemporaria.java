package ar.edu.unq.po2.tp2;

import java.time.LocalDate;

public class PlantaTemporaria extends Empleado {
	
	private LocalDate fechaFinDesignacion;
	private int cantidadHorasExtras;
	
	public PlantaTemporaria(String nombre, String direccion, String estadoCivil, LocalDate fechaNacimiento,
			double sueldoBasico) {
		super(nombre, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
		// TODO Auto-generated constructor stub
	}
	
	public LocalDate getFechaFinDesignacion() {
		return fechaFinDesignacion;
	}

	public void setFechaFinDesignacion(LocalDate fechaFinDesignacion) {
		this.fechaFinDesignacion = fechaFinDesignacion;
	}

	public int getCantidadHorasExtras() {
		return cantidadHorasExtras;
	}

	public void setCantidadHorasExtras(int cantidadHorasExtras) {
		this.cantidadHorasExtras = cantidadHorasExtras;
	}

	@Override
	double sueldoBruto() {
		// TODO Auto-generated method stub
		return getSueldoBasico() + this.aportePorHorasExtras();
	}
	
	public double aportePorHorasExtras() {
		double valorPorHorasExtras = 40;
		return valorPorHorasExtras * getCantidadHorasExtras();
	}

	@Override
	double retenciones() {
		// TODO Auto-generated method stub
		return 0;
	}

}
