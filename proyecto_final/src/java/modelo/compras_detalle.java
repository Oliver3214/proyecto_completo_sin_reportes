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
public class compras_detalle {
    private int idcompras_detalle;
    private int idcompra;
    private int idproducto;
    private int cantidad;
    private int precio_costo_unitario;
    
    public Conexion cn;
    
    public compras_detalle (){}

    public compras_detalle(int idcompras_detalle, int idcompra, int idproducto, int cantidad, int precio_costo_unitario) {
        this.idcompras_detalle = idcompras_detalle;
        this.idcompra = idcompra;
        this.idproducto = idproducto;
        this.cantidad = cantidad;
        this.precio_costo_unitario = precio_costo_unitario;
    }

    public int getIdcompras_detalle() {
        return idcompras_detalle;
    }

    public void setIdcompras_detalle(int idcompras_detalle) {
        this.idcompras_detalle = idcompras_detalle;
    }

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio_costo_unitario() {
        return precio_costo_unitario;
    }

    public void setPrecio_costo_unitario(int precio_costo_unitario) {
        this.precio_costo_unitario = precio_costo_unitario;
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
        query = "SELECT compras_detalle.idcompras_detalle, compras_detalle.idcompra, compras_detalle.idproducto, compras_detalle.cantidad, compras_detalle.precio_costo_unitario FROM proyecto_db.compras_detalle;";
       
        ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
        String encabezado[] = {"idcompras_detalle","idcompra","idproducto","cantidad","precio_costo_unitario"};
      tabla.setColumnIdentifiers(encabezado);
      String datos[] = new String[7];
      while (consulta.next()){
          datos[0] = consulta.getString("idcompras_detalle");
          datos[1] = consulta.getString("idcompra");
          datos[2] = consulta.getString("idproducto");
          datos[3] = consulta.getString("cantidad");
          datos[4] = consulta.getString("precio_costo_unitario");
          
          
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
         String query="INSERT INTO proyecto_db.compras_detalle(idcompras_detalle,idcompra,idproducto,cantidad,precio_costo_unitario)VALUES(?,?,?,?,?);";   
         cn.abrir_conexion();
         parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
          parametro.setInt(1, getIdcompras_detalle());
          parametro.setInt(2, getIdcompra());
          parametro.setInt(3, getIdproducto());
          parametro.setInt(4, getCantidad());
          parametro.setInt(5,getPrecio_costo_unitario());
          
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
         String query="UPDATE proyecto_db.compras_detalle SET idcompras_detalle = ?, idcompra = ?, idproducto = ?, cantidad = ?, precio_costo_unitario = ? WHERE idcompras_detalle = ?;" ;   
         cn.abrir_conexion();
         parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);

          parametro.setInt(1, getIdcompras_detalle());
          parametro.setInt(2, getIdcompra());
          parametro.setInt(3, getIdproducto());
          parametro.setInt(4, getCantidad());
          parametro.setInt(5,getPrecio_costo_unitario());
          parametro.setInt(6, getIdcompras_detalle());
          
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
         String query="delete from compras_detalle where idcompras_detalle = ?;";   
         cn.abrir_conexion();
         parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
          parametro.setInt(1,getIdcompras_detalle());
          retorno = parametro.executeUpdate();
         cn.cerrar_conexion();
     }catch(SQLException ex){
        System.out.println(ex.getMessage());
        retorno = 0;
    }
 return retorno;   

 }

    
    
}
