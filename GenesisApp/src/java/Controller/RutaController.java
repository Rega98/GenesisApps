/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Ruta;
import ModelDAO.RutaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julián Torres
 */
public class RutaController extends HttpServlet {
    
    Ruta ruta = new Ruta();
    RutaDAO rDAO = new RutaDAO();
    
    String show = "Ruta/show.jsp";
    String add = "Ruta/add.jsp";
    String edit = "Ruta/edit.jsp";

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
            out.println("<title>Servlet RutaController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RutaController at " + request.getContextPath() + "</h1>");
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
            //Añadir nuevas rutas
            //Invocar métodos para realizar las operaciones
            String desRuta = request.getParameter("txtDesRuta");
            int rutas = Integer.parseInt(request.getParameter("txtRutasRuta"));
            int contratofolio = Integer.parseInt(request.getParameter("txtContfolio"));

            ruta.setDescripcionRuta(desRuta);
            ruta.setRutas(rutas);
            ruta.setContratofolio(contratofolio);
            
            // Se envia el objeto ruta al método add de rDAO
            rDAO.add(ruta);
            // Se redirige a la vista
            access = show;
            
        } else if(action.equalsIgnoreCase("edit")){
            // Se obtiene la info del request
            request.setAttribute("idruta", request.getParameter("idruta"));
            // Se redirige a la vista
            access = edit;
            
        }else if(action.equalsIgnoreCase("Editar")){
            // Editar las rutas en la base de datos
            String desRuta = request.getParameter("txtDesRuta");
            int rutas = Integer.parseInt(request.getParameter("txtRutasRuta"));
            int contratofolio = Integer.parseInt(request.getParameter("txtContfolio"));
            
            ruta.setDescripcionRuta(desRuta);
            ruta.setRutas(rutas);
            ruta.setContratofolio(contratofolio);
            
            // Se envía el objeto ruta al método edit en rDAO
            rDAO.edit(ruta);
            // Se redirige la vista
            access = show;
        
        } else if(action.equalsIgnoreCase("delete")){
            // Aquí se pueden invocar metodos para realizar operaciones
            int id = Integer.parseInt(request.getParameter("id"));
            // Se instancia los valores (despues de x proceso realizado)
            ruta.setIdRuta(id);
            // Se le pasa el objeto para realizar la operación
            rDAO.delete(id);
            // Se redirige a la vista
            access = show; }

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
