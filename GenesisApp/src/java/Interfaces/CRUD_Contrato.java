/*
 * Funciones del CRUD

 */
package Interfaces;

import Model.Contrato;
import java.util.List;

/**
 *
 * @author Jeanny and Teresita
 */
public interface CRUD_Contrato {
        //MOSTRAR TODOS
    public List show();
    //BUSCAR UNO
    public Contrato details(int folio);
    //AGREGAR
    public boolean add(Contrato cont);
    //EDITAR
    public boolean edit(Contrato cont);
    //ELIMINAR
    public boolean delete(int folio);
    
}
    

