<%-- 
    Document   : show
    Created on : 28 nov. 2021, 01:17:00
    Author     : bardo_3u8azdb
--%>
<%@page import="javax.enterprise.inject.Model"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Model.Pago"%>
<%@page import="ModelDAO.PagoDAO"%>
<%@ include file = "../header.jsp" %>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row mb-3">
        <div class="col-10">
            <h3>Lista Pagos</h3>
        </div>
        <div class="col-2">
            <a href="PagoController?action=add" class="btn btn-success">Pago Nuevo</a>
        </div>
    </div>
    <div class="row">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Folio</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Monto</th>
                    <th scope="col">Folio Contrato</th>
                    <th scope="col">RFC Cobrador</th>
                    <th scope="col">Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    PagoDAO pgdao = new PagoDAO();
                    List<Pago> list = pgdao.show();
                    Iterator<Pago> iter = list.iterator();
                    Pago pa = null;
                    while (iter.hasNext()) {
                        pa = iter.next();
                %>
                <tr>
                    <td><%= pa.getFolio()%></td>
                    <td><%= pa.getFecha()%></td>
                    <td><%= pa.getMonto()%></td>
                    <td><%= pa.getContratofolio()%></td>
                    <td><%= pa.getRfcCobrador()%></td>
                    <td class="px-0">
                        <div class="btn-group btn-group-sm" role="group">
                            <a class="btn btn-primary " href="PagoController?action=edit&folio=<%=pa.getFolio()%>">Editar</a>
                            <a class="btn btn-danger" href="PagoController?action=delete&folio=<%=pa.getFolio()%>">Borrar</a>
                        </div>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
    <%@ include file = "../footer.jsp" %>