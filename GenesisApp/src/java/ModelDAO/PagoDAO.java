/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Config.Conexion;
import Interfaces.CRUD_Pago;
import Model.Pago;
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
public class PagoDAO implements CRUD_Pago {
    // Instancia con la BD y derivados
    Conexion cox = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    // Instancia del objeto-modelo
    Pago pag = new Pago();

    // Método que Muestra Todos los Pagos
    @Override
    public List show() {
        ArrayList<Pago> list = new ArrayList<>();
        String squery = "SELECT * FROM pago ORDER BY folio;";
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Pago pa = new Pago();
                
                pa.setFolio(rs.getInt("folio"));
                pa.setFecha(rs.getDate("fecha"));
                pa.setMonto(rs.getFloat("monto"));
                pa.setContratofolio(rs.getInt("contratofolio"));
                pa.setRfcCobrador(rs.getString("rfcCobrador"));
               
                
                list.add(pa);
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: PagoDAO.show");
        }
        
        return list;
    }

    //Método que muestra un Pago
    @Override
    public Pago details(int folio) {
    
        String squery = "SELECT * FROM pago WHERE folio="+folio+";";
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            
            while(rs.next()){                
                pag.setFolio(rs.getInt("folio"));
                pag.setFecha(rs.getDate("fecha"));
                pag.setMonto(rs.getFloat("monto"));
                pag.setContratofolio(rs.getInt("contratofolio"));
                pag.setRfcCobrador(rs.getString("rfcCobrador"));
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: PagoDAO.details");
        }
        
        return pag;
    }


    //Método que inserta un Pago
    @Override
    public boolean add(Pago pag) {
    
        String squery = "INSERT INTO pago (fecha, monto, contratofolio, rfccobrador)" 
                + "VALUES ('"+pag.getFecha()+"', "+pag.getMonto()+","+pag.getContratofolio()+", '"+pag.getRfcCobrador()+"');";
              
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: PagoDAO.add");
        }
        
        return false;
    }

    //Método que edita un Pago
    @Override
    public boolean edit(Pago pag) {
    String squery = "UPDATE pago SET folio="+pag.getFolio()+", fecha='"+pag.getFecha()+"', "
                + "monto="+pag.getMonto()+", contratofolio="+pag.getContratofolio()+", rfccobrador='"+pag.getRfcCobrador()+"'WHERE folio="+pag.getFolio()+";";
	
        System.out.println(squery);
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: PagoDAO.edit");
        }
        
        return false;  
    }

    //Método que elimina un pago
    @Override
    public boolean delete(int folio) {
    
        String squery = "DELETE FROM pago WHERE folio = "+folio+";";
          
        
        System.out.println(squery);
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: PagoDAO.delete");
        }
        
        return false;
    }
    
    public List showByQuincena(String rfc, int month, int year, String sign) {
        ArrayList<Pago> list = new ArrayList<>();
        String squery = "SELECT * FROM pago WHERE rfccobrador = '"+rfc+"' AND EXTRACT(MONTH FROM fecha) = "+month+" AND " +
                        "EXTRACT(YEAR FROM fecha) = "+year+" AND EXTRACT(DAY FROM fecha) "+sign+" 15;"; 
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            while(rs.next()){
                Pago pago = new Pago();
                pago.setFolio(rs.getInt("folio"));
                pago.setFecha(rs.getDate("fecha"));
                pago.setMonto(rs.getFloat("monto"));
                pago.setContratofolio(rs.getInt("contratofolio"));
                pago.setRfcCobrador(rs.getString("rfccobrador"));
                list.add(pago);
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: PagoDAO.showByQuincena");
        }
        return list;
    }
    
    public Float getMontoByQuincena(String rfc, String comision, int month, int year, String sign) {
        Float result = -1.0f;
        String squery = "SELECT SUM(monto)*."+comision+" AS montototal FROM pago WHERE rfccobrador = '"+rfc+"' AND EXTRACT(MONTH FROM fecha) = "+month+" AND " +
                        "EXTRACT(YEAR FROM fecha) = "+year+" AND EXTRACT(DAY FROM fecha) "+sign+" 15;"; 
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            while(rs.next()){
                result = rs.getFloat("montototal");
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: PagoDAO.getGananciaByQuincena");
        }
        return result;
    }
}