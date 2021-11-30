<%-- 
    Document   : show
    Created on : 29 nov. 2021, 01:17:00
    Author     : bardo_3u8azdb
--%>
<%@page import="javax.enterprise.inject.Model"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Model.TipoGasto"%>
<%@page import="ModelDAO.TipoGastoDAO"%>
<%@ include file = "../header.jsp" %>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row mb-3">
        <div class="col-10">
            <h3>Lista Gastos</h3>
        </div>
        <div class="col-2">
            <a href="TipoGastoController?action=add" class="btn btn-success">Gasto Nuevo</a>
        </div>
    </div>
    <div class="row">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Descripcion</th>
                    <th scope="col">Tipo Gasto</th>
                    <th scope="col">Acciones</th>
                    
                </tr>
            </thead>
            <tbody>
                <%
                    TipoGastoDAO tgdao = new TipoGastoDAO();
                    List<TipoGasto> list = tgdao.show();
                    Iterator<TipoGasto> iter = list.iterator();
                    TipoGasto tgas = null;
                    while (iter.hasNext()) {
                        tgas = iter.next();
                %>
                <tr>
                    <td><%= tgas.getId()%></td>
                    <td><%= tgas.getDescripcion()%></td>
                    <td><%= tgas.getTipo()%></td>

                    <td class="px-0">
                        <div class="btn-group btn-group-sm" role="group">
                            <a class="btn btn-primary " href="TipoGastoController?action=edit&Id=<%=tgas.getId()%>">Editar</a>
                            <a class="btn btn-danger" href="TipoGastoController?action=delete&Id=<%=tgas.getId()%>">Borrar</a>
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