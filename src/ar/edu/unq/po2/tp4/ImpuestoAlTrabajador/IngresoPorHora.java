package ar.edu.unq.po2.tp4.ImpuestoAlTrabajador;


public class IngresoPorHora extends Ingreso {
	private int horasExtras;

	public IngresoPorHora(int mes, String concepto, double monto, int horasExtras) {
		super(mes, concepto, monto);
		this.horasExtras = horasExtras;
	}	
	
	@Override
	public double getMontoImponible() {
		return 0;
	}
	
	public int getHorasExtras() {
		return horasExtras;
	}
}
