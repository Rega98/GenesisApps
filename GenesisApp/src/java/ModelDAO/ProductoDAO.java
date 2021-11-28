/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelDAO;

import Config.Conexion;
import Interfaces.CRUD_Producto;
import Model.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jeanny and Teresita
 * @version 1.0
 */
public class ProductoDAO implements CRUD_Producto {
    // Instancia con la BD y derivados
    Conexion cox = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    // Instancia del objeto-modelo
    Producto prod = new Producto();

    // Método que Muestra Todos los Productos
    @Override
    public List show() {
        ArrayList<Producto> list = new ArrayList<>();
        String squery = "SELECT * FROM producto ORDER BY id;";
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Producto produ = new Producto();
                
                produ.setId(rs.getInt("id"));
                produ.setNombre(rs.getString("nombre"));
                produ.setDescripcion(rs.getString("descripcion"));
                produ.setPrecioVenta(rs.getFloat("precioVenta"));
                produ.setPrecioCompra(rs.getFloat("precioCompra"));
                produ.setIva(rs.getBoolean("iva"));
                produ.setStock(rs.getInt("stock"));
                produ.setCategoria(rs.getString("categoria"));
                
                list.add(produ);
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: ProductoDAO.show");
        }
        
        return list;
    }

    // Método que Muestra un Producto
    @Override
    public Producto details(int id) {
    
        String squery = "SELECT * FROM producto WHERE id="+id+";";
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            
            while(rs.next()){                
                prod.setId(rs.getInt("id"));
                prod.setNombre(rs.getString("nombre"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setPrecioVenta(rs.getFloat("precioVenta"));
                prod.setPrecioCompra(rs.getFloat("precioCompra"));
                prod.setIva(rs.getBoolean("iva"));
                prod.setStock(rs.getInt("stock"));
                prod.setCategoria(rs.getString("categoria"));
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: ProductoDAO.details");
        }
        
        return prod;
    }

    // Método que inserta un Producto
    @Override
    public boolean add(Producto prod) {
    String squery = "INSERT INTO producto (nombre, descripcion, precioventa, preciocompra, iva, stock, categoria)" 
                + "VALUES ('"+prod.getNombre()+"', '"+prod.getDescripcion()+"', "+prod.getPrecioVenta()+", "+prod.getPrecioCompra()+", "+prod.getIva()+", "+prod.getStock()+", '"+prod.getCategoria()+"');";
              
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: ProductoDAO.add");
        }
        
        return false;   
    }

    // Método que edita un Producto
    @Override
    public boolean edit(Producto prod) {
        String squery = "UPDATE producto SET nombre='"+prod.getNombre()+"', descripcion='"+prod.getDescripcion()+"', precioventa="+prod.getPrecioVenta()+", preciocompra="+prod.getPrecioCompra()+", iva="+prod.getIva()+", stock="+prod.getStock()+", categoria='"+prod.getCategoria()+"' WHERE id="+prod.getId()+";";

        System.out.println(squery);
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: ProductoDAO.edit");
        }
        
        return false;   
    }

    // Método que elimina un Producto
    @Override
    public boolean delete(int id) {
        
        String squery = "DELETE FROM producto WHERE id = "+id+";";
        
        System.out.println(squery);
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: ProductoDAO.delete");
        }
        
        return false;
    }



}