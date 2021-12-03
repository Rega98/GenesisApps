<%-- 
    Document   : show
    Created on : 28 nov. 2021, 01:17:00
    Author     : bardo_3u8azdb
--%>
<%@page import="Model.Empleado"%>
<%@page import="ModelDAO.EmpleadoDAO"%>
<%@page import="Model.Proveedor"%>
<%@page import="Model.TipoGasto"%>
<%@page import="ModelDAO.TipoGastoDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>

<%@ include file = "../header.jsp" %>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row">
        <div>
            <h3>Gasto Nuevo</h3>
        </div>
    </div>
    <div class="row">
        <form action="GastoController">
            <div class="row my-3">
                <div class="col-3">
                    <label for="txtFecha" class="form-label">Fecha</label>
                    <input type="date" class="form-control" name="txtDateGasto" required>
                </div>
                <div class="col-6">
                    <label for="txtDef" class="form-label">Definicion</label>
                    <input type="text" class="form-control" name="txtDefGasto" minlength="3" maxlength="50" title="Descripción abierta" required>
                </div>
            </div>
            <div class="row my-3">
                <div class="col-3">
                    <label for="txtImpiva" class="form-label">Importe con Iva</label>
                    <!--<input type="text" class="form-control" name="txtCivaGasto" required>-->
                    <input type="number" class="form-control" name="txtCivaGasto" required>
                </div>
                <div class="col-3">
                    <label for="txtImpsiniva" class="form-label">Importe sin Iva</label>
                    <!--<input type="text" class="form-control" name="txtSivaGasto" required>-->
                    <input type="number" class="form-control" name="txtSivaGasto" required>
                </div>
                <div class="col-3">
                    <label for="txtTipogas" class="form-label">Tipo gasto</label>
                    <select class="form-select" aria-label="Default select example" name="txtidTipo">
                            <option selected disabled>Selecciona un tipo de gasto</option>
                            <%
                             TipoGastoDAO tdao = new TipoGastoDAO();
                            List<TipoGasto> list = tdao.show();
                            Iterator<TipoGasto> iter = list.iterator();
                            TipoGasto tipo = null;
                            while(iter.hasNext()){
                                tipo = iter.next();
                            %>
                            <option value="<%= tipo.getId()%>"><%= tipo.getTipo()%></option>
                            <%
                            }
                            %>
                        </select>
                </div>
                <div class="col-3">
                    <label for="txtRfcGer" class="form-label">Rfc Gerente</label>
                    <select class="form-select" aria-label="Default select example" name="txtGerente">
                            <option selected disabled>Selecciona un gerente </option>
                            <%
                            EmpleadoDAO edao = new EmpleadoDAO();
                            List<Empleado> list2 = edao.show2();
                            Iterator<Empleado> iter2 = list2.iterator();
                            Empleado emp = null;
                            while(iter2.hasNext()){
                                emp = iter2.next();
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
                    <a type="button" class="btn btn-danger px-5" href="GastoController?action=show">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <%@ include file = "../footer.jsp" %>
