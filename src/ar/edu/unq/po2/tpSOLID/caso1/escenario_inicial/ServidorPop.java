package ar.edu.unq.po2.tpSOLID.caso1.escenario_inicial;

import java.util.ArrayList;
import java.util.List;

public class ServidorPop implements IServidor {

	public List<Correo> recibirNuevos(String user, String pass) {
		List<Correo> retorno = new ArrayList<Correo>();
	  //Verificar autenticidad de usuario.
		//obtener emails Nuevos del usuario.
		//asignar a retorno la lista de los nuevos e-mails.
		return retorno;
	}

	public void conectar(String nombreUsuario, String passusuario) {
	   //Verifica que el usuario sea valido y establece la conexion.
		
	}

	public void enviar(Correo correo) {
      //realiza lo necesario para enviar el correo.		
	}

	@Override
	public float tazaDeTransferencia() {
		//no corresponde
		return 0;
	}

	@Override
	public void resetear() {
         //no corresponde		
	}

	@Override
	public void realizarBackUp() {
		//no corresponde
		
	}



}
