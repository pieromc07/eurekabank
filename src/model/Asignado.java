package model;

public class Asignado {
    private String codigo;
    private Sucursal sucursal;
    private Empleado empleado;
    private String fechaAlta;
    private String fechaBaja;


    public Asignado() {
    }

    public Asignado(String codigo, Sucursal sucursal, Empleado empleado, String fechaAlta, String fechaBaja) {
        this.codigo = codigo;
        this.sucursal = sucursal;
        this.empleado = empleado;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
    }


    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Sucursal getSucursal() {
        return this.sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Empleado getEmpleado() {
        return this.empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getFechaAlta() {
        return this.fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getFechaBaja() {
        return this.fechaBaja;
    }

    public void setFechaBaja(String fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

}
