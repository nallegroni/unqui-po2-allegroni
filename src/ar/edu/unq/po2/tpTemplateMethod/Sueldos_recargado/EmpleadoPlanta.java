package ar.edu.unq.po2.tpTemplateMethod.Sueldos_recargado;

public class EmpleadoPlanta extends Empleado{

    private final double sueldoBasico = 3000;
    private final double pagoPorHijo = 150;

    public EmpleadoPlanta(int horasTrabajadas, boolean esCasado, int cantidadHijos) {
        super(0, false, cantidadHijos);
    }

    @Override
    public double calcularSueldoBruto() {
        double plusFamiliar = this.getCantidadHijos() * this.pagoPorHijo;

        return this.sueldoBasico + plusFamiliar;
    }
}
