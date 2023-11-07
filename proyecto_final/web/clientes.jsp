
<%@page  import="modelo.clientes"%>
<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
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
          <a class="dropdown-item" href="compras.jsp">COMPRAS</a>
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
        <h1>Formulario Clientes!</h1>
        </div>
        <button type="button" class="btn btn-info btn-lg " data-toggle="modal" data-target="#modal_empleado" onclick="limpiar()">Nuevo Cliente</button>
      

        <div class="container">
            <div class="modal fade" id="modal_empleado" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-body">
         
            <form action="sr_cliente" method="post" class="form-group">
                
                <label for="lbl_idEmpleado"><b>Id Clientes</b></label>
                 <input type="text" name="txt_idClientes" id="txt_idClientes"class="form-control" value="0" readonly>
                 <label for="lbl_nombres"><b>Nombres:</b></label>
                 <input type="text" name="txt_nombres" id="txt_nombres"class="form-control" placeholder="Ejemplo: Nombre 1 Nombre 2" required>
                 <label for="lbl_apellidos"><b>Apellidos:</b></label>
                 <input type="text" name="txt_apellidos" id="txt_apellidos"class="form-control" placeholder="Apellido 1 Apellido 2" required>
                 <label for="lbl_direccion"><b>NIT:</b></label>
                 <input type="text" name="txt_NIT" id="txt_NIT"class="form-control" placeholder="Ejemplo: #casa calle zona ciudad" required>
                  <label for="lbl_telefono"><b>genero:</b></label>
                 <input type="text" name="txt_genero" id="txt_genero"class="form-control" placeholder="Ejemplo:00000000 " required>
                 <label for="lbl_DPI"><b>Telefono:</b></label>
                 <input type="number" name="txt_Telefono" id="txt_Telefono"class="form-control" placeholder="Ejemplo:00000000 " required>
                 <label for="lbl_genero"><b>Correo Electronico:</b></label>
                 <input type="text" name="txt_Correo_Electronico" id="txt_Correo_Electronico"class="form-control" placeholder="Ejemplo:00000000 " required>
                 <label for="lbl_fn"><b>Fecha Ingreso:</b></label>
                 <input type="date" name="txt_fI" id="txt_fI"class="form-control"  required>
                 
               
                 <!-- agregamos el formulario de la nueva base de datos -->
                  <br>
                  <button name="btn_agregar" id="btn_agregar" value= "agregar"class="btn btn-primary btn-lg">Agregar</button>
                   <button name="btn_modificar" id="btn_modificar" value= "modificar"class="btn btn-secondary btn-lg">modificar</button>
                    <button name="btn_eliminar" id="btn_eliminar" value= "eliminar"class="btn btn-success btn-lg" onclick="javascript:if(!confirm('¿Desea Eliminar?'))return false">eliminar</button>
                    <button type="button" class="btn btn-warning btn-lg" data-dismiss="modal">Cerrar</button>
                    <button type="button" class="btn btn-warning" data-toggle="modal" ><a href="ventas.jsp" target="target" class="btn btn-warning">Ventas</a></button>
        
            </form>
        </div>
       
      </div>
      
    </div>
  </div>
                 
                <!-- tabla que genera los datos al servlet -->         
                 
    <table class="table table-striped">
    <thead>
      <tr>
        <th>Nombres</th>
        <th>Apellidos</th>
        <th>NIT</th>
        <th>genero</th>
        <th>Telefono</th>
        <th>Correo</th>
        <th>Fecha Ingreso</th>
      </tr>
    </thead>
    <tbody id="tbl_empleados">
            <!-- tabla que muestra los datos del select leer() -->
           <%
         clientes Clientes = new clientes();
         DefaultTableModel tabla = new DefaultTableModel();
         tabla = Clientes.leer(); 
         for (int t=0;t<tabla.getRowCount();t++){
         out.println("<tr data-id=" + tabla.getValueAt(t,0) +  " data-id_p=" + tabla.getValueAt(t,6) +  ">");
         out.println("<td>" + tabla.getValueAt(t,1) + "</td>");
         out.println("<td>" + tabla.getValueAt(t,2) + "</td>");
         out.println("<td>" + tabla.getValueAt(t,3) + "</td>");
         out.println("<td>" + tabla.getValueAt(t,4) + "</td>");
         out.println("<td>" + tabla.getValueAt(t,5) + "</td>");
         out.println("<td>" + tabla.getValueAt(t,6) + "</td>");
         out.println("<td>" + tabla.getValueAt(t,7) + "</td>");
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
            $("#txt_nombres").val('');
            $("#txt_apellidos").val('');
            $("#txt_NIT").val('');
            $("#txt_genero").val('');
            $("#txt_Telefono").val('');
            $("#txt_Correo_Electronico").val('');
            $("#txt_fI").val('');

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
            fechaingreso = target.parent("tr").find("td").eq(9).html();
            puesto = target.parent("tr").find("td").eq(7).html();
            
            $("#txt_idClientes").val(id);
            $("#txt_nombres").val(nombres);
            $("#txt_apellidos").val(apellidos);
            $("#txt_NIT").val(direccion);
            $("#txt_genero").val(telefono);
            //se agregaron dpi y genero, fecha inicial, fecha ingreso
            $("#txt_Telefono").val(DPI);
            $("#txt_Correo_Electronico").val(genero);
            $("#txt_fI").val(fecha_nacimiento);
  
            $("#modal_empleado").modal('show');
               
           
    
    //
               
           });
       </script>
       </body>
    
</html>
