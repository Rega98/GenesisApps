/*
 * Funciones del CRUD
 */
package Interfaces;

import Model.Producto;
import java.util.List;

/**
 *
 * @author Jeanny and Teresita
 * @version 1.0
 */
public interface CRUD_Producto {
    // Mostrar todos
    public List show();
    // Buscar uno
    public Producto details(int id);
    // Agregar
    public boolean add(Producto prod);
    // Editar
    public boolean edit(Producto prod);
    // Eliminar
    public boolean delete(int id);
}
