
<%@page import="modelo.clientes"%>
<%@page import="modelo.compras"%>
<%@page import="modelo.compras_detalle"%>
<%@page  import="modelo.proveedores"%>
<%@page import="java.util.HashMap"%>
<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compras</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    </head>
    <body>
        <heather >
        

        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="true">
          <button type="button" class="btn btn-dark">MENU</button>
        </a>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="menu.jsp">MENU</a>
          <a class="dropdown-item" href="clientes.jsp">CLIENTES</a>
          <a class="dropdown-item" href="empleados.jsp">EMPLEADOS</a>
          <a class="dropdown-item" href="marcas.jsp">MARCAS</a>
          <a class="dropdown-item" href="productos.jsp">PRODUCTO</a>
          <a class="dropdown-item" href="puestos.jsp">PUESTOS</a>
          <a class="dropdown-item" href="proveedores.jsp">PROVEEDORES</a>
          <a class="dropdown-item" href="ventas.jsp">VENTAS</a>
          <div class="dropdown-divider"></div>
          <form class="dropdown-item" metho="POST" action="index.jsp">
              <button class="btn btn-danger center-block" type="submit" name="accion" value="Salir" href="#">Cerrar Sesion</form>
        </div>
      </li>

    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    -->
        
       
    </heather>
        <div class="d-flex justify-content-center">
        <h1>Formulario Compras!</h1>
        </div>
        <button type="button" class="btn btn-info btn-lg " data-toggle="modal" data-target="#modal_empleado" onclick="limpiar()">Nueva Compra</button>
      

        <div class="container">
            <div class="modal fade" id="modal_empleado" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-body">
         
            <form action="sr_compras" method="post" class="form-group">
                
                <label for="lbl_idEmpleado"><b>ID Compras:</b></label>
                 <input type="text" name="txt_idcompras" id="txt_idcompras"class="form-control" value="0" readonly  >
                 <label for="lbl_nombres"><b>Numero Orden Compra</b></label>
                 <input type="text" name="txt_orden" id="txt_orden"class="form-control" placeholder="Ejemplo: Nombre 1 Nombre 2" required>
                 <label for="lbl_apellidos"><b>ID proveedor</b></label>
                 <input type="text" name="txt_proveedor" id="txt_proveedor"class="form-control" placeholder="Apellido 1 Apellido 2" required>
                 <%--nombre y nit de la tabla clientes  --%>
                 <label for="lbl_sangre"><b>Nombre Proveedor</b></label>
                 <select name="drop_puesto" id="drop_puesto"class="form-control">
                     <%
                         proveedores Empleado = new proveedores();
                         HashMap<String,String>dropE = Empleado.drop_sangre();
                         for (String i: dropE.keySet()){
                         out.println("<option value='" + i +"'>" + dropE.get(i) +"</option>");
                         
                         }
                         
                      %>
                 </select>
                 
                 
                 <label for="lbl_direccion"><b>Fecha Orden:</b></label>
                 <input type="date" name="txt_fecha_orden" id="txt_fecha_orden"class="form-control" placeholder="Ejemplo: #casa calle zona ciudad" required>
                  
                 <label for="lbl_telefono"><b>Fecha Ingreso</b></label>
                 <input type="date" name="txt_fecha_ingreso" id="txt_fecha_ingreso"class="form-control" placeholder="Ejemplo:00000000 " required>
                 
                 <!-- -->
                 
                 
                 <!--creamos el formulario de compras_detalle -->
                 <label for="lbl_genero"><b>ID Detalle:</b></label>
                 <input type="text" name="txt_detalle" id="txt_detalle"class="form-control" value="0" readonly>
                 <label for="lbl_genero"><b>ID Producto:</b></label>
                 <input type="text" name="txt_producto" id="txt_producto"class="form-control" placeholder="Ejemplo:00000000 " required>
                 <label for="lbl_genero"><b>Cantidad:</b></label>
                 <input type="text" name="txt_cantidad" id="txt_cantidad"class="form-control" placeholder="Ejemplo:00000000 " required>
                 <label for="lbl_genero"><b>Precio Costo Unitario:</b></label>
                 <input type="text" name="txt_precio" id="txt_precio"class="form-control" placeholder="Ejemplo:00000000 " required>


                 <!-- agregamos el formulario de la nueva base de datos -->
                  <br>
                  <button name="btn_agregar" id="btn_agregar" value= "agregar"class="btn btn-primary btn-lg">Agregar</button>
                   <button name="btn_modificar" id="btn_modificar" value= "modificar"class="btn btn-secondary btn-lg">modificar</button>
                    <button name="btn_eliminar" id="btn_eliminar" value= "eliminar"class="btn btn-success btn-lg" onclick="javascript:if(!confirm('¿Desea Eliminar?'))return false">eliminar</button>
                    <button type="button" class="btn btn-warning btn-lg" data-dismiss="modal">Cerrar</button>
                    <button type="button" class="btn btn-warning" data-toggle="modal" ><a href="proveedores.jsp" target="target" class="btn btn-warning">proveedores</a></button>
            </form>
        </div>
       
      </div>
      
    </div>
  </div>
                 
                <!-- tabla que genera los datos al servlet -->         
                 
    <table class="table table-striped">
    <thead>
      <tr>
        
        <th>NO Orden</th>
        <th>ID proveedor</th>
        <th>Fecha Orden</th>
        <th>Fecha Ingreso</th>
        <th>ID Compra</th>
        <th>ID Producto</th>
        <th>Cantidad</th>
        <th>Precio Unitario</th>
      </tr>
    </thead>
    <tbody id="tbl_empleados">
            <!-- tabla que muestra los datos del select leer() -->
           <%
            compras Ventas = new compras();
            DefaultTableModel tabla = new DefaultTableModel();
            tabla = Ventas.leer();
            
            compras_detalle Detalle = new compras_detalle();
            DefaultTableModel tabla2 = new DefaultTableModel();
            tabla2 = Detalle.leer();
            for (int t=0;t<tabla.getRowCount();t++){
                
                out.println("<tr data-id=" + tabla.getValueAt(t,0) +  " data-id_p=" + tabla.getValueAt(t,2) +  ">");
                out.println("<td>" + tabla.getValueAt(t,1) + "</td>");
                out.println("<td>" + tabla.getValueAt(t,2) + "</td>");
                out.println("<td>" + tabla.getValueAt(t,3) + "</td>");
                out.println("<td>" + tabla.getValueAt(t,4) + "</td>");
                
                out.println("<td>" + tabla2.getValueAt(t,1) + "</td>");
                out.println("<td>" + tabla2.getValueAt(t,2) + "</td>");
                out.println("<td>" + tabla2.getValueAt(t,3) + "</td>");
                out.println("<td>" + tabla2.getValueAt(t,4) + "</td>");
                out.println("</tr>");
                
              

                out.println("</tr>");
         
            }
            
            
            
            
         
                        %>
                        
                        
        
    </tbody>
  </table>
