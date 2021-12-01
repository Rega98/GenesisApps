<%-- 
    Document   : calculate
    Created on : 30/11/2021, 02:07:02 PM
    Author     : Adolfo Meza Romero
--%>
<%@page import="Model.Empleado"%>
<%@page import="ModelDAO.EmpleadoDAO"%>
<%@ include file = "../header.jsp" %>
<%
    EmpleadoDAO edao = new EmpleadoDAO();
    String rfc = (String) request.getAttribute("rfcEmpl");
    Empleado empl = (Empleado) edao.details(rfc);
%>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row">
        <div>
            <h3>Calcular Nomina</h3><br>
            <h4><%=empl.getRfc()%> - <%=empl.getNombre()%> <%=empl.getApPaterno()%> <%=empl.getApMaterno()%></h4>
        </div>
    </div>
    <div class="row">
        <form action="CalcNomEmplController">
            <div class="col-6">
                <input type="hidden" class="form-control" name="txtRfcEmpl" value="<%=empl.getRfc()%>" required>
            </div>
            <div class="col-md-4">
                <label for="txtMesNomina" class="form-label">Mes</label>
                <select class="form-select" aria-label="Default select example" name="txtMesNomina" >
                    <option value="1" selected>Enero</option>
                    <option value="2">Febrero</option>
                    <option value="3">Marzo</option>
                    <option value="4">Abril</option>
                    <option value="5">Mayo</option>
                    <option value="6">Junio</option>
                    <option value="7">Julio</option>
                    <option value="8">Agosto</option>
                    <option value="9">Septimebre</option>
                    <option value="10">Octubre</option>
                    <option value="11">Noviembre</option>
                    <option value="12">Diciembre</option>
                </select>
            </div>
            <div class="col-md-4">
                <label for="txtAnioNomina" class="form-label">Año</label>
                <select class="form-select" aria-label="Default select example" name="txtAnioNomina" >
                    <option value="2026">2026</option>
                    <option value="2025">2025</option>
                    <option value="2024">2024</option>
                    <option value="2023">2023</option>
                    <option value="2022">2022</option>
                    <option value="2021" selected="">2021</option>
                    <option value="2020">2020</option>
                    <option value="2019">2019</option>
                    <option value="2018">2018</option>
                    <option value="2017">2017</option>
                    <option value="2016">2016</option>
                </select>
            </div>
            <div class="col-md-4">
                <label for="txtQincena" class="form-label">Año</label>
                <select class="form-select" aria-label="Default select example" name="txtQincena" >
                    <option value="<" selected>Primera Quincena del mes</option>
                    <option value=">">Segunda Quincean del mes</option>
                </select>
            </div>
            <%
                if(empl.getTipo().equals("Cobrador")){
            %>
            <div class="col-md-4">
                <label for="txtComisionCobr" class="form-label">Comision a considerar</label>
                <select class="form-select" aria-label="Default select example" name="txtComisionCobr" >
                    <option value="10" selected>10%</option>
                    <option value="11" selected>11%</option>
                    <option value="12" selected>12%</option>
                    <option value="13" selected>13%</option>
                </select>
            </div>
            <%
                }
            %>
            <div class="row mt-5">
                <div class="col-8"></div>
                <div class="col-2">
                    <input type="submit" name="action" class="btn btn-primary px-5" value="Generar" />
                </div>
                <div class="col-2">
                    <a type="button" class="btn btn-danger px-5" href="CatNominaController?action=show">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
<%@ include file = "../footer.jsp" %>
