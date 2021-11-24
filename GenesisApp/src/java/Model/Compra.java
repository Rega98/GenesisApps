/*
 * MODELO: Cliente
 * Crear el objeto de Compra para crear instancias
 */
package Model;

/**
 *
* @author Jeanny and Teresita
 */
import java.util.Date;
public class Compra {
 
   protected int folio; 
   protected Date fechaCompra; 
   protected int cantidad;
   protected boolean iva;
   protected int montoTotal;
   protected String estado;
   protected String rfcProveedor;
   protected int productoid;
   
   public Compra(){}

    public Compra(int folio, Date fechaCompra, int cantidad, boolean iva, int montoTotal, String estado, String rfcProveedor, int productoid) {
        this.folio = folio;
        this.fechaCompra = fechaCompra;
        this.cantidad = cantidad;
        this.iva = iva;
        this.montoTotal = montoTotal;
        this.estado = estado;
        this.rfcProveedor = rfcProveedor;
        this.productoid = productoid;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isIva() {
        return iva;
    }

    public void setIva(boolean iva) {
        this.iva = iva;
    }

    public int getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(int montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRfcProveedor() {
        return rfcProveedor;
    }

    public void setRfcProveedor(String rfcProveedor) {
        this.rfcProveedor = rfcProveedor;
    }

    public int getProductoid() {
        return productoid;
    }

    public void setProductoid(int productoid) {
        this.productoid = productoid;
    }
   
   
   
}// llave que cierra
