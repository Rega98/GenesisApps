<%-- 
    Document   : show
    Created on : 30 nov. 2021, 18:41:18
    Author     : bardo_3u8azdb
--%>
<%@page import="javax.enterprise.inject.Model"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Model.Vale"%>
<%@page import="ModelDAO.ValeDAO"%>
<%@ include file = "../header.jsp" %>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row mb-3">
        <div class="col-10">
            <h3>Lista Vales</h3>
        </div>
        <div class="col-2">
            <a href="ValeController?action=add" class="btn btn-success">Nuevo Vale</a>
        </div>
    </div>
    <div class="row">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Folio</th>
                    <th scope="col">Monto</th>
                    <th scope="col">Fecha Vale</th>
                    <th scope="col">Concepto</th>
                    <th scope="col">RFC Vendedor</th>
                    <th scope="col">Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ValeDAO pgdao = new ValeDAO();
                    List<Vale> list = pgdao.show();
                    Iterator<Vale> iter = list.iterator();
                    Vale val = null;
                    while (iter.hasNext()) {
                        val = iter.next();
                %>
                <tr>
                    <td><%= val.getFolio()%></td>
                    <td><%= val.getMonto()%></td>
                    <td><%= val.getFechaVale()%></td>
                    <td><%= val.getConcepto()%></td>
                    <td><%= val.getRfcVendedor()%></td>
                    <td class="px-0">
                        <div class="btn-group btn-group-sm" role="group">
                            <a class="btn btn-primary " href="ValeController?action=edit&folio=<%=val.getFolio()%>">Editar</a>
                            <a class="btn btn-danger" href="ValeController?action=delete&folio=<%=val.getFolio()%>">Borrar</a>
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