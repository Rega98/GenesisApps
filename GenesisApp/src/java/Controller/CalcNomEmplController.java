/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CatNomina;
import Model.Empleado;
import Model.Vale;
import ModelDAO.CatNominaDAO;
import ModelDAO.ContratoDAO;
import ModelDAO.EmpleadoDAO;
import ModelDAO.PagoDAO;
import ModelDAO.ValeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adolfo Meza Romero
 */
public class CalcNomEmplController extends HttpServlet {

    Empleado empl = new Empleado();
    EmpleadoDAO empDAO = new EmpleadoDAO();
    CatNomina nomina = new CatNomina();
    CatNominaDAO nominaDAO = new CatNominaDAO();
    ContratoDAO contrDAO = new ContratoDAO();
    PagoDAO pagoDAO = new PagoDAO();
    Vale vale = new Vale();
    ValeDAO valDAO = new ValeDAO();
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
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String access = "";
        String show = "CatNomina/showEmpl.jsp";
        String add = "CatNomina/calculate.jsp";
        String details = "CatNomina/report.jsp";
        try {
            String action = request.getParameter("action");
            if(action.equalsIgnoreCase("showEmpl")){
                access = show;
            }else if(action.equalsIgnoreCase("calcular")){
                access = add;
                request.setAttribute("rfcEmpl", request.getParameter("rfc"));
            }else if(action.equalsIgnoreCase("Generar")){
                // Aquí se pueden invocar metodos para realizar operaciones
                String rfc = request.getParameter("txtRfcEmpl");
                //Valor numerico del mes (enero = 1, Febrero = 2, Marzo = 3, ...)
                int mes = Integer.parseInt(request.getParameter("txtMesNomina"));
                //Valor numerico del año (2019, 2020, 2021, etc...)
                int anio = Integer.parseInt(request.getParameter("txtAnioNomina"));
                //Si es la primera quincena del mes, el simbolo es '<'. Si es la segunda quincena del mes,el signo es '>' 
                String signo = request.getParameter("txtQincena");
                nomina.setFecha(dateFormat.parse(dateFormat.format(new Date())));
                nomina.setMesAnio(transformaMes(mes)+" "+anio);
                nomina.setPeriodo((signo.equals("<"))?"Primera Quincena":"Segunda Quincena");
                nomina.setRfcEmpleado(rfc);
                empl = empDAO.details(rfc);
                Float montoTotal = 0.0f;
                if(empl.getTipo().equals("Vendedor")){
                    Float sumComiciones = contrDAO.getGananciaByQuincena(rfc, mes, anio, signo);
                    Float sumPrestamos = valDAO.getMontoByQuincena(rfc, mes, anio, signo);
                    montoTotal = sumComiciones - sumPrestamos;
                    if(montoTotal < 0.0f){
                        nomina.setMonto(0.0f);
                        if(nominaDAO.add(nomina)) {
                            //Registra la perdida obtenida como valor absoluto
                            vale.setMonto(Math.abs(montoTotal));
                            vale.setConcepto("Adeudo Originado de la Nomina");
                            vale.setRfcVendedor(rfc);
                            if(signo.equals("<")){ 
                                //Si el calculo es de la primera quincena, genera el vale para la siguente quincena del mes
                                vale.setFechaVale(dateFormat.parse(anio + "-" + mes + "-16"));
                            } else if(signo.equals(">")) { 
                                //Si el calculo es de la segunda quincena, genera el vale para el siguinete mes
                                if(mes<12){ 
                                    //Si el mes no es diciembre
                                    vale.setFechaVale(dateFormat.parse(anio + "-" + (mes+1) + "-1"));
                                } else { 
                                    //Si es diciembre cambialo a enero de año siguiente
                                    vale.setFechaVale(dateFormat.parse((anio+1) + "-1-1"));
                                }
                            }
                            if(valDAO.add(vale)) {
                                access = details;
                            }
                        }
                    } else {
                        nomina.setMonto(montoTotal);
                        if(nominaDAO.add(nomina)) {
                            access = details;
                        }
                    }
                } else if(empl.getTipo().equals("Cobrador")){
                    //El valor puede ser 10, 11, 12 o 13
                    String comision = request.getParameter("txtComisionCobr");
                    montoTotal = pagoDAO.getMontoByQuincena(rfc, comision, mes, anio, signo);
                    nomina.setMonto(montoTotal);
                    if(nominaDAO.add(nomina)){
                        access = details;
                    }
                }
                request.setAttribute("RFCEmpl", rfc);
                request.setAttribute("MesNomina", ""+mes+"");
                request.setAttribute("AnioNomina", ""+anio+"");
                request.setAttribute("MesAnioTexto", transformaMes(mes)+" "+anio);
                request.setAttribute("Quincena", signo);
                request.setAttribute("Total", ""+montoTotal+"");
            } 
            RequestDispatcher view = request.getRequestDispatcher(access);
            view.forward(request, response);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    String transformaMes(int mes){
        String txtMes = "";
        switch(mes){
            case 1: txtMes = "Enero"; break;
            case 2: txtMes = "Febrero"; break;
            case 3: txtMes = "Marzo"; break;
            case 4: txtMes = "Abril"; break;
            case 5: txtMes = "Mayo"; break;
            case 6: txtMes = "Junio"; break;
            case 7: txtMes = "Julio"; break;
            case 8: txtMes = "Agosto"; break;
            case 9: txtMes = "Septiembre"; break;
            case 10: txtMes = "Octubre"; break;
            case 11: txtMes = "Novimebre"; break;
            case 12: txtMes = "Diciembre"; break;
        }
        return txtMes;  
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
