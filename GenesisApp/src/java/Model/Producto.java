/*
 * MODELO: Producto
 * Crear el objeto de producto para crear instancias
 */

package Model;

/**
 * @author Jeanny and Teresita
 * @version 1.0
 */
public class Producto {
    
    protected int id;
    protected String nombre;
    protected String descripcion;
    protected float precioVenta;
    protected float precioCompra;
    protected boolean iva;
    protected int stock;
    protected String categoria;
    
    public Producto(){}

    public Producto(int id, String nombre, String descripcion, float precioVenta, float precioCompra, boolean iva, int stock, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
        this.iva = iva;
        this.stock = stock;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public boolean getIva() {
        return iva;
    }

    public void setIva(boolean iva) {
        this.iva = iva;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
