<%-- 
    Document   : show
    Created on : 9 nov. 2021, 17:05:51
    Author     : ucmex
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Model.Proveedor"%>
<%@page import="ModelDAO.ProveedorDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tablita</h1>
        <a href="ProveedorController?action=add">Agregar</a>
        <br><br>
        <div>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ProveedorDAO pdao = new ProveedorDAO();
                        List<Proveedor> list = pdao.show();
                        Iterator<Proveedor> iter = list.iterator();
                        Proveedor prov = null;
                        while(iter.hasNext()){
                            prov = iter.next();
                    %>
                    <tr>
                        <td><%= prov.getId() %></td>
                        <td><%= prov.getNom() %></td>
                        <td>
                            <a href="ProveedorController?action=edit&id=<%=prov.getId()%>">Editar</a> | 
                            <a href="ProveedorController?action=delete&id=<%=prov.getId()%>">Eliminar</a>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </body>
</html>
