<%-- 
    Document   : report
    Created on : 30/11/2021, 02:07:30 PM
    Author     : Adolfo Meza Romero
--%>

<%@page import="Model.Pago"%>
<%@page import="ModelDAO.PagoDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="ModelDAO.ValeDAO"%>
<%@page import="Model.Vale"%>
<%@page import="java.util.List"%>
<%@page import="Model.Contrato"%>
<%@page import="ModelDAO.ContratoDAO"%>
<%@page import="Model.Empleado"%>
<%@page import="ModelDAO.EmpleadoDAO"%>
<%@ include file = "../header.jsp" %>
<%
    String rfc = (String) request.getAttribute("RFCEmpl");
    int mes = Integer.parseInt((String) request.getAttribute("MesNomina"));
    int anio = Integer.parseInt((String) request.getAttribute("AnioNomina"));
    String mesanio = (String) request.getAttribute("MesAnioTexto");
    String signo = (String) request.getAttribute("Quincena");
    String quincena = (signo.equals("<"))?"Primera Quincena":"Segunda Quincena";
    Float total = Float.parseFloat((String) request.getAttribute("Total"));
    
    EmpleadoDAO edao = new EmpleadoDAO();
    Empleado empl = (Empleado) edao.details(rfc);
    ContratoDAO cDAO = new ContratoDAO();
    ValeDAO vDAO = new ValeDAO();
    PagoDAO pDAO = new PagoDAO();
%>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row mb-3">
        <div class="col-10">
            <h3><%=empl.getRfc()%> - <%=empl.getNombre()%> <%=empl.getApPaterno()%> <%=empl.getApMaterno()%></h3>
            <h4>Nomina de la <%=quincena%> de <%=mesanio%></h4>
        </div>
    </div>
    <%
        if(empl.getTipo().equals("Vendedor")){
            List<Contrato> contratoList = cDAO.showByQuincena(rfc, mes, anio, signo);
            Iterator<Contrato> contratoIter = contratoList.iterator();
            List<Vale> valeList = vDAO.showByQuincena(rfc, mes, anio, signo);
            Iterator<Vale> valeIter = valeList.iterator();
    %>
    <div class="row">
        <h4>Contratos vendidos en la quincena</h4>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Folio</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Enganche</th>
                    <th scope="col">Subtotal</th>
                    <th scope="col">IVA</th>
                    <th scope="col">Total</th>
                    <th scope="col">Comision</th>
                </tr>
            </thead>
            <tbody>
            <%
                Contrato contr = null;
                while (contratoIter.hasNext()) {
                    contr = contratoIter.next();
            %>
                <tr>
                    <th><%= contr.getFolio()%></th>
                    <td><%= contr.getFechaContrato()%></td>
                    <td><%= contr.getEnganche()%></td>
                    <td><%= contr.getSubtotal()%></td>
                    <td><%= contr.getIva()%></td>
                    <td><%= contr.getTotal()%></td>
                    <td><%= (contr.getTotal())*.10 %></td>
                </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
    <div class="row">
        <h4>Vales eitidos en la quincena</h4>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Folio</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Concepto</th>
                    <th scope="col">Monto</th>
                </tr>
            </thead>
            <tbody>
            <%
                Vale val = null;
                while (valeIter.hasNext()) {
                    val = valeIter.next();
            %>
                <tr>
                    <th><%= val.getFolio()%></th>
                    <td><%= val.getFechaVale()%></td>
                    <td><%= val.getConcepto()%></td>
                    <td><%= val.getMonto()%></td>
                </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
    <%
        } else if(empl.getTipo().equals("Cobrador")) {
            List<Pago> pagpList = pDAO.showByQuincena(rfc, mes, anio, signo);
            Iterator<Pago> pagoIter = pagpList.iterator();
    %>
    <div class="row">
        <h4>Pagos cobrados en la quincena</h4>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Folio</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Contrato</th>
                    <th scope="col">Monto</th>
                </tr>
            </thead>
            <tbody>
            <%
                Pago pago = null;
                while (pagoIter.hasNext()) {
                    pago = pagoIter.next();
            %>
                <tr>
                    <th><%= pago.getFolio()%></th>
                    <td><%= pago.getFecha()%></td>
                    <td><%= pago.getContratofolio()%></td>
                    <td><%= pago.getMonto()%></td>
                </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
    <%
        }
    %>
    <div class="row">
        <div class="col-10">
            Total: <%= total %>
            <%
            if(total<0){
                %>
                <hr>
                <spam>Se contará como un nuevo préstamo para la siguiente quincena.</spam>
                <%
            }
            %>
        </div>
    </div>
</div>
<%@ include file = "../footer.jsp" %>