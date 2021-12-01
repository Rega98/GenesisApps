/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Observacion;
import ModelDAO.ObservacionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author blanc
 */
@WebServlet(name = "ObservacionController", urlPatterns = {"/ObservacionController"})
public class ObservacionController extends HttpServlet {
    
    Observacion observ = new Observacion();
    ObservacionDAO obsdao = new ObservacionDAO();
    
    String show = "Observacion/show.jsp";
    String add = "Observacion/add.jsp";
    String edit = "Observacion/edit.jsp";

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ObservacionController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ObservacionController at " + request.getContextPath() + "</h1>");
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
            //processRequest(request, response);
            
            String access = "";
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("show")){
            access = show;
        } else if(action.equalsIgnoreCase("add")){
            access = add;
        } else if(action.equalsIgnoreCase("Guardar")){
            
            // Aquí se pueden invocar metodos para realizar operaciones
            String fechaC = request.getParameter("txtFechaobserv");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = null;
            try {
                fecha = dateFormat.parse(fechaC);
            } catch (ParseException ex) {
                Logger.getLogger(CompraController.class.getName()).log(Level.SEVERE, null, ex);
            }
            String obser = request.getParameter("txtobserobserv");
            //int contraF = Integer.parseInt(request.getParameter("txtContratFobserv"));
            
            // Se instancia los valores (despues de x proceso realizado)
            observ.setFecha(fecha);
            observ.setObservacion(obser);
            //observ.setContratofolio(contraF);
            
            // Se le pasa el objeto para realizar la operación
            obsdao.add(observ);
            // Se redirige a la vista
            access = show;
        } else if(action.equalsIgnoreCase("edit")){ //checar vista 
            // Se obtiene la info del request
            request.setAttribute("Id", request.getParameter("Id"));
            // Se redirige a la vista
            access = edit;
        } else if(action.equalsIgnoreCase("Editar")){
            // Aquí se pueden invocar metodos para realizar operaciones
            int id = Integer.parseInt(request.getParameter("txtIdObs"));
            String fechaC = request.getParameter("txtFechaobserv");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = null;
            try {
                fecha = dateFormat.parse(fechaC);
            } catch (ParseException ex) {
                Logger.getLogger(CompraController.class.getName()).log(Level.SEVERE, null, ex);
            }
            String obser = request.getParameter("txtobserobserv");
            //int contraF = Integer.parseInt(request.getParameter("txtContratFobserv"));
            // Se instancia los valores (despues de x proceso realizado)
            observ.setId(id);
            observ.setFecha(fecha);
            observ.setObservacion(obser);
            //observ.setContratofolio(contraF);
            // Se le pasa el objeto para realizar la operación
            obsdao.edit(observ);

            // Se redirige a la vista
            access = show;
        } else if(action.equalsIgnoreCase("delete")){
            // Aquí se pueden invocar metodos para realizar operaciones
            int id = Integer.parseInt(request.getParameter("Id"));
            // Se instancia los valores (despues de x proceso realizado)
            observ.setId(id);
            // Se le pasa el objeto para realizar la operación
            obsdao.delete(id);
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
