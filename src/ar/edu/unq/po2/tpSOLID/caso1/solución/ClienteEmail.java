package ar.edu.unq.po2.tpSOLID.caso1.solución;

import java.util.ArrayList;

public class ClienteEmail {
    
    // Depende de la abstracción, no de la implementación
    private IClienteServidor servidor;
    private String nombreUsuario;
    private String passusuario;
    private ArrayList<Correo> inbox;
    private ArrayList<Correo> borrados;
    
    
    public ClienteEmail(IClienteServidor servidor, String nombreUsuario, String pass){
        this.servidor = servidor;
        this.nombreUsuario = nombreUsuario;
        this.passusuario = pass;
        this.inbox = new ArrayList<Correo>();
        this.borrados = new ArrayList<Correo>();
        this.conectar();
    }
    
    public void conectar(){
        this.servidor.conectar(this.nombreUsuario, this.passusuario);
    }
    
    public void borrarCorreo(Correo correo){
        this.inbox.remove(correo);
        this.borrados.add(correo);
    }
    
    public int contarBorrados(){
        return this.borrados.size();
    }
    
    public int contarInbox(){
        return this.inbox.size();
    }
    
    public void eliminarBorrado(Correo correo){
        this.borrados.remove(correo);
    }
    
    public void recibirNuevos(){
        this.inbox.addAll(this.servidor.recibirNuevos(this.nombreUsuario, this.passusuario));
    }
    
    public void enviarCorreo(String asunto, String destinatario, String cuerpo){
        Correo correo = new Correo(asunto, destinatario, cuerpo);
        this.servidor.enviar(correo);
    }
}