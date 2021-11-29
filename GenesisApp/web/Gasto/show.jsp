<%-- 
    Document   : show
    Created on : 28 nov. 2021, 01:17:00
    Author     : bardo_3u8azdb
--%>
<%@page import="javax.enterprise.inject.Model"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Model.Gasto"%>
<%@page import="ModelDAO.GastoDAO"%>
<%@ include file = "../header.jsp" %>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row mb-3">
        <div class="col-10">
            <h3>Lista Gastos</h3>
        </div>
        <div class="col-2">
            <a href="GastoController?action=add" class="btn btn-success">Gasto Nuevo</a>
        </div>
    </div>
    <div class="row">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Folio</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Definicion</th>
                    <th scope="col">Importe con Iva</th>
                    <th scope="col">Importe sin Iva</th>
                    <th scope="col">Tipo gasto</th>
                    <th scope="col">Rfc Gerente</th>
                    <th scope="col">Acciones</th>
                    
                </tr>
            </thead>
            <tbody>
                <%
                    GastoDAO gdao = new GastoDAO();
                    List<Gasto> list = gdao.show();
                    Iterator<Gasto> iter = list.iterator();
                    Gasto gas = null;
                    while (iter.hasNext()) {
                        gas = iter.next();
                %>
                <tr>
                    <td><%= gas.getFolio()%></td>
                    <td><%= gas.getFecha()%></td>
                    <td><%= gas.getDefinicion()%></td>
                    <td><%= gas.getImporteCiva()%></td>
                    <td><%= gas.getImporteSinva()%></td>
                    <td><%= gas.getIdTipoGasto()%></td>
                    <td><%= gas.getRfGerente()%></td>
                    <td class="px-0">
                        <div class="btn-group btn-group-sm" role="group">
                            <a class="btn btn-primary " href="GastoController?action=edit&folio=<%=gas.getFolio()%>">Editar</a>
                            <a class="btn btn-danger" href="GastoController?action=delete&folio=<%=gas.getFolio()%>">Borrar</a>
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