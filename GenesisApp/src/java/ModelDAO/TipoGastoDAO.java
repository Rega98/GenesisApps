/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Config.Conexion;
import Interfaces.CRUD_TipoGasto;
import Model.TipoGasto;
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
public class TipoGastoDAO implements CRUD_TipoGasto {
    // Instancia con la BD y derivados
    Conexion cox = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    // Instancia del objeto-modelo
    TipoGasto tipogast = new TipoGasto();

    // Método que Muestra Todos los TiposGasto
    @Override
    public List show() {
        ArrayList<TipoGasto> list = new ArrayList<>();
        String squery = "SELECT * FROM tipoGasto ORDER BY id;";
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            
            while(rs.next()){
                TipoGasto gast = new TipoGasto();
                
                gast.setId(rs.getInt("id"));
                gast.setDescripcion(rs.getString("descripcion"));
                gast.setTipo(rs.getString("tipo"));

                
                list.add(gast);
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: TipoGastoDAO.show");
        }
        
        return list;
    }

    // Método que muestra un TipoGasto
    @Override
    public TipoGasto details(int id) {
    
        String squery = "SELECT * FROM tipoGasto WHERE id="+id+";";
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            
            while(rs.next()){                
                tipogast.setId(rs.getInt("id"));
                tipogast.setDescripcion(rs.getString("descripcion"));
                tipogast.setTipo(rs.getString("tipo"));
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: TipoGastoDAO.details");
        }
        
        return tipogast;
    }

    //Método que inserta un TipoGasto
    @Override
    public boolean add(TipoGasto tipogast) {
    
        String squery = "INSERT INTO tipoGasto (id,descripcion,tipo)" 
                + "VALUES ("+tipogast.getId()+", '"+tipogast.getDescripcion()+"', '"+tipogast.getTipo()+"');";
              
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: TipoGastoDAO.add");
        }
        
        return false;
    }

    //Método que edita un TipoGasto
    @Override
    public boolean edit(TipoGasto tipogast) {
    
        String squery = "UPDATE tipoGasto SET descripcion='"+tipogast.getDescripcion()+"', "
                + "tipo='"+tipogast.getTipo()+"'WHERE id="+tipogast.getId()+";";
	
        System.out.println(squery);
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: TipoGastoDAO.edit");
        }
        
        return false;
    }

    // Método que elimina un TipoGasto
    @Override
    public boolean delete(int id) {
    String squery = "DELETE * FROM tipoGasto WHERE id = "+id+";";
        
        System.out.println(squery);
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: TipoGastoDAO.delete");
        }
        
        return false;    
    }
    
}
