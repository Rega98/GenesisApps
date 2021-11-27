/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Contrato;
import ModelDAO.ContratoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author IsmaelSL
 */
public class ContratoController extends HttpServlet {

    Contrato cont = new Contrato();
    ContratoDAO cdao = new ContratoDAO();
    
    String show = "Contrato/show.jsp";
    String add = "Contrato/add.jsp";
    String edit = "Contrato/edit.jsp";
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
            out.println("<title>Servlet ContratoController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ContratoController at " + request.getContextPath() + "</h1>");
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
            int fol = Integer.parseInt(request.getParameter("txtFolCont"));
            float eng = Float.parseFloat(request.getParameter("txtEngCont"));
            String pPg = request.getParameter("txtPlaCont");
            String dCo = request.getParameter("txtDiaCont");
            String edo = request.getParameter("txtEstCont");
            String fCo = request.getParameter("txtFecCont");
            float sub = Float.parseFloat(request.getParameter("txtSubCont"));
            float iva = Float.parseFloat(request.getParameter("txtIvaCont"));
            float tot = Float.parseFloat(request.getParameter("txtTotCont"));
            String rVe = request.getParameter("");///--------------------------- Pendiente
            String rCl = request.getParameter("");///--------------------------- Pendiente
            int iPr = Integer.parseInt(request.getParameter(""));///------------ Pendiente
            int iRu = Integer.parseInt(request.getParameter(""));///------------ Pendiente
            
            cont.setFolio(fol);
            cont.setEnganche(eng);
            cont.setPlanPago(pPg);
            cont.setDiaCobro(dCo);
            cont.setEstado(edo);
            // cont.setFechaContrato(); ///------------------------------------ Pendiente
            cont.setSubtotal(sub);
            cont.setIva(iva);
            cont.setTotal(tot);
            cont.setRfcVendedor(rVe);
            cont.setRfcCliente(rCl);
            cont.setIdProducto(iPr);
            cont.setIdRuta(iRu);
            
            cdao.add(cont);
            // Se redirige a la vista
            access = show;
        }else if(action.equalsIgnoreCase("edit")){
            // Se obtiene la info del request
            request.setAttribute("foCont", request.getParameter("fo"));
            // Se redirige a la vista
            access = edit;
        }else if(action.equalsIgnoreCase("Editar")){
            // Aquí se pueden invocar metodos para realizar operaciones
            int fol = Integer.parseInt(request.getParameter("txtFolCont"));
            float eng = Float.parseFloat(request.getParameter("txtEngCont"));
            String pPg = request.getParameter("txtPlaCont");
            String dCo = request.getParameter("txtDiaCont");
            String edo = request.getParameter("txtEstCont");
            String fCo = request.getParameter("txtFecCont");
            float sub = Float.parseFloat(request.getParameter("txtSubCont"));
            float iva = Float.parseFloat(request.getParameter("txtIvaCont"));
            float tot = Float.parseFloat(request.getParameter("txtTotCont"));
            String rVe = request.getParameter("");///--------------------------- Pendiente
            String rCl = request.getParameter("");///--------------------------- Pendiente
            int iPr = Integer.parseInt(request.getParameter(""));///------------ Pendiente
            int iRu = Integer.parseInt(request.getParameter(""));///------------ Pendiente
            
            cont.setFolio(fol);
            cont.setEnganche(eng);
            cont.setPlanPago(pPg);
            cont.setDiaCobro(dCo);
            cont.setEstado(edo);
            // cont.setFechaContrato(); ///------------------------------------ Pendiente
            cont.setSubtotal(sub);
            cont.setIva(iva);
            cont.setTotal(tot);
            cont.setRfcVendedor(rVe);
            cont.setRfcCliente(rCl);
            cont.setIdProducto(iPr);
            cont.setIdRuta(iRu);
            // Se le pasa el objeto para realizar la operación
            cdao.edit(cont);
            // Se redirige a la vista
            access = show;
        }else if(action.equalsIgnoreCase("delete")){
            // Aquí se pueden invocar metodos para realizar operaciones
            int fo = Integer.parseInt(request.getParameter("fo"));
            // Se instancia los valores (despues de x proceso realizado)
            cont.setFolio(fo);
            // Se le pasa el objeto para realizar la operación
            cdao.delete(fo);
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
