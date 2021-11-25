/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Compra;
import ModelDAO.CompraDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LisRR
 */

public class CompraController extends HttpServlet {
    
    Compra com = new Compra();
    CompraDAO comdao = new CompraDAO();
    
    String show = "Compra/show.jsp";
    String add = "Compra/add.jsp";
    String edit = "Compra/edit.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CompraController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CompraController at " + request.getContextPath() + "</h1>");
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
        String access = "";
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("show")){
            access = show;
        } else if(action.equalsIgnoreCase("add")){
            access = add;
        } else if(action.equalsIgnoreCase("Guardar")){
            // Aquí se pueden invocar metodos para realizar operaciones
            String fechaC = request.getParameter("txtFechaCom");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = null;
            try {
                fecha = dateFormat.parse(fechaC);
            } catch (ParseException ex) {
                Logger.getLogger(CompraController.class.getName()).log(Level.SEVERE, null, ex);
            }
            int cant = Integer.parseInt(request.getParameter("txtCantCom"));
            boolean iva = Boolean.parseBoolean(request.getParameter("txtIvaCom"));
            //pendiente monto, es float
            float montoT = Float.parseFloat(request.getParameter("txtMontotCom"));
            String estado = request.getParameter("txtEstadoCom");
            String rfcProv = request.getParameter("txtRfcCom");
            int producto = Integer.parseInt(request.getParameter("txtIdProductoCom"));
            // Se instancia los valores (despues de x proceso realizado)
            com.setFechaCompra(fecha);
            com.setCantidad(cant);
            com.setIva(iva);
            com.setMontoTotal(montoT);
            com.setEstado(estado);
            com.setRfcProveedor(rfcProv);
            com.setProductoid(producto);
            // Se le pasa el objeto para realizar la operación
            comdao.add(com);
            // Se redirige a la vista
            access = show;
        } else if(action.equalsIgnoreCase("edit")){ //checar vista 
            // Se obtiene la info del request
            request.setAttribute("folioC", request.getParameter("folioC"));
            // Se redirige a la vista
            access = edit;
        } else if(action.equalsIgnoreCase("Editar")){
            // Aquí se pueden invocar metodos para realizar operaciones
            String fechaC = request.getParameter("txtFechaCom");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = null;
            try {
                fecha = dateFormat.parse(fechaC);
            } catch (ParseException ex) {
                Logger.getLogger(CompraController.class.getName()).log(Level.SEVERE, null, ex);
            }
            int cant = Integer.parseInt(request.getParameter("txtCantCom"));
            boolean iva = Boolean.parseBoolean(request.getParameter("txtIvaCom"));
            //pendiente monto, es float
            int montoT = Integer.parseInt(request.getParameter("txtMontotCom"));
            String estado = request.getParameter("txtEstadoCom");
            String rfcProv = request.getParameter("txtRfcCom");
            int producto = Integer.parseInt(request.getParameter("txtIdProductoCom"));
            // Se instancia los valores (despues de x proceso realizado)
            com.setFechaCompra(fecha);
            com.setCantidad(cant);
            com.setIva(iva);
            com.setMontoTotal(montoT);
            com.setEstado(estado);
            com.setRfcProveedor(rfcProv);
            com.setProductoid(producto);
            // Se le pasa el objeto para realizar la operación
            comdao.edit(com);
            // Se redirige a la vista
            access = show;
        } else if(action.equalsIgnoreCase("delete")){
            // Aquí se pueden invocar metodos para realizar operaciones
            int folio = Integer.parseInt(request.getParameter("folioC"));
            // Se instancia los valores (despues de x proceso realizado)
            com.setFolio(folio);
            // Se le pasa el objeto para realizar la operación
            comdao.delete(folio);
            // Se redirige a la vista
            access = show;
        }
        
        RequestDispatcher view = request.getRequestDispatcher(access);
        view.forward(request, response);
        
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
