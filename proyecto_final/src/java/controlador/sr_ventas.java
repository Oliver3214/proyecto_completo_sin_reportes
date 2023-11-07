/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ventas;
import modelo.ventas_detalle;

/**
 *
 * @author oliver
 */
@WebServlet(name = "sr_ventas", urlPatterns = {"/sr_ventas"})
public class sr_ventas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ventas Ventas;
    ventas_detalle Detalle;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sr_ventas</title>");            
            out.println("</head>");
            out.println("<body>");
            
            if ("agregar".equals(request.getParameter("btn_agregar"))){
            Ventas = new ventas(Integer.valueOf(request.getParameter("txt_idVentas")),Integer.valueOf(request.getParameter("txt_factura")),request.getParameter("txt_serie"),request.getParameter("txt_fecha_factura"), Integer.valueOf(request.getParameter("txt_idCliente")), Integer.valueOf(request.getParameter("txt_idEmpleado")),request.getParameter("txt_Fecha_ingreso"));
            //Empleado = new empleado(Integer.valueOf(request.getParameter("txt_idEmpleados")), Integer.valueOf(request.getParameter("drop_puesto"), Integer.valueOf(request.getParameter("txt_DPI")), request.getParameter("txt_genero"), request.getParameter("txt_fecha_inicio_labores"), request.getParameter("txt_fechaingreso"), Integer.valueOf(request.getParameter("txt_id"), request.getParameter("txt_nombres"), request.getParameter("txt_apellidos"), request.getParameter("txt_direccion"), request.getParameter("txt_telefono"), request.getParameter("txt_fn"));
            Detalle = new ventas_detalle(Integer.valueOf(request.getParameter("txt_detalle")), Integer.valueOf(request.getParameter("txt_idVentas")), Integer.valueOf(request.getParameter("txt_producto")), request.getParameter("txt_cantidad"), Integer.valueOf(request.getParameter("txt_precio")));
            
            
            if (Ventas.agregar() > 0 && Detalle.agregar() > 0) {
                response.sendRedirect("ventas.jsp");
            /*out.println("<h1> Ingreso Exitoso </h1>");
            out.println("<a href ='empleados.jsp'> Regresar </a>");*/
            }else{
               out.println("<h1> Error.... </h1>"); 
               out.println("<a href ='ventas.jsp'> Regresar </a>");
             
             }
            }
            
            
            
            
            
            
            
            if ("modificar".equals(request.getParameter("btn_modificar"))){
            //Empleado = new empleado(request.getParameter("txt_codigo"),Integer.valueOf(request.getParameter("drop_puesto")),Integer.valueOf(request.getParameter("txt_id")),request.getParameter("txt_nombres"),request.getParameter("txt_apellidos"),request.getParameter("txt_direccion"),request.getParameter("txt_telefono"),request.getParameter("txt_fn"));
            Ventas = new ventas(Integer.valueOf(request.getParameter("txt_idVentas")),Integer.valueOf(request.getParameter("txt_factura")),request.getParameter("txt_serie"),request.getParameter("txt_fecha_factura"), Integer.valueOf(request.getParameter("txt_idCliente")), Integer.valueOf(request.getParameter("txt_idEmpleado")),request.getParameter("txt_Fecha_ingreso"));
            Detalle = new ventas_detalle(Integer.valueOf(request.getParameter("txt_detalle")), Integer.valueOf(request.getParameter("txt_idVentas")), Integer.valueOf(request.getParameter("txt_producto")), request.getParameter("txt_cantidad"), Integer.valueOf(request.getParameter("txt_precio")));
            
            if ( Ventas.modificar() > 0 && Detalle.modifica()  > 0 ) {
                response.sendRedirect("ventas.jsp");
            /*out.println("<h1> Ingreso Exitoso </h1>");
            out.println("<a href ='empleados.jsp'> Regresar </a>");*/
            }else{
               out.println("<h1> No se modifico.... </h1>"); 
               out.println("<a href ='ventas.jsp'> Regresar </a>");
             
            }

            }
            
            
            
            
            if ("eliminar".equals(request.getParameter("btn_eliminar"))){
            //Empleado = new empleado(request.getParameter("txt_codigo"),Integer.valueOf(request.getParameter("drop_puesto")),Integer.valueOf(request.getParameter("txt_id")),request.getParameter("txt_nombres"),request.getParameter("txt_apellidos"),request.getParameter("txt_direccion"),request.getParameter("txt_telefono"),request.getParameter("txt_fn"));
            Ventas = new ventas(Integer.valueOf(request.getParameter("txt_idVentas")),Integer.valueOf(request.getParameter("txt_factura")),request.getParameter("txt_serie"),request.getParameter("txt_fecha_factura"), Integer.valueOf(request.getParameter("txt_idCliente")), Integer.valueOf(request.getParameter("txt_idEmpleado")),request.getParameter("txt_Fecha_ingreso"));
            Detalle = new ventas_detalle(Integer.valueOf(request.getParameter("txt_detalle")), Integer.valueOf(request.getParameter("txt_idVentas")), Integer.valueOf(request.getParameter("txt_producto")), request.getParameter("txt_cantidad"), Integer.valueOf(request.getParameter("txt_precio")));
            
            if (Detalle.eliminar() > 0 && Ventas.eliminar() > 0 ) {
                response.sendRedirect("ventas.jsp");
            /*out.println("<h1> No se elimino</h1>");
            out.println("<a href ='empleados.jsp'> Regresar </a>");*/
            }else{
               out.println("<h1> Error.... </h1>"); 
               out.println("<a href ='ventas.jsp'> Regresar </a>");
             
             }
            }

            
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
