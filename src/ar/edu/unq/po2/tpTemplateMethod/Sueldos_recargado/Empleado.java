package ar.edu.unq.po2.tpTemplateMethod.Sueldos_recargado;

public abstract class Empleado {
    private int horasTrabajadas;
    private boolean esCasado;
    private int cantidadHijos;

    public Empleado(int horasTrabajadas, boolean esCasado, int cantidadHijos) {
        this.horasTrabajadas = horasTrabajadas;
        this.esCasado = esCasado;
        this.cantidadHijos = cantidadHijos;
    }

    protected int getHorasTrabajadas() {
        return this.horasTrabajadas;
    }

    protected int getCantidadHijos() {
        return this.cantidadHijos;
    }

    protected boolean getEsCasado() {
        return this.esCasado;
    }

    public final double sueldo() {
        double sueldoBruto = this.calcularSueldoBruto();
        double descuentos = this.calcularDescuento(sueldoBruto);
        
        return sueldoBruto - descuentos;       
    } 

    public abstract double calcularSueldoBruto();

    public double calcularDescuento(double sueldoBruto) {
        return sueldoBruto * 0.13;
    }
}
