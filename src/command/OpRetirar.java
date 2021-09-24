package command;

import model.Cuenta;

public class OpRetirar  implements IOperacion{

    private Cuenta cuenta;
	private int monto;
    private float coste;

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


	public OpRetirar(Cuenta cuenta, int monto, float coste) {
		this.cuenta = cuenta;
		this.monto = monto;
        this.coste = coste;

	}


    @Override
    public void execute() {
        this.cuenta.retirar(this.monto, this.coste);
        
    }
    
}
