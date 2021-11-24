/*
 * MODELO: Pago
 * Crear el objeto de pago para crear instancias
 */

package Model;
import java.util.Date;

/**
 * @author Jeanny and Teresita
 * @version 1.0
 */
public class Pago {
    
    protected int folio;
    protected Date fecha;
    protected float monto;
    protected int contratofolio;
    protected String rfcCobrador; 
    
    public Pago(){}

    public Pago(int folio, Date fecha, float monto, int contratofolio, String rfcCobrador) {
        this.folio = folio;
        this.fecha = fecha;
        this.monto = monto;
        this.contratofolio = contratofolio;
        this.rfcCobrador = rfcCobrador;
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

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public int getContratofolio() {
        return contratofolio;
    }

    public void setContratofolio(int contratofolio) {
        this.contratofolio = contratofolio;
    }

    public String getRfcCobrador() {
        return rfcCobrador;
    }

    public void setRfcCobrador(String rfcCobrador) {
        this.rfcCobrador = rfcCobrador;
    }
    
    
    
}
