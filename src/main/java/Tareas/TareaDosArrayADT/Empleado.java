package Tareas.TareaDosArrayADT;

import java.time.Year;

public class Empleado {
    private int numTrabajador;
    private String nombres;
    private String apePaterno;
    private String apeMaterno;
    private int horasExtra;
    private float sueldoBase;
    private int anioIngreso;
    private static final float PAGA_POR_HORA_EXTRA = 276.5f;
    private static final int PORCENTAJE_POR_ANIO_DE_ANTIGUEDAD = 3;
    private static final int CIEN_PORCIENTO = 100;
    private final int anioActual = Year.now().getValue();

    public Empleado() {
    }

    public Empleado(int numTrabajador, String nombres, String apePaterno, String apeMaterno, int horasExtra, int sueldoBase, int anioIngreso) {
        this.numTrabajador = numTrabajador;
        this.nombres = nombres;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.horasExtra = horasExtra;
        this.sueldoBase = sueldoBase;
        this.anioIngreso = anioIngreso;
    }

    public int getNumTrabajador() {
        return numTrabajador;
    }

    public void setNumTrabajador(int numTrabajador) {
        this.numTrabajador = numTrabajador;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }

    public float getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(float sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(int anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "numTrabajador=" + numTrabajador +
                ", nombres='" + nombres + '\'' +
                ", apePaterno='" + apePaterno + '\'' +
                ", apeMaterno='" + apeMaterno + '\'' +
                ", horasExtra=" + horasExtra +
                ", sueldoBase=" + sueldoBase +
                ", anioIngreso=" + anioIngreso +
                '}';
    }

    public float calcularSueldo() {
        float sueldoExtra = horasExtra * PAGA_POR_HORA_EXTRA;
        int porcentajeTotal = PORCENTAJE_POR_ANIO_DE_ANTIGUEDAD * (anioActual - anioIngreso);
        float sueldoTotal = (sueldoBase * porcentajeTotal) / CIEN_PORCIENTO;
        sueldoTotal = sueldoExtra + sueldoTotal + sueldoBase;

        return sueldoTotal;
    }
}
