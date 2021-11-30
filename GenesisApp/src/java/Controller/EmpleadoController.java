/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Empleado;
import ModelDAO.EmpleadoDAO;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Adolfo Meza Romero
 */
public class EmpleadoController extends HttpServlet {
    /**
    * Object empleado. Represents a new or an existent Employee.
    */
    Empleado empleado = new Empleado();
    /**
    * Object empleadoDAO. Allows do operations in the Employees Data.
    */
    EmpleadoDAO empleadoDAO = new EmpleadoDAO();
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
        String access = "";
        String show = "Empleado/show.jsp";
        String add = "Empleado/add.jsp";
        String edit = "Empleado/edit.jsp";
        try {
            String action = request.getParameter("action");
            if(action.equalsIgnoreCase("show")){
                access = show;
            }else if(action.equalsIgnoreCase("add")){
                access = add;
            }else if(action.equalsIgnoreCase("edit")){
                // Se obtiene la info del request
                request.setAttribute("rfcEmpl", request.getParameter("rfc"));
                // Se redirige a la vista
                access = edit;
            }else if(action.equalsIgnoreCase("Guardar") || action.equalsIgnoreCase("Editar")){
                // Aquí se pueden invocar metodos para realizar operaciones
                String rfc = request.getParameter("txtRfcEmpl");
                String nombre = request.getParameter("txtNomEmpl");
                String appP = request.getParameter("txtAppPEmpl");
                String appM = request.getParameter("txtAppMEmpl");
                String usuario = request.getParameter("txtUsrEmpl");
                String password = request.getParameter("txtPassEmpl");
                String tipo = request.getParameter("txtTipoEmpl");
                empleado.setRfc(rfc);
                empleado.setNombre(nombre);
                empleado.setApPaterno(appP);
                empleado.setApMaterno(appM);
                empleado.setUser(usuario);
                empleado.setPass(password);
                empleado.setTipo(tipo);
                // Se le pasa el objeto para realizar la operación
                if(action.equalsIgnoreCase("Guardar")){
                    if(empleadoDAO.add(empleado)){
                        access = show;
                    }
                } else if(action.equalsIgnoreCase("Editar")){
                    if(empleadoDAO.edit(empleado)){
                        access = show;
                    }
                }
            } else if(action.equalsIgnoreCase("delete")){
                // Aquí se pueden invocar metodos para realizar operaciones
                String rfc = request.getParameter("rfc");
                // Se instancia los valores (despues de x proceso realizado)
                empleado.setRfc(rfc);
                // Se le pasa el objeto para realizar la operación
                if(empleadoDAO.delete(rfc)){
                    access = show;
                }
            }
            RequestDispatcher view = request.getRequestDispatcher(access);
            view.forward(request, response);
        } catch(Exception e) {
            System.out.println(e.getMessage());
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
