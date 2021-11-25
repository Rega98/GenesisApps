/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Pago;
import ModelDAO.PagoDAO;
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
 * @author Lis
 */
// @WebServlet(name = "PagoController", urlPatterns = {"/PagoController"})
public class PagoController extends HttpServlet {
    
    Pago pag = new Pago();
    PagoDAO pgdao = new PagoDAO();
    
    String show = "Pago/show.jsp";
    String add = "Pago/add.jsp";
    String edit = "Pago/edit.jsp";

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
            out.println("<title>Servlet PagoController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PagoController at " + request.getContextPath() + "</h1>");
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
            String fechaA = request.getParameter("txtFechaPag");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = null;
            try {
                fecha = dateFormat.parse(fechaA);
            } catch (ParseException ex) {
                Logger.getLogger(PagoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            float monto = Float.parseFloat(request.getParameter("txtMontoPag"));
            int cont = Integer.parseInt(request.getParameter("txtContPag"));
            String rfcCob = request.getParameter("txtRfcPag");
            // Se instancia los valores (despues de x proceso realizado)
            pag.setFecha(fecha);
            pag.setMonto(monto);
            pag.setContratofolio(cont);
            pag.setRfcCobrador(rfcCob);
            // Se le pasa el objeto para realizar la operación
            pgdao.add(pag);
            // Se redirige a la vista
            access = show;
        } else if(action.equalsIgnoreCase("edit")){ //checar vista 
            // Se obtiene la info del request
            request.setAttribute("folio", request.getParameter("folio"));
            // Se redirige a la vista
            access = edit;
        } else if(action.equalsIgnoreCase("Editar")){
            // Aquí se pueden invocar metodos para realizar operaciones            
            String fechaA = request.getParameter("txtFechaPag");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = null;
            try {
                fecha = dateFormat.parse(fechaA);
            } catch (ParseException ex) {
                Logger.getLogger(PagoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            float monto = Float.parseFloat(request.getParameter("txtMontoPag"));
            int cont = Integer.parseInt(request.getParameter("txtContPag"));
            String rfcCob = request.getParameter("txtRfcPag");
            // Se instancia los valores (despues de x proceso realizado)
            //prov.setId(id);
            //prov.setNom(nom);
            pag.setFecha(fecha);
            pag.setMonto(monto);
            pag.setContratofolio(cont);
            pag.setRfcCobrador(rfcCob);
            // Se le pasa el objeto para realizar la operación
            pgdao.edit(pag);
            // Se redirige a la vista
            access = show;
        } else if(action.equalsIgnoreCase("delete")){
            // Aquí se pueden invocar metodos para realizar operaciones
            int folio = Integer.parseInt(request.getParameter("folio"));
            // Se instancia los valores (despues de x proceso realizado)
            pag.setFolio(folio);
            // Se le pasa el objeto para realizar la operación
            pgdao.delete(folio);
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
