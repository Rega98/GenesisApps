/*
 * Funciones del CRUD

 */
package Interfaces;

import Model.Observacion;
import java.util.List;

/**
 *
 * @author Jeanny and Teresita
 */
public interface CRUD_Observacion {
        //MOSTRAR TODOS
    public List show(int folio);
    //BUSCAR UNO
    public Observacion details(int id);
    //AGREGAR
    public boolean add(Observacion obs);
    //EDITAR
    public boolean edit(Observacion obs);
    //ELIMINAR
    public boolean delete(int id);
    
}
