package ar.edu.unq.po2.tp5;

public class AgenciaRecaudadora implements Agencia{
	
	private String nombre;
	
	public AgenciaRecaudadora(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public void registrarPago(Factura f) {}

	public String getNombre() {
		return nombre;
	}

}
