/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Config.Conexion;
import Interfaces.CRUD_Observacion;
import Model.Observacion;
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
public class ObservacionDAO implements CRUD_Observacion {
        // Instancia con la BD y derivados
    Conexion cox = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    // Instancia del objeto-modelo
    Observacion obs = new Observacion();
    
    // Método que Muestra Todos los Proveedores

    @Override
    public List show() {
          ArrayList<Observacion> list = new ArrayList<>();
        String squery = "SELECT * FROM observacion ORDER BY sno =id;";
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Observacion obs = new Observacion();
                
                obs.setId(rs.getInt("id"));
                obs.setFecha(rs.getDate("fecha"));
                obs.setObservacion(rs.getString("observacion"));
                obs.setContratofolio(rs.getInt("contratofolio"));
            
                
                list.add(obs);
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: ObservacionDAO.show");
        }
        
        return list;
    }
    @Override
    public Observacion details(int id) {
               String squery = "SELECT * FROM observacion WHERE sno="+id+";";
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            
            while(rs.next()){                
                 obs.setId(rs.getInt("id"));
                obs.setFecha(rs.getDate("fecha"));
                obs.setObservacion(rs.getString("observacion"));
                obs.setContratofolio(rs.getInt("contratofolio"));
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: ObservacionDAO.details");
        }
        
        return obs;
    }

    @Override
    public boolean add(Observacion obs) {
           String squery = "INSERT INTO observacion (sname) VALUES ('"+obs.getId()+"');";
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: ObservacionDAO.add");
        }
        
        return false;
    }

    @Override
    public boolean edit(Observacion obs) {
           String squery = "UPDATE observacion SET sname='"+obs.getId()+"' WHERE sno = "+obs.getId()+";";
        
        System.out.println(squery);
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: ObservacionDAO.edit");
        }
        
        return false;
    }

    @Override
    public boolean delete(int id) {
        String squery = "DELETE FROM observacion WHERE sno = "+id+";";
        
        System.out.println(squery);
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: ObservacionDAO.delete");
        }
        
        return false;
    }
}

