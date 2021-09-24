package model;

public interface MIOperacion {
    void retirar(int monto, float costemovimiento);

    void transferir(int monto, Cuenta cuentaReferencia, float costemovimiento);

    void depositar(int monto, float costemovimiento);
}
