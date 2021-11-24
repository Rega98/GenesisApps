/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Config.Conexion;
import Interfaces.CRUD_Cliente;
import Model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Windows 10 Pro
 */
public class ClienteDAO implements CRUD_Cliente {
    // Instancia con la BD y derivados
    Conexion cox = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    // Instancia del objeto-modelo
    Cliente clie = new Cliente();
    
    // Método que Muestra Todos los Proveedores

    @Override
    public List show() {
       ArrayList<Cliente> list = new ArrayList<>();
        String squery = "SELECT * FROM cliente ORDER BY rfc;";
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Cliente clie = new Cliente();
               
                clie.setRfc(rs.getString("rfc"));
                clie.setNombre(rs.getString("nombre"));
                clie.setApPaterno(rs.getString("apPaterno"));
                clie.setApMaterno(rs.getString("apMaterno"));
                clie.setDireccion(rs.getString("direccion"));
                clie.setTelefono(rs.getInt("telefono"));
                clie.setCorreo(rs.getString("correo"));
                
                
                
                list.add(clie);
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: ClienteDAO.show");
        }
        
        return list;
    
    }

    @Override
    public Cliente details(String rfc) {
          String squery = "SELECT * FROM cliente WHERE sno="+rfc+";";
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            
            while(rs.next()){                
                clie.setRfc(rs.getString("rfc"));
                clie.setNombre(rs.getString("nombre"));
                clie.setApPaterno(rs.getString("apPaterno"));
                clie.setApMaterno(rs.getString("apMaterno"));
                clie.setDireccion(rs.getString("direccion"));
                clie.setTelefono(rs.getInt("telefono"));
                clie.setCorreo(rs.getString("correo"));
                
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: ClienteDAO.details");
        }
        
        return clie;
    }

    @Override
    public boolean add(Cliente clie) {
       String squery = "INSERT INTO cliente (sname) VALUES ('"+clie.getRfc()+"');";
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: ClienteDAO.add");
        }
        
        return false;
    }
    @Override
    public boolean edit(Cliente clie) {
        String squery = "UPDATE cliente SET sname='"+clie.getRfc()+"' WHERE sno = "+clie.getRfc()+";";
     
        System.out.println(squery);
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: ClienteDAO.edit");
        }
        
        return false;
    }
    @Override
    public boolean delete(String rfc) {
         String squery = "DELETE FROM cliente WHERE sno = "+rfc+";";
        
        System.out.println(squery);
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: ClienteDAO.delete");
        }
        
        return false;
    }
}
