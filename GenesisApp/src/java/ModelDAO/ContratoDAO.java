/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Config.Conexion;
import Interfaces.CRUD_Contrato;
import Model.Contrato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Windows 10 Pro
 */
public class ContratoDAO implements CRUD_Contrato {
        // Instancia con la BD y derivados
    Conexion cox = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    // Instancia del objeto-modelo
    Contrato cont = new Contrato();
    
    // Método que Muestra Todos los Proveedores

    @Override
    public List show() {
       ArrayList<Contrato> list = new ArrayList<>();
        String squery = "SELECT * FROM Contrato ORDER BY folio;";
     
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Contrato cont = new Contrato();
 
                cont.setFolio(rs.getInt("folio"));
                cont.setEnganche(rs.getFloat("Enganche"));
                cont.setPlanPago(rs.getString("PlanPago"));
                cont.setDiaCobro(rs.getString("DiaCobro"));
                cont.setEstado(rs.getString("Estado"));
                cont.setFechaContrato(rs.getDate("FechaContrato"));
                cont.setSubtotal(rs.getFloat("Subtotal"));
                cont.setIva(rs.getFloat("Iva"));
                cont.setTotal(rs.getFloat("Total"));
                cont.setRfcVendedor(rs.getString("RfcVendedor"));
                cont.setRfcCliente(rs.getString("RfcCliente"));
                cont.setIdProducto(rs.getInt("IdProducto"));
                cont.setIdRuta(rs.getInt("IdRuta"));
                
               
                
                list.add(cont);
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: ContratoDAO.show");
        }
        
        return list;
    }
    @Override
    public Contrato details(int folio) {
          String squery = "SELECT * FROM contrato WHERE folio="+folio+";";
          
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            
            while(rs.next()){                
                cont.setFolio(rs.getInt("folio"));
                cont.setEnganche(rs.getFloat("Enganche"));
                cont.setPlanPago(rs.getString("PlanPago"));
                cont.setDiaCobro(rs.getString("DiaCobro"));
                cont.setEstado(rs.getString("Estado"));
                cont.setFechaContrato(rs.getDate("FechaContrato"));
                cont.setSubtotal(rs.getFloat("Subtotal"));
                cont.setIva(rs.getFloat("Iva"));
                cont.setTotal(rs.getFloat("Total"));
                cont.setRfcVendedor(rs.getString("RfcVendedor"));
                cont.setRfcCliente(rs.getString("RfcCliente"));
                cont.setIdProducto(rs.getInt("IdProducto"));
                cont.setIdRuta(rs.getInt("IdRuta"));
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: ContratoDAO.details");
        }
        
        return cont;
    }
 
    @Override
    public boolean add(Contrato cont) {
        String squery = "INSERT INTO contrato (enganche, planPago, diaCobro, estado, fechaContrato,subtotal, iva, total, rfcVendedor,rfcCliente,idProducto,idRuta)" 
                + "VALUES ("+cont.getEnganche()+", '"+cont.getPlanPago()+"','"+cont.getDiaCobro()+"', '"+cont.getEstado()+"','"+cont.getFechaContrato()+"',"+cont.getSubtotal()+","+cont.getIva()+","+cont.getTotal()+",'"+cont.getRfcVendedor()+"','"+cont.getRfcCliente()+"',"+cont.getIdProducto()+", null);";
        
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: ContratoDAO.add");
        }
        
        return false;
    }

    @Override
    public boolean edit(Contrato cont) {
        String squery = "UPDATE contrato SET estado='"+cont.getEstado()+"' WHERE folio="+cont.getFolio()+";";
        System.out.println(squery);
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: ContratoDAO.edit");
        }
        
        return false;
    }

    @Override
    public boolean delete(int folio) {
        String squery = "DELETE FROM contrato WHERE folio = "+folio+";";
        
        
        System.out.println(squery);
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: ContratoDAO.delete");
        }
        
        return false;
    }
    
    public List showByQuincena(String rfc, int month, int year, String sign) {
        ArrayList<Contrato> list = new ArrayList<>();
        String squery = "SELECT * FROM contrato WHERE rfcvendedor = '"+rfc+"' AND EXTRACT(MONTH FROM fechacontrato) = "+month+" AND " +
                        "EXTRACT(YEAR FROM fechacontrato) = "+year+" AND EXTRACT(DAY FROM fechacontrato) "+sign+" 15 AND estado <> 'CANCELADO';"; 
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            while(rs.next()){
                Contrato cont = new Contrato();
                cont.setFolio(rs.getInt("folio"));
                cont.setEnganche(rs.getFloat("enganche"));
                cont.setPlanPago(rs.getString("planPago"));
                cont.setDiaCobro(rs.getString("diaCobro"));
                cont.setEstado(rs.getString("estado"));
                cont.setFechaContrato(rs.getDate("fechacontrato"));
                cont.setSubtotal(rs.getFloat("subtotal"));
                cont.setIva(rs.getFloat("iva"));
                cont.setTotal(rs.getFloat("total"));
                cont.setRfcVendedor(rs.getString("rfcVendedor"));
                cont.setRfcCliente(rs.getString("rfcCliente"));
                cont.setIdProducto(rs.getInt("idProducto"));
                cont.setIdRuta(rs.getInt("idRuta"));
                list.add(cont);
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: ContratoDAO.showByQuincena");
        }
        return list;
    }
    
    public Float getGananciaByQuincena(String rfc, int month, int year, String sign) {
        Float result = -1.0f;
        String squery = "SELECT SUM(total)*.10 AS montototal FROM contrato WHERE rfcvendedor = '"+rfc+"' AND EXTRACT(MONTH FROM fechacontrato) = "+month+" AND " +
                        "EXTRACT(YEAR FROM fechacontrato) = "+year+" AND EXTRACT(DAY FROM fechacontrato) "+sign+" 15 AND estado <> 'CANCELADO';"; 
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            while(rs.next()){
                result = rs.getFloat("montototal");
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: ContratoDAO.getGananciaByQuincena");
        }
        return result;
    }

    @Override
    public int BuscarXCampos() {
        int folio = 0;
        String squery = "SELECT MAX(folio) AS folio FROM contrato;";
        try{            
            Statement orden = con.createStatement();
            ResultSet res = orden.executeQuery(squery);
            res.next();
            folio = res.getInt("folio");
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: ContratoDAO.find");
        }
        
        return folio;
    }
}