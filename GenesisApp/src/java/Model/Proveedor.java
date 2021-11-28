/*
 * MODELO: Proveedor
 * Crear el objeto de proveedor para crear instancias
 */

package Model;

/**
 * @author Jeanny and Teresita
 * @version 1.0
 */
public class Proveedor {
    
    protected String rfc;
    protected String nombre;
    protected String direccion;
    protected String telefono;
    protected String correo; 
    
    public Proveedor(){}

    public Proveedor(String rfc, String nombre, String direccion, String telefono, String correo) {
        this.rfc = rfc;
        this.nombre = nombre;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
