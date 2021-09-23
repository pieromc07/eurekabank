package model;

public class Movimiento {
    private Cuenta cuenta;
    private int numero;
    private String fecha;
    private Empleado empleado;
    private TipoMovimiento tipoMovimiento;
    private float importe;
    private String cuentaReferencia;

    public Movimiento() {
    }

    public Movimiento(Cuenta cuenta, int numero, String fecha, Empleado empleado, TipoMovimiento tipoMovimiento,
            float importe, String cuentaReferencia) {
        this.cuenta = cuenta;
        this.numero = numero;
        this.fecha = fecha;
        this.empleado = empleado;
        this.tipoMovimiento = tipoMovimiento;
        this.importe = importe;
        this.cuentaReferencia = cuentaReferencia;
    }

    public Cuenta getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Empleado getEmpleado() {
        return this.empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public TipoMovimiento getTipoMovimiento() {
        return this.tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public float getImporte() {
        return this.importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public String getCuentaReferencia() {
        return this.cuentaReferencia;
    }

    public void setCuentaReferencia(String cuentaReferencia) {
        this.cuentaReferencia = cuentaReferencia;
    }

}
