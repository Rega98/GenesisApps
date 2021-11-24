/*
 * MODELO: Gasto
 * Crear el objeto de gasto para crear instancias
 */

package Model;
import java.util.Date;

/**
 * @author Jeanny and Teresita
 * @version 1.0
 */
public class Gasto {
    
    protected int folio;
    protected Date fecha;
    protected String definicion;
    protected float importeCiva;
    protected float importeSinva;
    protected int idTipoGasto;
    protected String rfGerente;
    
    public Gasto(){}

    public Gasto(int folio, Date fecha, String definicion, float importeCiva, float importeSinva, int idTipoGasto, String rfGerente) {
        this.folio = folio;
        this.fecha = fecha;
        this.definicion = definicion;
        this.importeCiva = importeCiva;
        this.importeSinva = importeSinva;
        this.idTipoGasto = idTipoGasto;
        this.rfGerente = rfGerente;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDefinicion() {
        return definicion;
    }

    public void setDefinicion(String definicion) {
        this.definicion = definicion;
    }

    public float getImporteCiva() {
        return importeCiva;
    }

    public void setImporteCiva(float importeCiva) {
        this.importeCiva = importeCiva;
    }

    public float getImporteSinva() {
        return importeSinva;
    }

    public void setImporteSinva(float importeSinva) {
        this.importeSinva = importeSinva;
    }

    public int getIdTipoGasto() {
        return idTipoGasto;
    }

    public void setIdTipoGasto(int idTipoGasto) {
        this.idTipoGasto = idTipoGasto;
    }

    public String getRfGerente() {
        return rfGerente;
    }

    public void setRfGerente(String rfGerente) {
        this.rfGerente = rfGerente;
    }
    
    
    
}
