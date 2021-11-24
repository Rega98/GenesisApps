/*
 * Funciones del CRUD

 */
package Interfaces;

import Model.Ruta;
import java.util.List;

/**
 *
 * @author Jeanny and Teresita
 */
public interface CRUD_Ruta {
        //MOSTRAR TODOS
    public List show();
    //BUSCAR UNO
    public Ruta details(int idRuta);
    //AGREGAR
    public boolean add(Ruta rut);
    //EDITAR
    public boolean edit(Ruta rut);
    //ELIMINAR
    public boolean delete(int idRuta);
    
}
