package model;

public class Sucursal {
    private String codigo;
    private String nombre;
    private String ciudad;
    private String direccion;
    private int contadorCuenta;

    public Sucursal() {
    }

    public Sucursal(String codigo, String nombre, String ciudad, String direccion, int contadorCuenta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.contadorCuenta = contadorCuenta;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getContadorCuenta() {
        return this.contadorCuenta;
    }

    public void setContadorCuenta(int contadorCuenta) {
        this.contadorCuenta = contadorCuenta;
    }

}
