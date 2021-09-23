package model;

public class Empleado extends Persona {

    private String usuario;
    private String clave;

    public Empleado() {
    }

    public Empleado(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return this.clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Empleado usuario(String usuario) {
        setUsuario(usuario);
        return this;
    }

    public Empleado clave(String clave) {
        setClave(clave);
        return this;
    }

}
