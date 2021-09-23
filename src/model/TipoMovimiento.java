package model;

public class TipoMovimiento {
    private String codigo;
    private String descripcion;
    private String tipoAccion;
    private String tipoEstado;

    public TipoMovimiento() {
    }

    public TipoMovimiento(String codigo, String descripcion, String tipoAccion, String tipoEstado) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipoAccion = tipoAccion;
        this.tipoEstado = tipoEstado;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoAccion() {
        return this.tipoAccion;
    }

    public void setTipoAccion(String tipoAccion) {
        this.tipoAccion = tipoAccion;
    }

    public String getTipoEstado() {
        return this.tipoEstado;
    }

    public void setTipoEstado(String tipoEstado) {
        this.tipoEstado = tipoEstado;
    }

}
