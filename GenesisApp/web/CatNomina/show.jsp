<%-- 
    Document   : show
    Created on : 30 nov. 2021, 02:22:22
    Author     : bardo_3u8azdb
--%>
<%@page import="javax.enterprise.inject.Model"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Model.CatNomina"%>
<%@page import="ModelDAO.CatNominaDAO"%>
<%@ include file = "../header.jsp" %>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row mb-3">
        <div class="col-10">
            <h3>Lista CatNomina</h3>
        </div>
        <div class="col-2">
            <a href="CatNominaController?action=add" class="btn btn-success">Nuevo CatNomina</a>
        </div>
    </div>
    <div class="row">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Folio</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Mes Año</th>
                    <th scope="col">Periodo</th>
                    <th scope="col">Monto</th>
                    <th scope="col">RFC Empleado</th>
                    <th scope="col">Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    CatNominaDAO cndao = new CatNominaDAO();
                    List<CatNomina> list = cndao.show();
                    Iterator<CatNomina> iter = list.iterator();
                    CatNomina cnom = null;
                    while (iter.hasNext()) {
                        cnom = iter.next();
                %>
                <tr>
                    <td><%= cnom.getFolio()%></td>
                    <td><%= cnom.getFecha()%></td>
                    <td><%= cnom.getMesAnio()%></td>
                    <td><%= cnom.getPeriodo()%></td>
                    <td><%= cnom.getMonto()%></td>
                    <td><%= cnom.getRfcEmpleado()%></td>
                    <td class="px-0">
                        <div class="btn-group btn-group-sm" role="group">
                            <a class="btn btn-primary " href="CatNominaController?action=edit&folio=<%=cnom.getFolio()%>">Editar</a>
                            <a class="btn btn-danger" href="CatNominaController?action=delete&folio=<%=cnom.getFolio()%>">Borrar</a>
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