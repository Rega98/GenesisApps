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
        String squery = "SELECT * FROM supplier ORDER BY sno = folio;";
        
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
          String squery = "SELECT * FROM contrato WHERE sno="+folio+";";
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
        String squery = "INSERT INTO contrato (sname) VALUES ('"+cont.getFolio()+"');";
        
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
           String squery = "UPDATE contrato SET sname='"+cont.getFolio()+"' WHERE sno = "+cont.getFolio()+";";
        
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
        String squery = "DELETE FROM contrato WHERE sno = "+folio+";";
        
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
}
