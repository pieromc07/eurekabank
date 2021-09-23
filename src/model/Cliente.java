package model;

public class Cliente extends Persona{
    private String dni;
    private String telefono;


    public Cliente() {
    }


    public Cliente(String dni, String telefono) {
        this.dni = dni;
        this.telefono = telefono;
    }


    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
