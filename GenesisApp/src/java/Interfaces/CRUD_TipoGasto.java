/*
 * Funciones del CRUD
 */
package Interfaces;

import Model.TipoGasto;
import java.util.List;

/**
 *
 * @author Jeanny and Teresita
 * @version 1.0
 */
public interface CRUD_TipoGasto {
     // Mostrar todos
    public List show();
    // Buscar uno
    public TipoGasto details(int id);
    // Agregar
    public boolean add(TipoGasto tipogast);
    // Editar
    public boolean edit(TipoGasto tipogast);
    // Eliminar
    public boolean delete(int id);    
    
}
