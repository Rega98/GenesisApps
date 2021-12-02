/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Config.Conexion;
import Interfaces.CRUD_Empleado;
import Model.Empleado;
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
public class EmpleadoDAO implements CRUD_Empleado {
    // Instancia con la BD y derivados
    Conexion cox = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    // Instancia del objeto-modelo
    Empleado emp = new Empleado();
    // Método que Muestra Todos los Proveedores
    @Override
    public List show() {
        ArrayList<Empleado> list = new ArrayList<>();
        String squery = "SELECT * FROM empleado ORDER BY rfc;";
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            while(rs.next()){
                Empleado emp = new Empleado();
                emp.setRfc(rs.getString("rfc"));
                emp.setNombre(rs.getString("nombre"));
                emp.setApPaterno(rs.getString("appaterno"));
                emp.setApMaterno(rs.getString("apmaterno"));
                emp.setUser(rs.getString("user"));
                emp.setPass(rs.getString("pass"));
                emp.setTipo(rs.getString("tipo"));
                list.add(emp);
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: EmpleadoDAO.show");
        }
        return list;
    }

    public List show2() {
        ArrayList<Empleado> list = new ArrayList<>();
        String squery = "SELECT * FROM empleado where tipo = 'Gerente' ORDER BY rfc;";
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            while(rs.next()){
                Empleado emp = new Empleado();
                emp.setRfc(rs.getString("rfc"));
                emp.setNombre(rs.getString("nombre"));
                emp.setApPaterno(rs.getString("appaterno"));
                emp.setApMaterno(rs.getString("apmaterno"));
                emp.setUser(rs.getString("user"));
                emp.setPass(rs.getString("pass"));
                emp.setTipo(rs.getString("tipo"));
                list.add(emp);
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: EmpleadoDAO.show");
        }
        return list;
    }
    
    public List show3() {
        ArrayList<Empleado> list = new ArrayList<>();
        String squery = "SELECT * FROM empleado where tipo <> 'Gerente' ORDER BY rfc;";
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            while(rs.next()){
                Empleado emp = new Empleado();
                emp.setRfc(rs.getString("rfc"));
                emp.setNombre(rs.getString("nombre"));
                emp.setApPaterno(rs.getString("appaterno"));
                emp.setApMaterno(rs.getString("apmaterno"));
                emp.setUser(rs.getString("user"));
                emp.setPass(rs.getString("pass"));
                emp.setTipo(rs.getString("tipo"));
                list.add(emp);
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: EmpleadoDAO.show");
        }
        return list;
    }
    
    @Override
    public Empleado details(String rfc) {
        String squery = "SELECT * FROM empleado WHERE rfc='"+rfc+"';";
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            rs = ps.executeQuery();
            while(rs.next()){                
                emp.setRfc(rs.getString("rfc"));
                emp.setNombre(rs.getString("nombre"));
                emp.setApPaterno(rs.getString("appaterno"));
                emp.setApMaterno(rs.getString("apmaterno"));
                emp.setUser(rs.getString("user"));
                emp.setPass(rs.getString("pass"));
                emp.setTipo(rs.getString("tipo"));
            }
        }catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: EmpleadoDAO.details");
        }
        return emp;
    }

    @Override
    public boolean add(Empleado emp) {
        boolean result = false;
        String squery = "INSERT INTO empleado (rfc, nombre, appaterno, apmaterno, \"user\", pass, tipo) VALUES ('"
                   +emp.getRfc()+"', '"+emp.getNombre()+"', '"+emp.getApPaterno()+"', '"+emp.getApMaterno()+"', '"+emp.getUser()
                   +"', '"+emp.getPass()+"', '"+emp.getTipo()+"');";
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: EmpleadoDAO.add");
        }
        return result;
    }

    @Override
    public boolean edit(Empleado emp) {
        boolean result = false;
        String squery = "UPDATE empleado SET rfc='"+emp.getRfc()+"', nombre='"+emp.getNombre()+"', appaterno='"+emp.getApPaterno()
               +"', apmaterno='"+emp.getApMaterno()+"', \"user\"='"+emp.getUser()+"', pass='"+emp.getPass()+"', tipo='"+emp.getTipo()
               +"' WHERE rfc = '"+emp.getRfc()+"';";
        System.out.println(squery);
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: EmpleadoDAO.edit");
        }
        return result;
    }

    @Override
    public boolean delete(String rfc) {
        boolean result = false;
        String squery = "DELETE FROM empleado WHERE rfc = '"+rfc+"';";
        System.out.println(squery);
        try{
            con = cox.getConnection();
            ps = con.prepareStatement(squery);
            ps.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println("Error:\n"+e+"\n-> Desde: EmpleadoDAO.delete");
        }
        return result;
    }
}