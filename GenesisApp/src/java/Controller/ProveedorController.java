/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Proveedor;
import ModelDAO.ProveedorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author IsmaSL
 */
public class ProveedorController extends HttpServlet {
    
    Proveedor prov = new Proveedor();
    ProveedorDAO pdao = new ProveedorDAO();
    
    String show = "views/show.jsp";
    String add = "views/add.jsp";
    String edit = "views/edit.jsp";
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
            out.println("<title>Servlet ProveedorController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProveedorController at " + request.getContextPath() + "</h1>");
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
        }else if(action.equalsIgnoreCase("add")){
            access = add;
        }else if(action.equalsIgnoreCase("Guardar")){
            // Aquí se pueden invocar metodos para realizar operaciones
            String nom = request.getParameter("txtNomProv");
            // Se instancia los valores (despues de x proceso realizado)
            prov.setNom(nom);
            // Se le pasa el objeto para realizar la operación
            pdao.add(prov);
            // Se redirige a la vista
            access = show;
        }else if(action.equalsIgnoreCase("edit")){
            // Se obtiene la info del request
            request.setAttribute("idProv", request.getParameter("id"));
            // Se redirige a la vista
            access = edit;
        }else if(action.equalsIgnoreCase("Editar")){
            // Aquí se pueden invocar metodos para realizar operaciones
            String id = request.getParameter("txtIdProv");
            String nom = request.getParameter("txtNomProv");
            // Se instancia los valores (despues de x proceso realizado)
            prov.setId(id);
            prov.setNom(nom);
            // Se le pasa el objeto para realizar la operación
            pdao.edit(prov);
            // Se redirige a la vista
            access = show;
        }else if(action.equalsIgnoreCase("delete")){
            // Aquí se pueden invocar metodos para realizar operaciones
            String id = request.getParameter("id");
            // Se instancia los valores (despues de x proceso realizado)
            prov.setId(id);
            // Se le pasa el objeto para realizar la operación
            pdao.delete(id);
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
