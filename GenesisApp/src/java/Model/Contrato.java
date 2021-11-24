/*
 * MODELO: Cliente
 * Crear el objeto de Contrato para crear instancias
 */
package Model;

/**
 *
* @author Jeanny and Teresita
 */
import java.util.Date;

public class Contrato {
    
   protected int folio; 
   protected float enganche;
   protected String planPago;
   protected String diaCobro;
   protected String estado;
   protected Date fechaContrato; 
   protected float subtotal;
   protected float iva;
   protected float total;
   protected String rfcVendedor;
   protected String rfcCliente;
   protected int idProducto; 
   protected int idRuta; 
   
    public Contrato(){}

    public Contrato(int folio, float enganche, String planPago, String diaCobro, String estado, Date fechaContrato, float subtotal, float iva, float total, String rfcVendedor, String rfcCliente, int idProducto, int idRuta) {
        this.folio = folio;
        this.enganche = enganche;
        this.planPago = planPago;
        this.diaCobro = diaCobro;
        this.estado = estado;
        this.fechaContrato = fechaContrato;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.rfcVendedor = rfcVendedor;
        this.rfcCliente = rfcCliente;
        this.idProducto = idProducto;
        this.idRuta = idRuta;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public float getEnganche() {
        return enganche;
    }

    public void setEnganche(float enganche) {
        this.enganche = enganche;
    }

    public String getPlanPago() {
        return planPago;
    }

    public void setPlanPago(String planPago) {
        this.planPago = planPago;
    }

    public String getDiaCobro() {
        return diaCobro;
    }

    public void setDiaCobro(String diaCobro) {
        this.diaCobro = diaCobro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(Date fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getRfcVendedor() {
        return rfcVendedor;
    }

    public void setRfcVendedor(String rfcVendedor) {
        this.rfcVendedor = rfcVendedor;
    }

    public String getRfcCliente() {
        return rfcCliente;
    }

    public void setRfcCliente(String rfcCliente) {
        this.rfcCliente = rfcCliente;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }
    
    
    
    
}// llave que cierra
