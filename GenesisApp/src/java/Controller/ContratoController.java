/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Contrato;
import Model.Vale;
import ModelDAO.ContratoDAO;
import ModelDAO.ValeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
 * @author IsmaelSL
 */
public class ContratoController extends HttpServlet {

    Contrato cont = new Contrato();
    ContratoDAO cdao = new ContratoDAO();
    
    String show = "Contrato/show.jsp";
    String add = "Contrato/add.jsp";
    String details = "Contrato/details.jsp";
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
        }else if(action.equalsIgnoreCase("Continuar")){
            String idCl = request.getParameter("cbxIdCli");
            String idVe = request.getParameter("cbxIdVed");
            String idPr = request.getParameter("cbxIdPro");
           
            request.setAttribute("idCl", idCl);
            request.setAttribute("idVe", idVe);
            request.setAttribute("idPr", idPr);

            access = details;
        }else if(action.equalsIgnoreCase("Guardar")){
            
            String rfcCli = request.getParameter("txtRfcCli");
            String rfcVen = request.getParameter("txtRfcVen");
            int idProd = Integer.parseInt(request.getParameter("txtIdPro"));
            
            String plaPag = request.getParameter("txtPlaCon");
            String diaPag = request.getParameter("txtDiaCon");
            float enganc = Float.parseFloat(request.getParameter("numEngaCon"));
            float subTot = Float.parseFloat(request.getParameter("numSubCon"));  
            float iva = Float.parseFloat(request.getParameter("numIvaCon")); 
            float total = Float.parseFloat(request.getParameter("numTotCon"));
            
            cont.setEnganche(enganc);
            cont.setPlanPago(plaPag);
            cont.setDiaCobro(diaPag);
            cont.setEstado("Nuevo");
            
            String f = LocalDate.now().toString();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = null;
            try {
                fecha = dateFormat.parse(f);
            } catch (ParseException ex) {
                Logger.getLogger("Erroooor: ---"+ContratoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            cont.setFechaContrato(fecha);
            cont.setSubtotal(subTot);
            cont.setIva(iva);
            cont.setTotal(total);
            cont.setRfcVendedor(rfcVen);
            cont.setRfcCliente(rfcCli);
            cont.setIdProducto(idProd);
            cdao.add(cont);            

            if(enganc>(total*0.10)){
                Vale val = new Vale();
                ValeDAO vdao = new ValeDAO();
                
                val.setFechaVale(fecha);
                val.setMonto((float) (enganc - (total*0.10)));
                System.out.println("Ultimo folio guardado: "+cdao.BuscarXCampos());
                val.setConcepto(""+cdao.BuscarXCampos()+"");
                val.setRfcVendedor(rfcVen);
                
                vdao.add(val);
            }
            
            // Se redirige a la vista
            access = show;
        }else if(action.equalsIgnoreCase("edit")){
            // Se obtiene la info del request
            request.setAttribute("folio", request.getParameter("folio"));
            // Se redirige a la vista
            access = edit;
        }else if(action.equalsIgnoreCase("Editar")){
            // Aquí se pueden invocar metodos para realizar operaciones
            int fol = Integer.parseInt(request.getParameter("txtFolCont"));
            String edo = request.getParameter("cbxEdoCon");
            
            cont.setFolio(fol);
            cont.setEstado(edo);

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
