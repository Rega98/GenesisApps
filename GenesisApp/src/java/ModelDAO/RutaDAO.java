/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Config.Conexion;
import Interfaces.CRUD_Ruta;
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
public class RutaDAO implements CRUD_Ruta {
     // Instancia con la BD y derivados
    Conexion cox = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    // Instancia del objeto-modelo
    Ruta rut = new Ruta();
    
    // Método que Muestra Todos los Proveedores
    

    @Override
    public List show() {
          ArrayList<Ruta> list = new ArrayList<>();
        String squery = "SELECT * FROM ruta ORDER BY idruta = idruta;";
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Ruta rut = new Ruta();
 
                rut.setIdRuta(rs.getInt("idRuta"));
                rut.setDescripcionRuta(rs.getString("descripcionRuta"));
                rut.setRutas(rs.getInt("rutas"));
                //rut.setContratofolio(rs.getInt("contratoFolio"));
                
                list.add(rut);
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: RutaDAO.show");
        }
        
        return list;
    }

    @Override
    public Ruta details(int idRuta) {
            String squery = "SELECT * FROM ruta WHERE idRuta="+idRuta+";";
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            
            while(rs.next()){                
                rut.setIdRuta(rs.getInt("idruta"));
                rut.setDescripcionRuta(rs.getString("descripcionruta"));
                rut.setRutas(rs.getInt("rutas"));
                //rut.setContratofolio(rs.getInt("contratoFolio"));
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: RutaDAO.details");
        }
        
        return rut;
    }
 
    @Override
    public boolean add(Ruta rut) {
           String squery = "INSERT INTO ruta (descripcionruta, rutas)" 
                + "VALUES ('"+rut.getDescripcionRuta()+"',"+rut.getRutas()+");";
              
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: RutaDAO.add");
        }
        
        return false;
    }

    @Override
    public boolean edit(Ruta rut) {
             String squery = "UPDATE ruta SET descripcionruta='"+rut.getDescripcionRuta()+"', "
                + "rutas="+rut.getRutas()+" WHERE idruta="+rut.getIdRuta()+";";
	
        
        System.out.println(squery);
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: RutaDAO.edit");
        }
        
        return false;
    }

    @Override
    public boolean delete(int idRuta) {
        String squery = "DELETE FROM ruta WHERE idRuta = "+idRuta+";";
        
        System.out.println(squery);
        
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: RutaDAO.delete");
        }
        
        return false;
    }
}