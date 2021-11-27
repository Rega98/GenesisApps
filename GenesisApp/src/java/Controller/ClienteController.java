/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Cliente;
import ModelDAO.ClienteDAO;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Adolfo Meza Romero
 */
public class ClienteController extends HttpServlet {
    /**
    * Object cliente. Represents a new or an existent Client.
    */
    Cliente cliente = new Cliente();
    /**
    * Object clienteDAO. Allows do operations in the Clients Data.
    */
    ClienteDAO clienteDAO = new ClienteDAO();
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
        String show = "Cliente/show.jsp";
        String add = "Cliente/add.jsp";
        String edit = "Cliente/edit.jsp";
        try {
            String action = request.getParameter("action");
            if(action.equalsIgnoreCase("show")){
                access = show;
            }else if(action.equalsIgnoreCase("add")){
                access = add;
            }else if(action.equalsIgnoreCase("edit")){
                // Se obtiene la info del request
                request.setAttribute("rfcCli", request.getParameter("rfc"));
                // Se redirige a la vista
                access = edit;
            }else if(action.equalsIgnoreCase("Guardar") || action.equalsIgnoreCase("Editar")){
                // Aquí se pueden invocar metodos para realizar operaciones
                String rfc = request.getParameter("txtRfcCli");
                String nombre = request.getParameter("txtNomCli");
                String appP = request.getParameter("txtAppPCli");
                String appM = request.getParameter("txtAppMCli");
                String direccion = request.getParameter("txtDirCli");
                String telefono = request.getParameter("txtTelCli");
                String correo = request.getParameter("txtCorreoCli");
                cliente.setRfc(rfc);
                cliente.setNombre(nombre);
                cliente.setApPaterno(appP);
                cliente.setApMaterno(appM);
                cliente.setDireccion(direccion);
                cliente.setTelefono(telefono);
                cliente.setCorreo(correo);
                // Se le pasa el objeto para realizar la operación
                if(action.equalsIgnoreCase("Guardar")){
                    if(clienteDAO.add(cliente)){
                        access = show;
                    }
                } else if(action.equalsIgnoreCase("Editar")){
                    if(clienteDAO.edit(cliente)){
                        access = show;
                    }
                }
            } else if(action.equalsIgnoreCase("delete")){
                // Aquí se pueden invocar metodos para realizar operaciones
                String rfc = request.getParameter("rfc");
                // Se instancia los valores (despues de x proceso realizado)
                cliente.setRfc(rfc);
                // Se le pasa el objeto para realizar la operación
                if(clienteDAO.delete(rfc)){
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
