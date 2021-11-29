<%-- 
    Document   : show
    Created on : 25 nov 2021, 9:47:17
    Author     : uriel
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Model.Cliente"%>
<%@page import="ModelDAO.ClienteDAO"%>
<%@ include file = "../header.jsp" %>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row mb-3">
        <div class="col-10">
            <h3>Lista de Clientes</h3>
        </div>
        <div class="col-2">
            <a href="ClienteController?action=add" class="btn btn-success">Nuevo Cliente</a>
        </div>
    </div>
    <div class="row">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">RFC</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Apellido Paterno</th>
                    <th scope="col">Apellido Materno</th>
                    <th scope="col">Dirección</th>
                    <th scope="col">Telefono</th>
                    <th scope="col">Correo</th>
                    <th scope="col">Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ClienteDAO cdao = new ClienteDAO();
                    List<Cliente> list = cdao.show();
                    Iterator<Cliente> iter = list.iterator();
                    Cliente cli = null;
                    while (iter.hasNext()) {
                        cli = iter.next();
                %>
                <tr>
                    <th><%= cli.getRfc()%></th>
                    <td><%= cli.getNombre()%></td>
                    <td><%= cli.getApPaterno()%></td>
                    <td><%= cli.getApMaterno()%></td>
                    <td><%= cli.getDireccion()%></td>
                    <td><%= cli.getTelefono()%></td>
                    <td><%= cli.getCorreo()%></td>
                    <td class="px-0">
                        <div class="btn-group btn-group-sm" role="group">
                            <a class="btn btn-primary " href="ClienteController?action=edit&rfc=<%=cli.getRfc()%>">Editar</a>
                            <a class="btn btn-danger" href="ClienteController?action=delete&rfc=<%=cli.getRfc()%>">Borrar</a>
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
