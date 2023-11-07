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
public class ventas extends ventas_detalle{
    private int IdVenta;
    private int nofactura;
    private String serie;
    private String fechafactura;
    private int idcliente;
    private int idempleado;
    private String fechaingreso;
    
    public Conexion cn;

    public ventas(){}

    public ventas(int IdVenta, int nofactura, String serie, String fechafactura, int idcliente, int idempleado, String fechaingreso) {
        this.IdVenta = IdVenta;
        this.nofactura = nofactura;
        this.serie = serie;
        this.fechafactura = fechafactura;
        this.idcliente = idcliente;
        this.idempleado = idempleado;
        this.fechaingreso = fechaingreso;
    }

    public int getIdVenta() {
        return IdVenta;
    }

    public void setIdVenta(int IdVenta) {
        this.IdVenta = IdVenta;
    }

    public int getNofactura() {
        return nofactura;
    }

    public void setNofactura(int nofactura) {
        this.nofactura = nofactura;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getFechafactura() {
        return fechafactura;
    }

    public void setFechafactura(String fechafactura) {
        this.fechafactura = fechafactura;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public String getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(String fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

   
    @Override
    public DefaultTableModel leer(){
    DefaultTableModel  tabla = new DefaultTableModel();
    try{
      cn = new Conexion();
      cn.abrir_conexion();
        String query;
        query = "SELECT ventas.idVenta, ventas.nofactura, ventas.serie, ventas.fechafactura, ventas.idcliente, ventas.idempleado, ventas.fechaingreso FROM proyecto_db.ventas;";

        ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
        String encabezado[] = {"idVenta","nofactura","serie","fechafactura","idcliente","idempleado","fechaingreso"};
      tabla.setColumnIdentifiers(encabezado);
      String datos[] = new String[8];
      while (consulta.next()){
          datos[0] = consulta.getString("idVenta");
          datos[1] = consulta.getString("nofactura");
          datos[2] = consulta.getString("serie");
          datos[3] = consulta.getString("fechafactura");
          datos[4] = consulta.getString("idcliente");
          datos[5] = consulta.getString("idempleado");
          datos[6] = consulta.getString("fechaingreso");
          
          
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
         String query="INSERT INTO proyecto_db.ventas (idVenta,nofactura,serie,fechafactura,idcliente,idempleado,fechaingreso)VALUES(?,?,?,?,?,?,?);";   
         cn.abrir_conexion();
         parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
          parametro.setInt(1, getIdVenta());
          parametro.setInt(2, getNofactura());
          parametro.setString(3, getSerie());
          parametro.setString(4, getFechafactura());
          parametro.setInt(5,getIdcliente());
          parametro.setInt(6,getIdempleado());
          parametro.setString(7, getFechaingreso());
          
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
         String query="UPDATE proyecto_db.ventas SET idVenta = ?,nofactura = ?,serie = ?,fechafactura = ?,idcliente = ?,idempleado = ?,fechaingreso = ? WHERE idVenta = ?;" ;   
         cn.abrir_conexion();
         parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);

          parametro.setInt(1, getIdVenta());
          parametro.setInt(2, getNofactura());
          parametro.setString(3, getSerie());
          parametro.setString(4, getFechafactura());
          parametro.setInt(5,getIdcliente());
          parametro.setInt(6,getIdempleado());
          parametro.setString(7, getFechaingreso());
          parametro.setInt(8, getIdVenta());
          
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
         String query="delete from ventas where idVenta = ?;";   
         cn.abrir_conexion();
         parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
          parametro.setInt(1,getIdVenta());
          retorno = parametro.executeUpdate();
         cn.cerrar_conexion();
     }catch(SQLException ex){
        System.out.println(ex.getMessage());
        retorno = 0;
    }
 return retorno;   

 }   

    
    
    
    
}
