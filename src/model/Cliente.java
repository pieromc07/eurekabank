package model;

public class Cliente extends Persona{
    private String dni;
    private String telefono;
    private String email;


    public Cliente() {
    }



    public Cliente(String dni, String telefono, String email) {
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
