<%-- 
    Document   : show
    Created on : 28 nov. 2021, 01:17:00
    Author     : bardo_3u8azdb
--%>
<%@page import="java.util.Iterator"%>
<%@page import="Model.Empleado"%>
<%@page import="java.util.List"%>
<%@page import="ModelDAO.EmpleadoDAO"%>
<%@page import="Model.Pago"%>
<%@page import="ModelDAO.PagoDAO"%>
<%@ include file = "../header.jsp" %>

<%
    PagoDAO pgdao = new PagoDAO();
    int folio = Integer.parseInt((String)request.getAttribute("folio"));

    Pago pag = (Pago) pgdao.details(folio);
%>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row">
        <div>
            <h3>Editar Pago</b></h3>
        </div>
    </div>
    <div class="row">
        <form action="PagoController">
            <div class="row my-3">
                <div class="col-md-4">
                    <label for="txtFolio" class="form-label">Folio</label>
                    <br>
                    <h4><%=pag.getFolio()%></h4>
                    <input type="hidden" class="form-control" name="txtFolio" value="<%=pag.getFolio()%>" required>
                </div>
                <div class="col-md-4">
                    <label for="txtFechaPag" class="form-label">Fecha pago</label>
                    <input type="date" class="form-control" name="txtFechaPag" value="<%=pag.getFecha()%>" required>
                </div>
                <div class="col-md-4">
                    <label for="txtMontoPag" class="form-label">Monto</label>
                    <input type="number" class="form-control" name="txtMontoPag" value="<%=pag.getMonto()%>" required>
                </div>
            </div>
            <div class="row my-3">
                <div class="col-md-4">
                    <label for="txtContPag" class="form-label">Folio Contrato</label>
                    <input type="text" readonly="readonly" class="form-control" name="txtContPag" value="<%=pag.getContratofolio()%>" required>
                </div>
                <div class="col-md-4">
                    <label for="txtRfcPag" class="form-label">RFC Cobrador</label>
                    <select class="form-select" aria-label="Default select example" name="txtRfcPag" value="<%=pag.getRfcCobrador() %>" required="required">
                            <%
                            EmpleadoDAO edao = new EmpleadoDAO();
                            List<Empleado> list = edao.show();
                            Iterator<Empleado> iter = list.iterator();
                            Empleado emp = null;
                            while(iter.hasNext()){
                                emp = iter.next();
                                if(emp.getTipo().equalsIgnoreCase("Cobrador") ) {
                            
                            %>
                            <option <% if(emp.getRfc().equalsIgnoreCase(pag.getRfcCobrador())){%> selected <%}%>value="<%= emp.getRfc()%>"><%= emp.getRfc()%> - <%= emp.getNombre()%></option>
                            <%
                            }
                            }
                            %>
                        </select>
                </div>
            </div>
                        <hr>
            <div class="row mt-5">
                <div class="col-8"></div>
                <div class="col-2">
                    <input type="submit" name="action" class="btn btn-primary px-5" value="Editar" />
                </div>
                <div class="col-2">
                    <a type="button" class="btn btn-danger px-5" href="PagoController?action=show">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <%@ include file = "../footer.jsp" %>

