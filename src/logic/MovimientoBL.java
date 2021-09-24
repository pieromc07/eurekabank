package logic;

import data.MovimientoDAL;
import model.Cuenta;

public class MovimientoBL {
    


    public static String vRetirar(int monto, float saldo) {
        if(monto > 0){
            if (monto < saldo) {
                    return "OK";
            }else{
                return "SALDO INSUFICIENTE";
            }
        }else{
            return "MONTO TIENE QUE SER MAYOR A 0";
        }
        // return "SURGIO UN !ERROR! INTENTELO MAS TARDE";
    }

    public static boolean RetirarCuenta(int monto, String cuenta) {
        return MovimientoDAL.retirar(monto, cuenta);
    }
    public static boolean TranferirCuenta(int monto, String cuenta, Cuenta cuentaReferencia) {
        return MovimientoDAL.transferir(monto, cuenta, cuentaReferencia.getCodigo());
    }
    public static boolean DespositarCuenta(int monto, String cuenta) {
        return MovimientoDAL.depositar(monto, cuenta);
    }

}
