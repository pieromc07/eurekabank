package model;

public class CostoMovimiento {
    private String codigo;
    private float importe;

    public CostoMovimiento() {
    }

    public CostoMovimiento(String codigo, float importe) {
        this.codigo = codigo;
        this.importe = importe;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getImporte() {
        return this.importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

}
