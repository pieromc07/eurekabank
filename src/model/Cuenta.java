package model;

public class Cuenta {
    private String codigo;
    private Moneda moneda;
    private Sucursal sucursal;
    private Empleado empleado;
    private Cliente cliente;
    private float saldo;
    private String fechaCreacion;
    private String estado;
    private int contadorMovimiento;
    private String clave;

    public Cuenta() {
    }

    public Cuenta(String codigo, Moneda moneda, Sucursal sucursal, Empleado empleado, Cliente cliente, float saldo,
            String fechaCreacion, String estado, int contadorMovimiento, String clave) {
        this.codigo = codigo;
        this.moneda = moneda;
        this.sucursal = sucursal;
        this.empleado = empleado;
        this.cliente = cliente;
        this.saldo = saldo;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.contadorMovimiento = contadorMovimiento;
        this.clave = clave;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Moneda getMoneda() {
        return this.moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
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

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public float getSaldo() {
        return this.saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getContadorMovimiento() {
        return this.contadorMovimiento;
    }

    public void setContadorMovimiento(int contadorMovimiento) {
        this.contadorMovimiento = contadorMovimiento;
    }

    public String getClave() {
        return this.clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

}
