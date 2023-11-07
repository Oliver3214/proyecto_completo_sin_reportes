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
import modelo.compras;
import modelo.compras_detalle;

/**
 *
 * @author oliver
 */
@WebServlet(name = "sr_compras", urlPatterns = {"/sr_compras"})
public class sr_compras extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    compras Compras;
    compras_detalle Detalle;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sr_compras</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
            //compras_detalle(int idcompras_detalle, int idcompra, int idproducto, int cantidad, int precio_costo_unitario)
            
            //compras(int idcompra, int no_orden_compra, int idproveedor, String fecha_orden, String fechaingreso)
             
            if ("agregar".equals(request.getParameter("btn_agregar"))){
            Compras = new compras(Integer.valueOf(request.getParameter("txt_idcompras")),Integer.valueOf(request.getParameter("txt_orden")),Integer.valueOf(request.getParameter("txt_proveedor")),request.getParameter("txt_fecha_orden"),request.getParameter("txt_fecha_ingreso"));
            Detalle = new compras_detalle(Integer.valueOf(request.getParameter("txt_detalle")),Integer.valueOf(request.getParameter("txt_idcompras")),Integer.valueOf(request.getParameter("txt_producto")),Integer.valueOf(request.getParameter("txt_cantidad")),Integer.valueOf(request.getParameter("txt_precio")));
            
            
            if (Compras.agregar() > 0 && Detalle.agregar() > 0) {
                response.sendRedirect("compras.jsp");
            /*out.println("<h1> Ingreso Exitoso </h1>");
            out.println("<a href ='empleados.jsp'> Regresar </a>");*/
            }else{
               out.println("<h1> Error.... </h1>"); 
               out.println("<a href ='compras.jsp'> Regresar </a>");
             
             }
            }
            
            
            
            
            
            
            
            if ("modificar".equals(request.getParameter("btn_modificar"))){
            Compras = new compras(Integer.valueOf(request.getParameter("txt_idcompras")),Integer.valueOf(request.getParameter("txt_orden")),Integer.valueOf(request.getParameter("txt_proveedor")),request.getParameter("txt_fecha_orden"),request.getParameter("txt_fecha_ingreso"));
            Detalle = new compras_detalle(Integer.valueOf(request.getParameter("txt_detalle")),Integer.valueOf(request.getParameter("txt_idcompras")),Integer.valueOf(request.getParameter("txt_producto")),Integer.valueOf(request.getParameter("txt_cantidad")),Integer.valueOf(request.getParameter("txt_precio")));
            
            if ( Compras.modificar() > 0 && Detalle.modifica()  > 0 ) {
                response.sendRedirect("compras.jsp");
            /*out.println("<h1> Ingreso Exitoso </h1>");
            out.println("<a href ='empleados.jsp'> Regresar </a>");*/
            }else{
               out.println("<h1> No se modifico.... </h1>"); 
               out.println("<a href ='compras.jsp'> Regresar </a>");
             
            }

            }
            
            
            
             if ("eliminar".equals(request.getParameter("btn_eliminar"))){
            //Empleado = new empleado(request.getParameter("txt_codigo"),Integer.valueOf(request.getParameter("drop_puesto")),Integer.valueOf(request.getParameter("txt_id")),request.getParameter("txt_nombres"),request.getParameter("txt_apellidos"),request.getParameter("txt_direccion"),request.getParameter("txt_telefono"),request.getParameter("txt_fn"));
            Compras = new compras(Integer.valueOf(request.getParameter("txt_idcompras")),Integer.valueOf(request.getParameter("txt_orden")),Integer.valueOf(request.getParameter("txt_proveedor")),request.getParameter("txt_fecha_orden"),request.getParameter("txt_fecha_ingreso"));
            Detalle = new compras_detalle(Integer.valueOf(request.getParameter("txt_detalle")),Integer.valueOf(request.getParameter("txt_idcompras")),Integer.valueOf(request.getParameter("txt_producto")),Integer.valueOf(request.getParameter("txt_cantidad")),Integer.valueOf(request.getParameter("txt_precio")));
            
            if (Compras.eliminar() > 0 && Detalle.eliminar() > 0  ) {
                response.sendRedirect("compras.jsp");
            /*out.println("<h1> No se elimino</h1>");
            out.println("<a href ='empleados.jsp'> Regresar </a>");*/
            }else{
               out.println("<h1> Error.... </h1>"); 
               out.println("<a href ='compras.jsp'> Regresar </a>");
             
             }
            }

            
            
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
