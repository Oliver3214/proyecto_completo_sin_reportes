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
public class clientes {
    
    private int id_clientes;
    private String nombres;
    private String apellidos;
    private String NIT;
    private String genero;
    private String telefono;
    private String correo_electronico;
    private String Fecha_ingreso;

    
    public Conexion cn;
    
    public clientes(){}

    public clientes(int id_clientes, String nombres, String apellidos, String NIT, String genero, String telefono, String correo_electronico, String Fecha_ingreso) {
        this.id_clientes = id_clientes;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.NIT = NIT;
        this.genero = genero;
        this.telefono = telefono;
        this.correo_electronico = correo_electronico;
        this.Fecha_ingreso = Fecha_ingreso;
    }

    
    

    public int getId_clientes() {
        return id_clientes;
    }

    public void setId_clientes(int id_clientes) {
        this.id_clientes = id_clientes;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getFecha_ingreso() {
        return Fecha_ingreso;
    }

    public void setFecha_ingreso(String Fecha_ingreso) {
        this.Fecha_ingreso = Fecha_ingreso;
    }
    
          
       
    public DefaultTableModel leer(){
    DefaultTableModel  tabla = new DefaultTableModel();
    try{
    cn = new Conexion();
    cn.abrir_conexion();
    String query;
    query = "SELECT clientes.idClientes, clientes.nombres, clientes.apellidos, clientes.NIT, clientes.genero, clientes.telefono, clientes.correo_electronico, clientes.fechaingreso FROM proyecto_db.clientes;";
    ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
    String encabezado[] = {"idClientes","nombres","apellidos","NIT","genero", "telefono","correo_electronico", "fechaingreso"};
    tabla.setColumnIdentifiers(encabezado);
    String datos[] = new String[8];
    while (consulta.next()){
    datos[0] = consulta.getString("idClientes");
    datos[1] = consulta.getString("nombres");
    datos[2] = consulta.getString("apellidos");
    datos[3] = consulta.getString("NIT");
    datos[4] = consulta.getString("genero");
    datos[5] = consulta.getString("telefono");
    datos[6] = consulta.getString("correo_electronico");
    datos[7] = consulta.getString("fechaingreso");

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
         String query="INSERT INTO proyecto_db.clientes(idClientes,nombres,apellidos,NIT,genero,telefono,correo_electronico,fechaingreso)VALUES(?,?,?,?,?,?,?,?);";   
         cn.abrir_conexion();
         parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
          parametro.setInt(1, getId_clientes());
          parametro.setString(2, getNombres());
          parametro.setString(3, getApellidos());
          parametro.setString(4, getNIT());
          parametro.setString(5,getGenero());
          parametro.setString(6, getTelefono());
          parametro.setString(7, getCorreo_electronico());
          parametro.setString(8, getFecha_ingreso());
          
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
         String query="UPDATE proyecto_db.clientes SET idClientes = ?,nombres = ?,apellidos = ?,NIT = ?,genero = ?,telefono = ?,correo_electronico = ?,fechaingreso = ? WHERE idClientes =?;" ;   
         cn.abrir_conexion();
         parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);

          parametro.setInt(1, getId_clientes());
          parametro.setString(2, getNombres());
          parametro.setString(3, getApellidos());
          parametro.setString(4, getNIT());
          parametro.setString(5,getGenero());
          parametro.setString(6, getTelefono());
          parametro.setString(7, getCorreo_electronico());
          parametro.setString(8, getFecha_ingreso());
          parametro.setInt(9, getId_clientes());
          
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
         String query="delete from clientes where idClientes = ?;";   
         cn.abrir_conexion();
         parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
          parametro.setInt(1,getId_clientes());
          retorno = parametro.executeUpdate();
         cn.cerrar_conexion();
     }catch(SQLException ex){
        System.out.println(ex.getMessage());
        retorno = 0;
    }
 return retorno;   
}

 
 
    public HashMap drop_id_clientes(){
         HashMap<String,String> drop = new HashMap();
         try{
             cn = new Conexion();
             //SELECT idPuestos,puestos FROM puestos;
             String query= "SELECT idClientes as id, NIT FROM clientes;";
             cn.abrir_conexion();
             ResultSet consulta =  cn.conexionBD.createStatement().executeQuery(query);
             while (consulta.next()){
                 drop.put(consulta.getString("id"), consulta.getString("id"));
             }
             
             cn.cerrar_conexion();
             
         
         }catch (SQLException ex){
                 System.out.println(ex.getMessage());
         }
         return drop;
    }
     public HashMap drop_nombres_clientes(){
         HashMap<String,String> drop = new HashMap();
         try{
             cn = new Conexion();
             //SELECT idPuestos,puestos FROM puestos;
             String query= "SELECT idClientes as id, nombres, NIT FROM clientes;";
             cn.abrir_conexion();
             ResultSet consulta =  cn.conexionBD.createStatement().executeQuery(query);
             while (consulta.next()){
                 drop.put(consulta.getString("id"), consulta.getString("nombres"));
             }
             
             cn.cerrar_conexion();
             
         
         }catch (SQLException ex){
                 System.out.println(ex.getMessage());
         }
         return drop;
    }
     public HashMap drop_nit_clientes(){
         HashMap<String,String> drop = new HashMap();
         try{
             cn = new Conexion();
             //SELECT idPuestos,puestos FROM puestos;
             String query= "SELECT idClientes as id, NIT FROM clientes;";
             cn.abrir_conexion();
             ResultSet consulta =  cn.conexionBD.createStatement().executeQuery(query);
             while (consulta.next()){
                 drop.put(consulta.getString("id"), consulta.getString("NIT"));
             }
             
             cn.cerrar_conexion();
             
         
         }catch (SQLException ex){
                 System.out.println(ex.getMessage());
         }
         return drop;
    }
    
}
