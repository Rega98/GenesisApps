/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Config.Conexion;
import Interfaces.CRUD_Empleado;
import Model.Empleado;
import Model.Ruta;
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
public class EmpleadoDAO implements CRUD_Empleado {
         // Instancia con la BD y derivados
    Conexion cox = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    // Instancia del objeto-modelo
    Empleado emp = new Empleado();
    
    // Método que Muestra Todos los Proveedores
    

    @Override
    public List show() {
              ArrayList<Empleado> list = new ArrayList<>();
        String squery = "SELECT * FROM empleado ORDER BY sno = rfc;";
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Empleado emp = new Empleado();
  
                
                emp.setRfc(rs.getString("rfc"));
                emp.setNombre(rs.getString("nombre"));
                emp.setApPaterno(rs.getString("apPaterno"));
                emp.setApMaterno(rs.getString("apMaterno"));
                emp.setUser(rs.getString("user"));
                emp.setPass(rs.getString("pass"));
                emp.setTipo(rs.getString("tipo"));
             
                
                list.add(emp);
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: EmpleadoDAO.show");
        }
        
        return list;
    }

    @Override
    public Empleado details(String rfc) {
            String squery = "SELECT * FROM empleado WHERE sno="+rfc+";";
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            
            while(rs.next()){                
                emp.setRfc(rs.getString("rfc"));
                emp.setNombre(rs.getString("nombre"));
                emp.setApPaterno(rs.getString("apPaterno"));
                emp.setApMaterno(rs.getString("apMaterno"));
                emp.setUser(rs.getString("user"));
                emp.setPass(rs.getString("pass"));
                emp.setTipo(rs.getString("tipo"));
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: EmpleadoDAO.details");
        }
        
        return emp;
    }

    @Override
    public boolean add(Empleado emp) {
           String squery = "INSERT INTO empleado (sname) VALUES ('"+emp.getRfc()+"');";
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: EmpleadoDAO.add");
        }
        
        return false;
    }

    @Override
    public boolean edit(Empleado emp) {
       String squery = "UPDATE empleado SET sname='"+emp.getRfc()+"' WHERE sno = "+emp.getRfc()+";";
        
        System.out.println(squery);
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: EmpleadoDAO.edit");
        }
        
        return false;
    }

    @Override
    public boolean delete(String rfc) {
         String squery = "DELETE FROM empleado WHERE sno = "+rfc+";";
        
        System.out.println(squery);
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: EmpleadoDAO.delete");
        }
        
        return false;
    }
}
