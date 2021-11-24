/*
 * Funciones del CRUD

 */
package Interfaces;
import Model.Cliente;

/**
 *
 * @author Jeanny and Teresita
 */
import java.util.List;
public interface CRUD_Cliente {
    //MOSTRAR TODOS
    public List show();
    //BUSCAR UNO
    public Cliente details(String rfc);
    //AGREGAR
    public boolean add(Cliente clie);
    //EDITAR
    public boolean edit(Cliente clie);
    //ELIMINAR
    public boolean delete(String rfc);
    
}
