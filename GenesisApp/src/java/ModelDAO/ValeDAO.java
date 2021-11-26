/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Config.Conexion;
import Interfaces.CRUD_Vale;
import Model.Vale;
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
public class ValeDAO implements CRUD_Vale{
    // Instancia con la BD y derivados
    Conexion cox = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    // Instancia del objeto-modelo
    Vale va = new Vale();

    // Método que Muestra Todos los Vales
    @Override
    public List show() {
      ArrayList<Vale> list = new ArrayList<>();
        String squery = "SELECT * FROM vale ORDER BY folio;";
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Vale val = new Vale();
                
                val.setFolio(rs.getInt("folio"));
                val.setMonto(rs.getFloat("monto"));
                val.setFechaVale(rs.getDate("fechaVale"));
                val.setConcepto(rs.getNString("concepto"));
                val.setRfcVendedor(rs.getNString("rfcVendedor"));
               
                
                list.add(val);
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: ValeDAO.show");
        }
        
        return list;
    }

    //Método que muestra un Vale
    @Override
    public Vale details(int folio) {
    
        String squery = "SELECT * FROM vale WHERE folio="+folio+";";
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            
            while(rs.next()){                
                va.setFolio(rs.getInt("folio"));
                va.setMonto(rs.getFloat("monto"));
                va.setFechaVale(rs.getDate("fechaVale"));
                va.setConcepto(rs.getNString("concepto"));
                va.setRfcVendedor(rs.getNString("rfcVendedor"));
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: ValeDAO.details");
        }
        
        return va;
    }

    //Método que inserta un Vale
    @Override
    public boolean add(Vale val) {
    String squery = "INSERT INTO vale (folio, monto, fechavale, concepto, rfcvendedor)" 
                + "VALUES ("+va.getFolio()+", "+va.getMonto()+", '"+va.getFechaVale()+"',"+va.getConcepto()+", '"+va.getRfcVendedor()+"');";
              
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: ValeDAO.add");
        }
        
        return false; 
    }

    //Método que actualiza un Vale
    @Override
    public boolean edit(Vale val) {
    
        String squery = "UPDATE vale SET monto="+va.getMonto()+", "
                + "fechavale='"+va.getFechaVale()+"', concepto='"+va.getConcepto()+"', rfcvendedor='"+va.getRfcVendedor()+"'WHERE folio="+va.getFolio()+";";
	
        System.out.println(squery);
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: ValeDAO.edit");
        }
        
        return false;
    }

    //Método que elimina un Vale
    @Override
    public boolean delete(int folio) {
    
        String squery = "DELETE FROM vale WHERE folio = "+folio+";";
        
        System.out.println(squery);
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: ValeDAO.delete");
        }
        
        return false;
    }
    
}
