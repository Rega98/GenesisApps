/*
 * Funciones del CRUD

 */
package Interfaces;

import Model.Compra;
import java.util.List;

/**
 *
 * @author Jeanny and Teresita
 */
public interface CRUD_Compra {
    //MOSTRAR TODOS
    public List show();
    //BUSCAR UNO
    public Compra details(int folio);
    //AGREGAR
    public boolean add(Compra com);
    //EDITAR
    public boolean edit(Compra com);
    //ELIMINAR
    public boolean delete(int folio);
    
}
