package ar.edu.unq.po2.tp5;

public class FacturaServicio extends Factura {
	
	private double costoPorUnidad;
	private int unidadesConsumidas;
	
	public FacturaServicio(double costoPorUnidad, int unidadesConsumidas) {
		this.costoPorUnidad = costoPorUnidad;
		this.unidadesConsumidas = unidadesConsumidas;
	}

	@Override
	public double getMontoAPagar() {
		return costoPorUnidad * unidadesConsumidas;
	}

}
