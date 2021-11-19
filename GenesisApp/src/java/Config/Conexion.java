/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Config;

import java.sql.*;

/**
 *
 * @author IsmaSL
 */
public class Conexion {
    
    Connection con;
    
    public Conexion(){
        try {
            Class.forName("org.postgresql.Driver");
            con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/proveedores","postgres","holamundo1");            
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error:"+e);
        }
    }
    
    public Connection getConnection(){
        return con;
    }
}
