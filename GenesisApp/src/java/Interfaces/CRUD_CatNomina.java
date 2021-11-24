/*
 * Funciones del CRUD
 */
package Interfaces;

import Model.CatNomina;
import java.util.List;

/**
 *
 * @author Jeanny and Teresita
 * @version 1.0
 */
public interface CRUD_CatNomina {
    // Mostrar todos
    public List show();
    // Buscar uno
    public CatNomina details(int folio);
    // Agregar
    public boolean add(CatNomina cnomi);
    // Editar
    public boolean edit(CatNomina cnomi);
    // Eliminar
    public boolean delete(int folio);
    
}
