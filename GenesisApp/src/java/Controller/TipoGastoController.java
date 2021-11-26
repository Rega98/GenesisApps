package Controller;

import Model.TipoGasto;
import ModelDAO.TipoGastoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Samuel
 */
@WebServlet(name = "TipoGastoController", urlPatterns = {"/TipoGastoController"})
public class TipoGastoController extends HttpServlet {

     TipoGasto tipga = new TipoGasto();
    TipoGastoDAO tipgdao = new TipoGastoDAO();
    
    String show = "TipoGasto/show.jsp";
    String add  = "TipoGasto/add.jsp";
    String edit = "TipoGasto/edit.jsp";
    /**
    
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
            out.println("<title>Servlet TipoGastoController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TipoGastoController at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
    
         String access = "";
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("show")){
            access = show;
        }else if(action.equalsIgnoreCase("add")){
            access = add;
         }else if(action.equalsIgnoreCase("Guardar")){
            // Aquí se pueden invocar metodos para realizar operaciones
            
            String des = request.getParameter("txtDesTipoGast");
            String tipo = request.getParameter("txtTipoTGast");    
            
            

           tipga.setDescripcion(des);
           tipga.setTipo(tipo);
            
           tipgdao.add(tipga);
           
           access = show;
           }else if(action.equalsIgnoreCase("edit")){
            // Se obtiene la info del request
            request.setAttribute("idTipg", request.getParameter("idTipg"));
            // Se redirige a la vista
            access = edit;
        }else if(action.equalsIgnoreCase("Editar")){
            // Aquí se pueden invocar metodos para realizar operaciones
           
            String des = request.getParameter("txtDesTipoGast");
            String tipo = request.getParameter("txtTipoTGast");
           
            
            tipga.setDescripcion(des);
            tipga.setTipo(tipo);
           
            // Se le pasa el objeto para realizar la operación
            tipgdao.edit(tipga);
            // Se redirige a la vista
            access = show;
        }else if(action.equalsIgnoreCase("delete")){
            // Aquí se pueden invocar metodos para realizar operaciones
            int id = Integer.parseInt(request.getParameter("id"));
            // Se instancia los valores (despues de x proceso realizado)
            tipga.setId(id);
            // Se le pasa el objeto para realizar la operación
            tipgdao.delete(id);
            // Se redirige a la vista
            access = show;
        }
        
        RequestDispatcher view = request.getRequestDispatcher(access);
        view.forward(request, response);
        
           
           
           
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