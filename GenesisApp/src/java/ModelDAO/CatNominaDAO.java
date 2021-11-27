/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Config.Conexion;
import Interfaces.CRUD_CatNomina;
import Model.CatNomina;
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
public class CatNominaDAO implements CRUD_CatNomina{
    // Instancia con la BD y derivados
    Conexion cox = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    // Instancia del objeto-modelo
    CatNomina catNomi = new CatNomina();

    // Método que Muestra Todos los CatNomina
    @Override
    public List show() {
        ArrayList<CatNomina> list = new ArrayList<>();
        String squery = "SELECT * FROM catNomina ORDER BY folio;";
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            
            while(rs.next()){
                CatNomina cn = new CatNomina();
                
                cn.setFolio(rs.getInt("folio"));
                cn.setFecha(rs.getDate("fecha"));
                cn.setMesAnio(rs.getDate("mesAnio"));
                cn.setPeriodo(rs.getNString("periodo"));
                cn.setMonto(rs.getFloat("monto"));
                cn.setRfcEmpleado(rs.getNString("rfcEmpleado"));
               
                
                list.add(cn);
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: CatNominaDAO.show");
        }
        
        return list;
    }

    //Método que muestra una CatNomina
    @Override
    public CatNomina details(int folio) {
    
        String squery = "SELECT * FROM catnomina WHERE folio="+folio+";";
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            
            while(rs.next()){                
                catNomi.setFolio(rs.getInt("folio"));
                catNomi.setFecha(rs.getDate("fecha"));
                catNomi.setMesAnio(rs.getDate("mesAnio"));
                catNomi.setPeriodo(rs.getNString("periodo"));
                catNomi.setMonto(rs.getFloat("monto"));
                catNomi.setRfcEmpleado(rs.getNString("rfcEmpleado"));
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: CatNominaDAO.details");
        }
        
        return catNomi;
    }
    
    //Método que inserta una CatNomina
    @Override
    public boolean add(CatNomina cnomi) {
    String squery = "INSERT INTO catnomina (fecha, mesanio, periodo, monto, rfcempleado)" 
                + "VALUES ('"+catNomi.getFecha()+"', '"+catNomi.getMesAnio()+"','"+catNomi.getPeriodo()+"', "+catNomi.getMonto()+",'"+catNomi.getRfcEmpleado()+"');";
              
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: CatNominaDAO.add");
        }
        
        return false;   
    }

    //Método que actualiza una CatNomina
    @Override
    public boolean edit(CatNomina cnomi) {
    
        String squery = "UPDATE catnomina SET folio="+catNomi.getFolio()+", fecha='"+catNomi.getFecha()+"', "
                + "mesanio='"+catNomi.getMesAnio()+"', periodo='"+catNomi.getPeriodo()+"',monto="+catNomi.getMonto()+", rfcempleado='"+catNomi.getRfcEmpleado()+"'WHERE folio="+catNomi.getFolio()+";";
	
        System.out.println(squery);
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: CatNominaDAO.edit");
        }
        
        return false;
    }

    //Método que elimina una CatNomina
    @Override
    public boolean delete(int folio) {
    
        String squery = "DELETE FROM catnomina WHERE folio = "+folio+";";
        
        System.out.println(squery);
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: CatNominaDAO.delete");
        }
        
        return false;
    }
    
}