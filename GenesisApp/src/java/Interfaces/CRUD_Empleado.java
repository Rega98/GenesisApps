/*
 * Funciones del CRUD

 */
package Interfaces;

import Model.Empleado;
import java.util.List;

/**
 *
 * @author Jeanny and Teresita
 */
public interface CRUD_Empleado {
        //MOSTRAR TODOS
    public List show();
    //BUSCAR UNO
    public Empleado details(String rfc);
    //AGREGAR
    public boolean add(Empleado emp);
    //EDITAR
    public boolean edit(Empleado emp);
    //ELIMINAR
    public boolean delete(String rfc);
    
}
  