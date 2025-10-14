package ar.edu.unq.po2.tpSOLID.sistema_informatico;

public class Cliente {
    private String nombre;
    private String apellido;
    private String direccion;
    private int edad;
    private float sueldoNeto;

    public Cliente(String nombre, String apellido, String direccion, int edad, float sueldoNeto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.edad = edad;
        this.sueldoNeto = sueldoNeto;
    }

    public int getEdad() {
        return edad;
    }

    public float getSueldoNeto() {
        return this.sueldoNeto;
    }

    public float getSueldoNetoAnual() {
        return this.sueldoNeto * 12;
    }
}
