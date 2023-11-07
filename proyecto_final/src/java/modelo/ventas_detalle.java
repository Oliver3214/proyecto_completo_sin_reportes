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
public class ventas_detalle{
    private int idVenta;
    private int Idventas_detalle;
    private int idProducto;
    private String cantidad;
    private int precio_unitario;
    
    public Conexion cn;
    
    public ventas_detalle (){}

    public ventas_detalle(int idVenta, int Idventas_detalle, int idProducto, String cantidad, int precio_unitario) {
        this.idVenta = idVenta;
        this.Idventas_detalle = Idventas_detalle;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
    }

    

    

    public int getIdventas_detalle() {
        return Idventas_detalle;
    }

    public void setIdventas_detalle(int Idventas_detalle) {
        this.Idventas_detalle = Idventas_detalle;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(int precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public Conexion getCn() {
        return cn;
    }

    public void setCn(Conexion cn) {
        this.cn = cn;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }
    
    
    
    public DefaultTableModel leer(){
    DefaultTableModel  tabla = new DefaultTableModel();
    try{
      cn = new Conexion();
      cn.abrir_conexion();
        String query;
        query = "SELECT ventas_detalle.idventas_detalle,ventas_detalle.idVenta,ventas_detalle.idProducto,ventas_detalle.cantidad,ventas_detalle.precio_unitario FROM proyecto_db.ventas_detalle;";
       
        ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
        String encabezado[] = {"idventas_detalle","idVenta","idProducto","cantidad","precio_unitario"};
      tabla.setColumnIdentifiers(encabezado);
      String datos[] = new String[7];
      while (consulta.next()){
          datos[0] = consulta.getString("idventas_detalle");
          datos[1] = consulta.getString("idVenta");
          datos[2] = consulta.getString("idProducto");
          datos[3] = consulta.getString("cantidad");
          datos[4] = consulta.getString("precio_unitario");
          
          
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
         //INSERT INTO `proyecto_db`.`empleados` (`idEmpleados`, `nombres`, `apellidos`, `direccion`, `telefono`, `DPI`, `genero`, `fecha_nacimiento`, `idPuesto`, `fecha_inicio_labores`, `fechaingreso`) 
         String query="INSERT INTO proyecto_db.ventas_detalle(idventas_detalle,idVenta,idProducto,cantidad,precio_unitario)VALUES(?,?,?,?,?);";   
         cn.abrir_conexion();
         parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
          parametro.setInt(1, getIdventas_detalle());
          parametro.setInt(2, getIdVenta());
          parametro.setInt(3, getIdProducto());
          parametro.setString(4, getCantidad());
          parametro.setInt(5,getPrecio_unitario());
          
          retorno = parametro.executeUpdate();
         cn.cerrar_conexion();
     }catch(SQLException ex){
        System.out.println(ex.getMessage());
        retorno = 0;
    }
 return retorno;   
}
    //se creo la funcion modificar 

    public int modifica(){
         int retorno  =0;
     try {
         PreparedStatement parametro;
         cn = new Conexion();
         String query="UPDATE proyecto_db.ventas_detalle SET idventas_detalle = ?,idVenta = ?,idProducto = ?,cantidad = ?,precio_unitario = ? WHERE idventas_detalle= ?;" ;   
         cn.abrir_conexion();
         parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);

          parametro.setInt(1, getIdventas_detalle());
          parametro.setInt(2, getIdVenta());
          parametro.setInt(3, getIdProducto());
          parametro.setString(4, getCantidad());
          parametro.setInt(5,getPrecio_unitario());
          parametro.setInt(6, getIdventas_detalle());
          
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
         String query="delete from ventas_detalle where idventas_detalle = ?;";   
         cn.abrir_conexion();
         parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
          parametro.setInt(1,getIdventas_detalle());
          retorno = parametro.executeUpdate();
         cn.cerrar_conexion();
     }catch(SQLException ex){
        System.out.println(ex.getMessage());
        retorno = 0;
    }
 return retorno;   

 }   

    
    
}
