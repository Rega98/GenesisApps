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
 * @author IsmaSL
 */
public class ProveedorDAO implements CRUD_Proveedor {
    // Instancia con la BD y derivados
    Conexion cox = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    // Instancia del objeto-modelo
    Proveedor pv = new Proveedor();
    
    // Método que Muestra Todos los Proveedores
    @Override
    public List show() {
        ArrayList<Proveedor> list = new ArrayList<>();
        String squery = "SELECT * FROM supplier ORDER BY sno;";
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Proveedor prov = new Proveedor();
                
                prov.setId(rs.getString("sno"));
                prov.setNom(rs.getString("sname"));
                
                list.add(prov);
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: ProvedorDAO.show");
        }
        
        return list;
    }

    @Override
    public Proveedor details(String id) {
        String squery = "SELECT * FROM supplier WHERE sno="+id+";";
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            
            while(rs.next()){                
                pv.setId(rs.getString("sno"));
                pv.setNom(rs.getString("sname"));
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: ProvedorDAO.details");
        }
        
        return pv;
    }

    @Override
    public boolean add(Proveedor prov) {
        String squery = "INSERT INTO supplier (sname) VALUES ('"+prov.getNom()+"');";
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: ProvedorDAO.add");
        }
        
        return false;
    }

    @Override
    public boolean edit(Proveedor prov) {
        String squery = "UPDATE supplier SET sname='"+prov.getNom()+"' WHERE sno = "+prov.getId()+";";
        
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

    @Override
    public boolean delete(String id) {
        String squery = "DELETE FROM supplier WHERE sno = "+id+";";
        
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
