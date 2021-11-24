/*
 * Funciones del CRUD
 */
package Interfaces;

import Model.Vale;
import java.util.List;

/**
 *
 * @author Jeanny and Teresita
 * @version 1.0
 */
public interface CRUD_Vale {
    // Mostrar todos
    public List show();
    // Buscar uno
    public Vale details(int folio);
    // Agregar
    public boolean add(Vale val);
    // Editar
    public boolean edit(Vale val);
    // Eliminar
    public boolean delete(int folio);
    
}
