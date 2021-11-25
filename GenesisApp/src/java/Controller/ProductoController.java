/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Producto;
import ModelDAO.ProductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author IsmaelSL
 */
@WebServlet(name = "ProductoController", urlPatterns = {"/ProductoController"})
public class ProductoController extends HttpServlet {
    
    Producto prod = new Producto();
    ProductoDAO pdao = new ProductoDAO();
    
    String show = "Productos/show.jsp";
    String add = "Productos/add.jsp";
    String edit = "Productos/edit.jsp";
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
            out.println("<title>Servlet ProductoController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductoController at " + request.getContextPath() + "</h1>");
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
            int id = Integer.parseInt(request.getParameter("txtIdProd"));
            String nom = request.getParameter("txtNomProd");
            String des = request.getParameter("txtDesProd");
            float pVe = Float.parseFloat(request.getParameter("txtPreVenProd"));
            float pCo = Float.parseFloat(request.getParameter("txtPreComProd"));
            String iva = request.getParameter("");///--------------------------- Pendiente
            int stk = Integer.parseInt(request.getParameter("txtStoProd"));
            String cat = request.getParameter("txtCatProd");
            
            prod.setId(id);
            prod.setNombre(nom);
            prod.setDescripcion(des);
            prod.setPrecioVenta(pVe);
            prod.setPrecioCompra(pCo);
            prod.setIva(true);////---------------------------------------------- Pendiente
            prod.setStock(stk);
            prod.setCategoria(cat);
            // Se le pasa el objeto para realizar la operación
            pdao.add(prod);
            // Se redirige a la vista
            access = show;
        }else if(action.equalsIgnoreCase("edit")){
            // Se obtiene la info del request
            request.setAttribute("idProd", request.getParameter("id"));
            // Se redirige a la vista
            access = edit;
        }else if(action.equalsIgnoreCase("Editar")){
            // Aquí se pueden invocar metodos para realizar operaciones
            int id = Integer.parseInt(request.getParameter("txtIdProd"));
            String nom = request.getParameter("txtNomProd");
            String des = request.getParameter("txtDesProd");
            float pVe = Float.parseFloat(request.getParameter("txtPreVenProd"));
            float pCo = Float.parseFloat(request.getParameter("txtPreComProd"));
            String iva = request.getParameter("");///--------------------------- Pendiente
            int stk = Integer.parseInt(request.getParameter("txtStoProd"));
            String cat = request.getParameter("txtCatProd");
            
            prod.setId(id);
            prod.setNombre(nom);
            prod.setDescripcion(des);
            prod.setPrecioVenta(pVe);
            prod.setPrecioCompra(pCo);
            prod.setIva(true);////---------------------------------------------- Pendiente
            prod.setStock(stk);
            prod.setCategoria(cat);
            // Se le pasa el objeto para realizar la operación
            pdao.edit(prod);
            // Se redirige a la vista
            access = show;
        }else if(action.equalsIgnoreCase("delete")){
            // Aquí se pueden invocar metodos para realizar operaciones
            int id = Integer.parseInt(request.getParameter("id"));
            // Se instancia los valores (despues de x proceso realizado)
            prod.setId(id);
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
