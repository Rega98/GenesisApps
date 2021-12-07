<%-- 
    Document   : show
    Created on : 9 nov. 2021, 17:05:51
    Author     : IsmaelSL
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Model.Proveedor"%>
<%@page import="ModelDAO.ProveedorDAO"%>
<%@ include file = "../header.jsp" %>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row mb-3">
        <div class="col-10">
            <h3>Lista de Proveedores</h3>
        </div>
        <div class="col-2">
            <a href="ProveedorController?action=add" class="btn btn-success">Nuevo Proveedor</a>
        </div>
    </div>
    <div class="row">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">RFC</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Dirección</th>
                    <th scope="col">Correo</th>
                    <th scope="col">Telefono</th>
                    <th scope="col">Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ProveedorDAO pdao = new ProveedorDAO();
                    List<Proveedor> list = pdao.show();
                    Iterator<Proveedor> iter = list.iterator();
                    Proveedor prov = null;
                    while (iter.hasNext()) {
                        prov = iter.next();
                %>
                <tr>
                    <th><%= prov.getRfc()%></th>
                    <td><%= prov.getNombre()%></td>
                    <td><%= prov.getDireccion().substring(0,10)+"..."%></td>
                    <td><%= prov.getCorreo()%></td>
                    <td><%= prov.getTelefono()%></td>
                    <td class="px-0">
                        <div class="btn-group btn-group-sm" role="group">
                            <a class="btn btn-primary " href="ProveedorController?action=edit&rfc=<%=prov.getRfc()%>">Editar</a>
                            <a class="btn btn-danger" href="ProveedorController?action=delete&rfc=<%=prov.getRfc()%>">Borrar</a>
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