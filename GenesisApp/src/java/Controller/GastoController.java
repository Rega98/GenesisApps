/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Gasto;
import ModelDAO.GastoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Samuel Romero, Julián Torres
 * @version 1.0
 */

// Duda en línea 124

@WebServlet(name = "GastoController", urlPatterns = {"/GastoController"})
public class GastoController extends HttpServlet {

    Gasto gasto = new Gasto();
    GastoDAO gDAO = new GastoDAO();
    
    String show = "Gasto/show.jsp";
    String edit = "Gasto/edit.jsp";
    String add = "Gasto/add.jsp";
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GastoController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GastoController at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                
        String access = "";
        String action = request.getParameter("action"); 
        
        if(action.equalsIgnoreCase("show")){
            access = show;
            
        } else if (action.equalsIgnoreCase("add")){
            access = add;
            
        } else if (action.equalsIgnoreCase("guardar")){
            // Añadir nuevos Gastos:
            // Invocar métodos para realizar las operaciones:
            // int Folio = Integer.parseInt(request.getParameter("txtFolioGasto"));
            String fechaStr = request.getParameter("txtDateGasto"); // Campo fecha
            
            // Se convierte a formato de fecha:
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); 
            Date fecha = null;
            try {
                fecha = dateFormat.parse(fechaStr);
                
            } catch (ParseException ex){
                Logger.getLogger(GastoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // Se guardan los demás datos:
            String definicion = request.getParameter("txtDefGasto");
            float importeCiva = Float.parseFloat(request.getParameter("txtCivaGasto"));
            float importeSiva = Float.parseFloat(request.getParameter("txtSivaGasto"));
            int idTipoGasto = Integer.parseInt(request.getParameter("txtidTipo"));
            String rfGerente = request.getParameter("txtGerente");
            
            // Se instancian en la clase Gasto:           
            //gasto.setFolio(Folio);
            gasto.setFecha(fecha);
            gasto.setDefinicion(definicion);
            gasto.setImporteCiva(importeCiva);
            gasto.setImporteSinva(importeSiva);
            gasto.setIdTipoGasto(idTipoGasto);
            gasto.setRfGerente(rfGerente);
            
            // Se ejecuta el método para añadir nuevos elementos:
            gDAO.add(gasto);
            // Se redirige a la vista:
            access = show;
            
        } else if (action.equalsIgnoreCase("edit")){
            // Obtener la información de request:
            request.setAttribute("folGast", request.getParameter("folGast")); // <-- DUDA!!!
            // Redirigir a la vista:
            access = edit;
           
          // Editar  
        } else if (action.equalsIgnoreCase("Editar")){
            
            String fechaStr = request.getParameter("txtDateGasto"); // Campo fecha
            
            // Se convierte a formato de fecha:
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); 
            Date fecha = null;
            try {
                fecha = dateFormat.parse(fechaStr);
                
            } catch (ParseException ex){
                Logger.getLogger(GastoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // Se guardan los demás datos:
            // Se pueden modificar los nombres de los campos:
            String definicion = request.getParameter("txtDefGasto");
            float importeCiva = Float.parseFloat(request.getParameter("txtCivaGasto"));
            float importeSiva = Float.parseFloat(request.getParameter("txtSivaGasto"));
            int idTipoGasto = Integer.parseInt(request.getParameter("txtidTipo"));
            String rfGerente = request.getParameter("txtGerente");
            
            gasto.setFecha(fecha);
            gasto.setDefinicion(definicion);
            gasto.setImporteCiva(importeCiva);
            gasto.setImporteSinva(importeSiva);
            gasto.setIdTipoGasto(idTipoGasto);
            gasto.setRfGerente(rfGerente);
            
            // Se realiza la operación:
            gDAO.edit(gasto);
            // Se redirige a la vista:
            access = show;
            
            // Eliminar productos:
        } else if (action.equalsIgnoreCase("delete")){
            // Invocar métodos para eliminación de productos:
            int folioGast = Integer.parseInt(request.getParameter("folGast"));
            // Se instancian los valores en el modelo:
            gasto.setFolio(folioGast);
            // Se ejecuta la consulta para elminar producto:
            gDAO.delete(folioGast);
            // Se redirige la vista:
            access = show;           
        }
        
        RequestDispatcher view = request.getRequestDispatcher(access);
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
