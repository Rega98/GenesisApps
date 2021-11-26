/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CatNomina;
import ModelDAO.CatNominaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Oscar C.Rico
 */
public class CatNominaController extends HttpServlet {

    CatNomina catNomi = new CatNomina();
    CatNominaDAO catnominaDAO = new CatNominaDAO();

    String show = "CatNomina/show.jsp";
    String add = "CatNomina/add.jsp";
    String edit = "CatNomina/edit.jsp";

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
            out.println("<title>Servlet CatNominaController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CatNominaController at " + request.getContextPath() + "</h1>");
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
            // Aquí se pueden invocar metodos para realizar operaciones:
            int folio = Integer.parseInt(request.getParameter("txtFolio_CatNomina"));
            //aqui va el de la fecha
            //aqui va el del mes
            String periodo = request.getParameter("txtPeriodo_CatNomina");
            float monto = Float.parseFloat(request.getParameter("txtMonto_CatNomina"));
            String rfcEmp = request.getParameter("txtRfcEmp_CatNomina");

            // Se instancia los valores (despues de x proceso realizado)
            catNomi.setFolio(folio);
            //catnomina.setFecha(fecha);
            //catnomina.setMesAnio(mesAnio);
            catNomi.setPeriodo(periodo);
            catNomi.setMonto(monto);
            catNomi.setRfcEmpleado(rfcEmp);

            //Se le pasa el objeto de CatNominaDAO a  CatNomina
            catnominaDAO.add(catNomi);
            // Se redirige a la vista
            access = show;
        } else if (action.equalsIgnoreCase("edit")) {
            // Se obtiene la info del request
            request.setAttribute("", request.getParameter(""));
            // Se redirige a la vista
            access = edit;
        } else if (action.equalsIgnoreCase("Editar")) {
            // Aquí se pueden invocar metodos para realizar operaciones:
            int folio = Integer.parseInt(request.getParameter("txtFolio_CatNomina"));
            //aqui va el de la fecha
            //aqui va el del mes
            String periodo = request.getParameter("txtPeriodo_CatNomina");
            float monto = Float.parseFloat(request.getParameter("txtMonto_CatNomina"));
            String rfcEmp = request.getParameter("txtRfcEmp_CatNomina");
            // Se instancia los valores (despues de x proceso realizado)
            catNomi.setFolio(folio);
            //catnomina.setFecha(fecha);
            //catnomina.setMesAnio(mesAnio);
            catNomi.setPeriodo(periodo);
            catNomi.setMonto(monto);
            catNomi.setRfcEmpleado(rfcEmp);
            // Se le pasa el objeto para realizar la operación
            catnominaDAO.edit(catNomi);
            // Se redirige a la vista
            access = show;
        } else if (action.equalsIgnoreCase("delete")) {
            int idFolio = Integer.parseInt(request.getParameter("idFolio"));
            catNomi.setFolio(idFolio);
            catnominaDAO.delete(idFolio);
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
