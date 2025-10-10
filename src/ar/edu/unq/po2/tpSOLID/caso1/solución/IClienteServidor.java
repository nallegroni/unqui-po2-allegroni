package ar.edu.unq.po2.tpSOLID.caso1.solución;

import java.util.List;

public interface IClienteServidor {
    
    public void conectar(String nombreUsuario, String passusuario);
    
    public List<Correo> recibirNuevos(String user, String pass);

    public void enviar(Correo correo);
}
