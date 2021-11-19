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
    public List show();
    public Proveedor details(String id);
    public boolean add(Proveedor prov);
    public boolean edit(Proveedor prov);
    public boolean delete(String id);
}
