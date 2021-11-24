/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Config.Conexion;
import Interfaces.CRUD_Compra;
import Model.Compra;
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
public class CompraDAO implements CRUD_Compra {
    // Instancia con la BD y derivados
    Conexion cox = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    // Instancia del objeto-modelo
    Compra com = new Compra();
    
    // Método que Muestra Todos los Proveedores

    @Override
    public List show() {
    ArrayList<Compra> list = new ArrayList<>();
        String squery = "SELECT * FROM compra ORDER BY sno folio;";
        
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Compra com = new Compra();
             
                com.setFolio(rs.getInt("Folio"));
                com.setFechaCompra(rs.getDate("FechaCompra"));
                com.setCantidad(rs.getInt("Cantidad"));
                com.setIva(rs.getBoolean("Iva"));
                com.setMontoTotal(rs.getInt("MontoTotal"));
                com.setEstado(rs.getString("Estado"));
                com.setRfcProveedor(rs.getString("RfcProveedor"));
                com.setProductoid(rs.getInt("Productoid"));
                
                list.add(com);
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: CompraDAO.show");
        }
        
        return list;
    }

    @Override
    public Compra details(int folio) {
          String squery = "SELECT * FROM compra WHERE sno="+folio+";";
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            
            while(rs.next()){                
                
                com.setFolio(rs.getInt("Folio"));
                com.setFechaCompra(rs.getDate("FechaCompra"));
                com.setCantidad(rs.getInt("Cantidad"));
                com.setIva(rs.getBoolean("Iva"));
                com.setMontoTotal(rs.getInt("MontoTotal"));
                com.setEstado(rs.getString("Estado"));
                com.setRfcProveedor(rs.getString("RfcProveedor"));
                com.setProductoid(rs.getInt("Productoid"));
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: CompraDAO.details");
        }
        
        return com;
    }


    @Override
    public boolean add(Compra com) {
       String squery = "INSERT INTO compra (sname) VALUES ('"+com.getFolio()+"');";
       
       
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: CompraDAO.add");
        }
        
        return false;
    }


    @Override
    public boolean edit(Compra com) {
          String squery = "UPDATE compra SET sfolio='"+com.getFolio()+"' WHERE sno = "+com.getFolio()+";";
        
        System.out.println(squery);
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: CompraDAO.edit");
        }
        
        return false;
    }

    @Override
    public boolean delete(int folio) {
        String squery = "DELETE FROM compra WHERE sno = "+com.getFolio()+";";
        
        System.out.println(squery);
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: CompraDAO.delete");
        }
        
        return false;
    }
}