</div>
            
        </div>
        

    
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
        
       
       <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
       <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
       <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
       <script type="text/javascript">
          function limpiar(){
            $("#txt_orden").val('');
            $("#txt_proveedor").val('');
            $("#txt_fecha_orden").val('');
            $("#txt_fecha_ingreso").val('');
            $("#txt_producto").val('');
            $("#txt_cantidad").val('');
            $("#txt_precio").val('');

          }
    
    $('#tbl_empleados').on('click','tr td',function(evt){
            var target,id,id_p,nombres,apellidos,direccion,telefono, DPI, genero ,fecha_nacimiento,fecha_inicio_labores, fechaingreso, puesto ;
            target = $(event.target);
            id = target.parent().data('id');
            id_p = target.parent().data('id_p');
            nombres = target.parent("tr").find("td").eq(0).html();
            apellidos = target.parent("tr").find("td").eq(1).html();
            direccion = target.parent("tr").find("td").eq(2).html();
            telefono = target.parent("tr").find("td").eq(3).html();
            DPI = target.parent("tr").find("td").eq(4).html();
            genero = target.parent("tr").find("td").eq(5).html();
            fecha_nacimiento = target.parent("tr").find("td").eq(6).html();
            fecha_inicio_labores = target.parent("tr").find("td").eq(8).html();
            fechaingreso = target.parent("tr").find("td").eq(7).html();
            puesto = target.parent("tr").find("td").eq(10).html();
            
            $("#id_p").val(id_p);
            $("#txt_idcompras").val(id);
            $("#txt_orden").val(nombres);
            $("#txt_proveedor").val(apellidos);
            $("#txt_fecha_orden").val(direccion);
            $("#txt_fecha_ingreso").val(telefono);
            //se agregaron dpi y genero, fecha inicial, fecha ingreso
            $("#txt_detalle").val(DPI);
            $("#txt_producto").val(genero);
            $("#txt_detalle").val(id);
            $("#txt_cantidad").val(fecha_nacimiento);
            $("#txt_precio").val(fechaingreso);
            
            
            
            $("#modal_empleado").modal('show');
               
           
    
    //
               
           });
       </script>
       </body>
    
</html>
