/*
 * MODELO: TipoGasto
 * Crear el objeto de TipoGasto para crear instancias
 */

package Model;

/**
 * @author Jeanny and Teresita
 * @version 1.0
 */
public class TipoGasto {
    
    protected int id;       
    protected String descripcion;
    protected String tipo;
    
    public TipoGasto(){}

    public TipoGasto(int id, String descripcion, String tipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}
