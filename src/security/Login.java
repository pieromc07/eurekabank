/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import model.Cliente;
import model.CostoMovimiento;
import model.Cuenta;
import model.Moneda;

/**
 *
 * @author Piero
 */
public class Login {
    
    private Cuenta cuenta;
    private Cliente cliente;
    private CostoMovimiento  costoMovimiento;

    public Login() {
    }

    

    public Login(Cuenta cuenta, Cliente cliente, CostoMovimiento costoMovimiento) {
        this.cuenta = cuenta;
        this.cliente = cliente;
        this.costoMovimiento = costoMovimiento;
    }

    public Cuenta getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public CostoMovimiento getCostoMovimiento() {
        return this.costoMovimiento;
    }

    public void setCostoMovimiento(CostoMovimiento costoMovimiento) {
        this.costoMovimiento = costoMovimiento;
    }


}
