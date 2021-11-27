/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelDAO;

import Config.Conexion;
import Interfaces.CRUD_Proveedor;
import Model.Proveedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jeanny and Teresita
 * @version 1.0
 */
public class ProveedorDAO implements CRUD_Proveedor {
    // Instancia con la BD y derivados
    Conexion cox = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    // Instancia del objeto-modelo
    Proveedor prov = new Proveedor();

    // Método que Muestra Todos los Proveedores
    @Override
    public List show() {
        ArrayList<Proveedor> list = new ArrayList<>();
        String squery = "SELECT * FROM proveedor ORDER BY rfc;";
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Proveedor prove = new Proveedor();
                
                prove.setRfc(rs.getString("rfc"));
                prove.setNombre(rs.getString("nombre"));
                prove.setDireccion(rs.getString("direccion"));
                prove.setTelefono(rs.getString("telefono"));
                prove.setCorreo(rs.getString("correo"));
                
                list.add(prove);
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: ProveedorDAO.show");
        }
        
        return list;
    }

    // Método que Muestra un Proveedor
    @Override
    public Proveedor details(String rfc) {
        String squery = "SELECT * FROM proveedor WHERE rfc="+rfc+";";
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            
            while(rs.next()){                
                prov.setRfc(rs.getString("rfc"));
                prov.setNombre(rs.getString("nombre"));
                prov.setDireccion(rs.getString("direccion"));
                prov.setTelefono(rs.getString("telefono"));
                prov.setCorreo(rs.getString("correo"));
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: ProvedorDAO.details");
        }
        
        return prov;
    }

    // Método que inserta un Proveedor
    @Override
    public boolean add(Proveedor prov) {
        String squery = "INSERT INTO proveedor (rfc,nombre,direccion,telefono,correo)" 
                + "VALUES ('"+prov.getRfc()+"', '"+prov.getNombre()+"', '"+prov.getDireccion()+"',"+prov.getTelefono()+", '"+prov.getCorreo()+"');";
              
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: ProvedorDAO.add");
        }
        
        return false;
    }

    // Método que edita un Proveedor
    @Override
    public boolean edit(Proveedor prov) {
        String squery = "UPDATE proveedor SET rfc='"+prov.getRfc()+"', nombre='"+prov.getNombre()+"', "
                + "direccion='"+prov.getDireccion()+"', telefono="+prov.getTelefono()+", correo='"+prov.getCorreo()+"'WHERE rfc='"+prov.getRfc()+"';";
	
        System.out.println(squery);
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: ProvedorDAO.edit");
        }
        
        return false;
    }

    // Método que elimina un Proveedor
    @Override
    public boolean delete(String rfc) {
      String squery = "DELETE * FROM proveedor WHERE rfc = "+rfc+";";
        
        System.out.println(squery);
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: ProvedorDAO.delete");
        }
        
        return false;
    }
    
}
