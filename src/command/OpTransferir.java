package command;

import model.Cuenta;

public class OpTransferir implements IOperacion {

    private Cuenta cuenta;
    private int monto;
    private float costemovimiento;
    private Cuenta cuentaReferencia;

    public Cuenta getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public int getMonto() {
        return this.monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }


    public float getCostemovimiento() {
        return this.costemovimiento;
    }

    public void setCostemovimiento(float costemovimiento) {
        this.costemovimiento = costemovimiento;
    }

    public Cuenta getCuentaReferencia() {
        return this.cuentaReferencia;
    }

    public void setCuentaReferencia(Cuenta cuentaReferencia) {
        this.cuentaReferencia = cuentaReferencia;
    }
  

    public OpTransferir(Cuenta cuenta, int monto, float costemovimiento, Cuenta cuentaReferencia) {
        this.cuenta = cuenta;
        this.monto = monto;
        this.costemovimiento = costemovimiento;
        this.cuentaReferencia = cuentaReferencia;
    }


    @Override
    public void execute() {
        this.cuenta.transferir(monto, cuentaReferencia, costemovimiento);

    }
}
