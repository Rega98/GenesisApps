/*
 * MODELO: Empleado
 * Crear el objeto de Empleado para crear instancias
 */
package Model;

/**
 *
 * @author Jeanny and Teresita
 */
public class Empleado {
  protected String rfc;
   protected String nombre;
   protected String apPaterno; 
   protected String apMaterno;
   protected String user;
   protected String pass;
   protected String tipo;
     
   public Empleado(){}

    public Empleado(String rfc, String nombre, String apPaterno, String apMaterno, String user, String pass, String tipo) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.user = user;
        this.pass = pass;
        this.tipo = tipo;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
   
   
    
}// llave que cierra
