/*
 * Funciones del CRUD
 */
package Interfaces;

import Model.Gasto;
import java.util.List;

/**
 *
 * @author Jeanny and Teresita
 * @version 1.0
 */
public interface CRUD_Gasto {
    // Mostrar todos
    public List show();
    // Buscar uno
    public Gasto details(int folio);
    // Agregar
    public boolean add(Gasto gast);
    // Editar
    public boolean edit(Gasto gast);
    // Eliminar
    public boolean delete(int folio);
    
}
