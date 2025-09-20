package ar.edu.unq.po2.tp5;

public class FacturaImpuesto extends Factura {
	
	private double tasaDeServicio;
	
	public FacturaImpuesto(double tasaDeServicio) {
		this.tasaDeServicio = tasaDeServicio;
	}

	@Override
	public double getMontoAPagar() {
		return tasaDeServicio;
	}

}
