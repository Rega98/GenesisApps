/*
 * Funciones del CRUD
 */
package Interfaces;

import Model.Pago;
import java.util.List;

/**
 *
 * @author Jeanny and Teresita
 * @version 1.0
 */
public interface CRUD_Pago {
    // Mostrar todos
    public List show();
    // Buscar uno
    public Pago details(int folio);
    // Agregar
    public boolean add(Pago pag);
    // Editar
    public boolean edit(Pago pag);
    // Eliminar
    public boolean delete(int folio);
    
    
    
}
