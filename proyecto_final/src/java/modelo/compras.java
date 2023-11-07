/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author oliver
 */
public class compras extends compras_detalle{
    
    private int idcompra;
    private int no_orden_compra;
    private int idproveedor;
    private String fecha_orden;
    private String fechaingreso;
    
    public Conexion cn;
    
    public compras(){}

    public compras(int idcompra, int no_orden_compra, int idproveedor, String fecha_orden, String fechaingreso) {
        this.idcompra = idcompra;
        this.no_orden_compra = no_orden_compra;
        this.idproveedor = idproveedor;
        this.fecha_orden = fecha_orden;
        this.fechaingreso = fechaingreso;
    }

    @Override
    public int getIdcompra() {
        return idcompra;
    }

    @Override
    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public int getNo_orden_compra() {
        return no_orden_compra;
    }

    public void setNo_orden_compra(int no_orden_compra) {
        this.no_orden_compra = no_orden_compra;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getFecha_orden() {
        return fecha_orden;
    }

    public void setFecha_orden(String fecha_orden) {
        this.fecha_orden = fecha_orden;
    }

    public String getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(String fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public Conexion getCn() {
        return cn;
    }

    public void setCn(Conexion cn) {
        this.cn = cn;
    }
    
    
    public DefaultTableModel leer(){
    DefaultTableModel  tabla = new DefaultTableModel();
    try{
      cn = new Conexion();
      cn.abrir_conexion();
        String query;
        query = "SELECT compras.idcompra,compras.no_orden_compra,compras.idproveedor,compras.fecha_orden,compras.fechaingreso FROM proyecto_db.compras;";

        ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
        String encabezado[] = {"idcompra","no_orden_compra","idproveedor","fecha_orden","fechaingreso"};
      tabla.setColumnIdentifiers(encabezado);
      String datos[] = new String[8];
      while (consulta.next()){
          datos[0] = consulta.getString("idcompra");
          datos[1] = consulta.getString("no_orden_compra");
          datos[2] = consulta.getString("idproveedor");
          datos[3] = consulta.getString("fecha_orden");
          datos[4] = consulta.getString("fechaingreso");
          
          
          tabla.addRow(datos);
          
      }
      
      
              
      cn.cerrar_conexion();
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
        
    }
    
    
    return tabla;
}
    
    
       
   //se creo la funcion agregar
    public int agregar(){
        int retorno  =0;
     try {
         PreparedStatement parametro;
         cn = new Conexion();
         String query="INSERT INTO proyecto_db.compras(idcompra,no_orden_compra,idproveedor,fecha_orden,fechaingreso)VALUES(?,?,?,?,?);";   
         cn.abrir_conexion();
         parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
          parametro.setInt(1, getIdcompra());
          parametro.setInt(2, getNo_orden_compra());
          parametro.setInt(3, getIdproveedor());
          parametro.setString(4, getFecha_orden());
          parametro.setString(5,getFechaingreso());
          
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
         String query="UPDATE proyecto_db.compras SET idcompra = ?,no_orden_compra = ?,idproveedor = ?,fecha_orden = ?,fechaingreso = ? WHERE idcompra = ?;" ;   
         cn.abrir_conexion();
         parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);

          parametro.setInt(1, getIdcompra());
          parametro.setInt(2, getNo_orden_compra());
          parametro.setInt(3, getIdproveedor());
          parametro.setString(4, getFecha_orden());
          parametro.setString(5,getFechaingreso());
          parametro.setInt(6, getIdcompra());
          
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
         String query="delete from compras where idcompra = ?;";   
         cn.abrir_conexion();
         parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
          parametro.setInt(1,getIdcompra());
          retorno = parametro.executeUpdate();
         cn.cerrar_conexion();
     }catch(SQLException ex){
        System.out.println(ex.getMessage());
        retorno = 0;
    }
 return retorno;   

 }   

    
    
}
