/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Config.Conexion;
import Interfaces.CRUD_Gasto;
import Model.Gasto;
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
public class GastoDAO implements CRUD_Gasto {
    // Instancia con la BD y derivados
    Conexion cox = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    // Instancia del objeto-modelo
    Gasto gast = new Gasto();

    // Método que Muestra Todos los Gastos
    @Override
    public List show() {
        ArrayList<Gasto> list = new ArrayList<>();
        String squery = "SELECT * FROM gasto ORDER BY folio;";
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Gasto gas = new Gasto();
                
                gas.setFolio(rs.getInt("folio"));
                gas.setFecha(rs.getDate("fecha"));
                gas.setDefinicion(rs.getString("definicion"));
                gas.setImporteCiva(rs.getFloat("importeCiva"));
                gas.setImporteSinva(rs.getFloat("importeSinva"));
                gas.setIdTipoGasto(rs.getInt("idTipoGasto"));
                gas.setRfGerente(rs.getString("rfGerente"));

                
                list.add(gas);
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: GastoDAO.show");
        }
        
        return list;
    }

    // Método que muestra un Gasto
    @Override
    public Gasto details(int folio) {
    String squery = "SELECT * FROM gasto WHERE folio="+folio+";";
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            
            while(rs.next()){                
                gast.setFolio(rs.getInt("folio"));
                gast.setFecha(rs.getDate("fecha"));
                gast.setDefinicion(rs.getString("definicion"));
                gast.setImporteCiva(rs.getFloat("importeCiva"));
                gast.setImporteSinva(rs.getFloat("importeSinva"));
                gast.setIdTipoGasto(rs.getInt("idTipoGasto"));
                gast.setRfGerente(rs.getString("rfGerente"));
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: GastoDAO.details");
        }
        
        return gast;   
    }

    // Método que inserta un Gasto
    @Override
    public boolean add(Gasto gast) {
    String squery = "INSERT INTO gasto (folio, fecha, definicion, importeciva, importesinva, idtipogasto, rfgerente)" 
                + "VALUES ("+gast.getFolio()+", '"+gast.getFecha()+"', '"+gast.getDefinicion()+","+gast.getImporteCiva()+","+gast.getImporteSinva()+","+gast.getIdTipoGasto()+",'"+gast.getRfGerente()+"');";
              
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: GastoDAO.add");
        }
        
        return false;   
    }

    // Método que edita un Gasto
    @Override
    public boolean edit(Gasto gast) {
    String squery = "UPDATE gasto SET fecha='"+gast.getFecha()+"', "
            + "definicion='"+gast.getDefinicion()+"', importeciva="+gast.getImporteCiva()+", "
            + "importesinva="+gast.getImporteSinva()+", idtipogasto="+gast.getIdTipoGasto()+", "
            + "rfgerente='"+gast.getRfGerente()+"' WHERE folio="+gast.getFolio()+";";
	
        System.out.println(squery);
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: GastoDAO.edit");
        }
        
        return false;    
    }

    // Método que elimina un Gasto
    @Override
    public boolean delete(int folio) {
    String squery = "DELETE FROM gasto WHERE folio = "+folio+";";
        
        System.out.println(squery);
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: GastoDAO.delete");
        }
        
        return false;    
    }
    
}
