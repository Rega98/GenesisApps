/*
 * MODELO: Cliente
 * Crear el objeto de Cliente para crear instancias
 */
package Model;

/**
 *
 * @author Jeanny and Teresita
 */
public class Cliente {
    protected String  rfc;
    protected String  nombre;
    protected String  apPaterno;
    protected String  apMaterno;
    protected String  direccion;
    protected int telefono;
    protected String  correo;
   
    public Cliente(){}

    public Cliente(String rfc, String nombre, String apPaterno, String apMaterno, String direccion, int telefono, String correo) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}// llave que cierra

