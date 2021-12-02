/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Vale;
import ModelDAO.ValeDAO;
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
 * @author Samuel
 * Oscar C.Rico
 */
public class ValeController extends HttpServlet {

    Vale vale = new Vale();
    ValeDAO valeDAO = new ValeDAO();

    String show = "Vale/show.jsp";
    String add = "Vale/add.jsp";
    String edit = "Vale/edit.jsp";

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
            out.println("<title>Servlet ValeController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ValeController at " + request.getContextPath() + "</h1>");
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
        if (action.equalsIgnoreCase("show")) {
            access = show;
        } else if (action.equalsIgnoreCase("add")) {
            access = add;
        } else if (action.equalsIgnoreCase("Guardar")) {
            // Aquí se pueden invocar metodos para realizar operaciones
            float monto = Float.parseFloat(request.getParameter("txtMonto"));
            String fechavale = request.getParameter("txtdatevale");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            Date fecha = null;
            try {
                fecha = dateFormat.parse(fechavale);

            } catch (ParseException ex) {
                Logger.getLogger(ValeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            String concepto = request.getParameter("txtConcepto");
            String rfcvendedor = request.getParameter("txtrfcVendedor");
            vale.setMonto(monto);
            vale.setFechaVale(fecha);
            vale.setConcepto(concepto);
            vale.setRfcVendedor(rfcvendedor);
            valeDAO.add(vale);
            access = show;
        } else if (action.equalsIgnoreCase("edit")) {
            request.setAttribute("folio", request.getParameter("folio")); //Duda
            // Se redirige a la vista
            access = edit;
        } else if (action.equalsIgnoreCase("Editar")) {
            // Aquí se pueden invocar metodos para realizar operaciones
            int folio = Integer.parseInt(request.getParameter("txtFolio"));
            float monto = Float.parseFloat(request.getParameter("txtMonto"));
            String fechavale = request.getParameter("txtdatevale");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            Date fecha = null;
            try {
                fecha = dateFormat.parse(fechavale);

            } catch (ParseException ex) {
                Logger.getLogger(ValeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            String concepto = request.getParameter("txtConcepto");
            String rfcvendedor = request.getParameter("txtrfcVendedor");
            System.out.print(folio);
            System.out.print(monto);
            System.out.print(fecha);
            System.out.print(concepto);
            System.out.print(rfcvendedor);
            vale.setFolio(folio);
            vale.setMonto(monto);
            vale.setFechaVale(fecha);
            vale.setConcepto(concepto);
            vale.setRfcVendedor(rfcvendedor);
            valeDAO.edit(vale);
            access = show;
        } else if (action.equalsIgnoreCase("delete")) {
            int folio = Integer.parseInt(request.getParameter("folio"));
            vale.setFolio(folio);
            valeDAO.delete(folio);
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
