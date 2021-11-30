<%-- 
    Document   : show
    Created on : 30 nov. 2021, 02:22:22
    Author     : bardo_3u8azdb
--%>
<%@page import="Model.CatNomina"%>
<%@page import="ModelDAO.CatNominaDAO"%>
<%@page import="Model.Empleado"%>
<%@page import="ModelDAO.EmpleadoDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ include file = "../header.jsp" %>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row">
        <div>
            <h3>Nueva CatNomina</h3>
        </div>
    </div>
    <div class="row">
        <form action="CatNominaController">
            <div class="row my-3">
                <div class="col-3">
                    <label for="txtFolio" class="form-label">Folio</label>
                    <input type="number" class="form-control" name="txtFolio" required>
                </div>
                <div class="col-3">
                    <label for="txtFecha" class="form-label">Fecha</label>
                    <input type="date" class="form-control" name="txtFecha" required>
                </div>
                <div class="col-6">
                    <label for="txtMesAnio" class="form-label">Mes Año</label>
                    <input type="text" class="form-control" name="txtMesAnio" required>
                </div>
               
            </div>
            <div class="row my-3">
                 <div class="col-3">
                    <label for="txtPeri" class="form-label">Periodo</label>
                    <input type="text" class="form-control" name="txtPeri" required>
                </div>
                <div class="col-3">
                    <label for="txtMont" class="form-label">Monto</label>
                    <input type="number" class="form-control" name="txtMont" required>
                </div>
                <div class="col-6">
                    <label for="txtEmp" class="form-label">RFC Empleado</label>
                    <select class="form-select" aria-label="Default select example" name="txtEmp">
                            <option selected disabled>Selecciona un Empleado</option>
                            <%
                            EmpleadoDAO edao = new EmpleadoDAO();
                            List<Empleado> list = edao.show();
                            Iterator<Empleado> iter = list.iterator();
                            Empleado emp = null;
                            while(iter.hasNext()){
                                emp = iter.next();
                            %>
                            <option value="<%= emp.getRfc()%>"><%= emp.getNombre()%></option>
                            <%
                            }
                            %>
                        </select>
                </div>
            </div>
            <div class="row mt-5">
                <div class="col-8"></div>
                <div class="col-2">
                    <input type="submit" name="action" class="btn btn-primary px-5" value="Guardar" />
                </div>
                <div class="col-2">
                    <a type="button" class="btn btn-danger px-5" href="CatNominaController?action=show">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <%@ include file = "../footer.jsp" %>
