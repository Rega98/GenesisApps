<%-- 
    Document   : error
    Created on : 2/12/2021, 03:18:18 AM
    Author     : Adolfo Meza Romero
--%>

<%@page import="Model.Empleado"%>
<%@page import="ModelDAO.EmpleadoDAO"%>
<%@ include file = "../header.jsp" %>
<%
    String rfc = (String) request.getAttribute("RFCEmpl");
    String mesanio = (String) request.getAttribute("MesAnioTexto");
    String signo = (String) request.getAttribute("Quincena");
    String quincena = (signo.equals("<"))?"Primera Quincena":"Segunda Quincena";
    
    EmpleadoDAO edao = new EmpleadoDAO();
    Empleado empl = (Empleado) edao.details(rfc);
%>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row mb-3">
        <div class="col-10">
            <h3>ERROR</h3>
            <h4>La Nomina de la <%=quincena%> de <%=mesanio%> de: </h4>
            <h4>    <%=empl.getRfc()%> - <%=empl.getNombre()%> <%=empl.getApPaterno()%> <%=empl.getApMaterno()%></h4>
            <h4>ya fue Calculada</h4>
        </div>
    </div>
    <div class="row mt-5">
        <div class="col-5"></div>
        <div class="col-2">
            <a type="button" class="btn btn-primary px-5" href="CalcNomEmplController?action=showEmpl">Volver</a>
        </div>
        <div class="col-5"></div>
    </div>
</div>
<%@ include file = "../footer.jsp" %>
