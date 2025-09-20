package ar.edu.unq.po2.tp5;

public abstract class Factura implements Cobrable {
	
	private Agencia agencia = new AgenciaRecaudadora("ARCA");
	
	public Factura() {
		
	}
	
	public abstract double getMontoAPagar();
	
	public void notificarAgencia() {
		agencia.registrarPago(this);
	}
}
