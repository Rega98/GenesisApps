/*
 * MODELO: CatNomina
 * Crear el objeto de catNomina para crear instancias
 */

package Model;
import java.util.Date;

/**
 * @author Jeanny and Teresita
 * @version 1.0
 */
public class CatNomina {
    
    protected int folio; 
    protected Date fecha; 
    protected Date mesAnio;
    protected String periodo; 
    protected float monto;
    protected String rfcEmpleado;
    
    public CatNomina(){}

    public CatNomina(int folio, Date fecha, Date mesAnio, String periodo, float monto, String rfcEmpleado) {
        this.folio = folio;
        this.fecha = fecha;
        this.mesAnio = mesAnio;
        this.periodo = periodo;
        this.monto = monto;
        this.rfcEmpleado = rfcEmpleado;
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

    public Date getMesAnio() {
        return mesAnio;
    }

    public void setMesAnio(Date mesAnio) {
        this.mesAnio = mesAnio;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getRfcEmpleado() {
        return rfcEmpleado;
    }

    public void setRfcEmpleado(String rfcEmpleado) {
        this.rfcEmpleado = rfcEmpleado;
    }
    
    
    
}
