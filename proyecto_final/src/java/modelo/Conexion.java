/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author augus
 */
public class Conexion {
    public Connection conexionBD;
    public final String bd = "proyecto_db";
    public final String urlConexion = String.format("jdbc:mysql://localhost:3306/%s",bd); 
    public final String usuario = "root";
    public final String contra = "Manager$1";
    public final String jdbc = "com.mysql.cj.jdbc.Driver"; 
    
    public void abrir_conexion(){
        try{
            Class.forName(jdbc);
            conexionBD = DriverManager.getConnection(urlConexion,usuario,contra);
           
        }catch(ClassNotFoundException | SQLException ex){
            System.out.print("Error..." + ex.getMessage());
        
        }
    
    
    }
    public void cerrar_conexion(){
        try{
            conexionBD.close();
        }catch(SQLException ex){
            System.out.print("Error..." + ex.getMessage());
        }
    }

    public ResultSet executeQuery(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   //new conexion
    Connection getConnection() {
        try{
            Class.forName(jdbc);
            conexionBD = DriverManager.getConnection(urlConexion,usuario,contra);
            
        }catch (Exception e){
            
        }
       return conexionBD;
    }
 
        
 }
