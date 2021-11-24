/*
 * MODELO: Vale
 * Crear el objeto de vale para crear instancias
 */

package Model;
import java.util.Date;

/**
 * @author Jeanny and Teresita
 * @version 1.0
 */
public class Vale {
    
    protected int folio;  
    protected float monto;
    protected Date fechaVale; 
    protected String concepto;  
    protected String rfcVendedor;
    
    public Vale(){}

    public Vale(int folio, float monto, Date fechaVale, String concepto, String rfcVendedor) {
        this.folio = folio;
        this.monto = monto;
        this.fechaVale = fechaVale;
        this.concepto = concepto;
        this.rfcVendedor = rfcVendedor;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Date getFechaVale() {
        return fechaVale;
    }

    public void setFechaVale(Date fechaVale) {
        this.fechaVale = fechaVale;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getRfcVendedor() {
        return rfcVendedor;
    }

    public void setRfcVendedor(String rfcVendedor) {
        this.rfcVendedor = rfcVendedor;
    }
    
    
    
}
