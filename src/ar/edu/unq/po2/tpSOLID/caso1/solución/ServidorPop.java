package ar.edu.unq.po2.tpSOLID.caso1.solución;

import java.util.ArrayList;
import java.util.List;

// Ahora solo implementa la interfaz que le corresponde
public class ServidorPop implements IClienteServidor {

    @Override
    public List<Correo> recibirNuevos(String user, String pass) {
        List<Correo> retorno = new ArrayList<Correo>();
        //Verificar autenticidad de usuario.
        //obtener emails Nuevos del usuario.
        //asignar a retorno la lista de los nuevos e-mails.
        System.out.println("Recibiendo correos para " + user);
        return retorno;
    }

    @Override
    public void conectar(String nombreUsuario, String passusuario) {
       //Verifica que el usuario sea valido y establece la conexion.
       System.out.println("Conectando a " + nombreUsuario + " en servidor POP.");
    }

    @Override
    public void enviar(Correo correo) {
      //realiza lo necesario para enviar el correo.
      System.out.println("Enviando correo vía POP...");
    }
}
