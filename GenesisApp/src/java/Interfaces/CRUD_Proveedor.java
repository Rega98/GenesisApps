/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import Model.Proveedor;
import java.util.List;

/**
 *
 * @author IsmaSL
 */
public interface CRUD_Proveedor {
    // Mostrar todos
    public List show();
    // Buscar uno
    public Proveedor details(String rfc);
    // Agregar
    public boolean add(Proveedor prov);
    // Editar
    public boolean edit(Proveedor prov);
    // Eliminar
    public boolean delete(String rfc);
}
