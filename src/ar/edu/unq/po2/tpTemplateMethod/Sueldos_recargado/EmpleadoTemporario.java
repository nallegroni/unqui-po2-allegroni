package ar.edu.unq.po2.tpTemplateMethod.Sueldos_recargado;

public class EmpleadoTemporario extends Empleado {

    private final double sueldoBasico = 1000;
    private final double pagoPorHora = 5;
    private final double plusFamiliar = 100;

    public EmpleadoTemporario(int horasTrabajadas, boolean esCasado, int cantidadHijos) {
        super(horasTrabajadas, esCasado, cantidadHijos);
    }

    @Override
    public double calcularSueldoBruto() {
        double sueldoPorHoras = this.getHorasTrabajadas() * this.pagoPorHora;
        double plusFamiliar = 0;

        if (this.getEsCasado() || this.getCantidadHijos() > 0) {
            plusFamiliar = this.plusFamiliar;
        }


        return this.sueldoBasico + sueldoPorHoras + plusFamiliar;
    }
}
