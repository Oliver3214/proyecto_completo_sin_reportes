/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
/**
 *
 * @author augus
 */
public class puesto {
    private int id_puesto;
    private String puesto;
    private Conexion cn;
    public puesto(){}
    public puesto(int id_puesto, String puesto) {
        this.id_puesto = id_puesto;
        this.puesto = puesto;
    }

    public int getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
   
    
    public DefaultTableModel leer(){
    DefaultTableModel  tabla = new DefaultTableModel();
    try{
      cn = new Conexion();
      cn.abrir_conexion();
        String query;
        query = "SELECT idPuesto as id, puestos FROM puestos;";
      ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
      String encabezado[] = {"id","puestos"};
      tabla.setColumnIdentifiers(encabezado);
        String datos[] = new String[3];
      while (consulta.next()){
          datos[0] = consulta.getString("id");
          datos[1] = consulta.getString("puestos");
        
          tabla.addRow(datos);
          
      }
      cn.cerrar_conexion();
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
        
    }
    
    return tabla;
}
    

     public HashMap drop_sangre(){
         HashMap<String,String> drop = new HashMap();
         try{
             cn = new Conexion();
             //SELECT idPuestos,puestos FROM puestos;
             String query= "SELECT idPuesto as id, puestos FROM puestos";
             cn.abrir_conexion();
             ResultSet consulta =  cn.conexionBD.createStatement().executeQuery(query);
             while (consulta.next()){
                 drop.put(consulta.getString("id"), consulta.getString("puestos"));
             }
             
             cn.cerrar_conexion();
             
         
         }catch (SQLException ex){
                 System.out.println(ex.getMessage());
         }
         return drop;
    }
     
     
  
   //se creo la funcion agregar
    public int agregar(){
        int retorno  =0;
     try {
         PreparedStatement parametro;
         cn = new Conexion();
         String query="INSERT INTO proyecto_db.puestos(idPuesto,puestos)VALUES(?,?);";   
         cn.abrir_conexion();
         parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
          parametro.setInt(1, getId_puesto());
          parametro.setString(2, getPuesto());
        
          retorno = parametro.executeUpdate();
         cn.cerrar_conexion();
     }catch(SQLException ex){
        System.out.println(ex.getMessage());
        retorno = 0;
    }
 return retorno;   
}

    
    //se creo la funcion modificar 
    public int modificar(){
         int retorno  =0;
     try {
         PreparedStatement parametro;
         cn = new Conexion();
         String query="UPDATE proyecto_db.puestos SET idPuesto = ?,puestos = ? WHERE idPuesto = ?;" ;   
         cn.abrir_conexion();
         parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
         parametro.setInt(1, getId_puesto());         
         parametro.setString(2, getPuesto());
         parametro.setInt(3, getId_puesto());
          
          retorno = parametro.executeUpdate();
         cn.cerrar_conexion();
     }catch(SQLException ex){
        System.out.println(ex.getMessage());
        retorno = 0;
    }
 return retorno;   
}
    
    
    //se creo la funcion eliminar
 public int eliminar (){
     int retorno  =0;
     try {
         PreparedStatement parametro;
         cn = new Conexion();
         String query="delete from puestos where idPuesto = ?;";   
         cn.abrir_conexion();
         parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
          parametro.setInt(1,getId_puesto());
          retorno = parametro.executeUpdate();
         cn.cerrar_conexion();
     }catch(SQLException ex){
        System.out.println(ex.getMessage());
        retorno = 0;
    }
 return retorno;   

 } 
}
