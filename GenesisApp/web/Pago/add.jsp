<%-- 
    Document   : show
    Created on : 28 nov. 2021, 01:17:00
    Author     : bardo_3u8azdb
--%>
<%@page import="Model.Empleado"%>
<%@page import="ModelDAO.EmpleadoDAO"%>
<%@page import="Model.Contrato"%>
<%@page import="ModelDAO.ContratoDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>

<%@ include file = "../header.jsp" %>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row">
        <div>
            <h3>Pago Nuevo</h3>
        </div>
    </div>
    <div class="row">
        <form action="PagoController">
            <div class="row my-3">
                <!--<div class="col-3">
                    <label for="txtFolio" class="form-label">Folio</label>
                    <input type="number" class="form-control" name="txtFolio" required>
                </div>-->
                <div class="col-6">
                    <label for="txtCont" class="form-label">Folio Contrato</label>
                    <select class="form-select" aria-label="Default select example" name="txtContPag">
                            <option selected disabled>Selecciona un contrato</option>
                            <%
                            ContratoDAO cdao = new ContratoDAO();
                            List<Contrato> list2 = cdao.show();
                            Iterator<Contrato> iter2 = list2.iterator();
                            Contrato cont = null;
                            while(iter2.hasNext()){
                                cont = iter2.next();
                            %>
                            <option value="<%= cont.getFolio()%>"><%= cont.getFolio()%> - <%= cont.getRfcCliente()%></option>
                            <%
                            }
                            %>--%>
                        </select>
                </div>
                <div class="col-6">
                    <label for="txtFechaPag" class="form-label">Fecha pago</label>
                    <input type="date" class="form-control" name="txtFechaPag" required>
                </div>
              </div>
            <div class="row my-3">
                <div class="col-6">
                    <label for="txtMontoPag" class="form-label">Monto</label>
                    <input type="number" class="form-control" name="txtMontoPag" required>
                </div>
                <div class="col-6">
                    <label for="txtEmp" class="form-label">RFC del Cobrador</label>
                    <select class="form-select" aria-label="Default select example" name="txtRfcPag">
                            <option selected disabled>Selecciona un Cobrador</option>
                            <%
                            EmpleadoDAO edao = new EmpleadoDAO();
                            List<Empleado> list = edao.show();
                            Iterator<Empleado> iter = list.iterator();
                            Empleado emp = null;
                            while(iter.hasNext()){
                                emp = iter.next();
                                if(emp.getTipo().equalsIgnoreCase("Cobrador")) {
                            %>
                            <option value="<%= emp.getRfc()%>"><%= emp.getRfc()%> - <%= emp.getNombre()%></option>
                            <%
                                }
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
                    <a type="button" class="btn btn-danger px-5" href="PagoController?action=show">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <%@ include file = "../footer.jsp" %>
