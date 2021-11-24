/*
 * MODELO: Observacion
 * Crear el objeto de Observacion para crear instancias
 */
package Model;

/**
 *
 * @author Jeanny and Teresita
 */
import java.util.Date;
public class Observacion {
  
  protected int id; 
  protected Date fecha; 
  protected String observacion;
  protected int contratofolio; 
  
  public Observacion(){}

    public Observacion(int id, Date fecha, String observacion, int contratofolio) {
        this.id = id;
        this.fecha = fecha;
        this.observacion = observacion;
        this.contratofolio = contratofolio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getContratofolio() {
        return contratofolio;
    }

    public void setContratofolio(int contratofolio) {
        this.contratofolio = contratofolio;
    }
  
    
}// llave que cierra
