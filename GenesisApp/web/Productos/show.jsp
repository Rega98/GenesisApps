<%-- 
    Document   : show
    Created on : 19 nov. 2021, 14:16:19
    Author     : IsmaSL
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Model.Producto"%>
<%@page import="java.util.List"%>
<%@page import="ModelDAO.ProductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
    </head>
    <body>
        <h1>Lista de productos</h1>
        <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ProductoDAO pdao = new ProductoDAO();
                        List<Producto> list = pdao.show();
                        Iterator<Producto> iter = list.iterator();
                        Producto prod = null;
                        while(iter.hasNext()){
                            prod = iter.next();
                    %>
                    <tr>
                        <td><%= prod.getId() %></td>
                        <td><%= prod.getNombre() %></td>
                        <td><%= prod.getDescripcion() %></td>
                        <td><%= prod.getPrecioVenta() %></td>
                        <td><%= prod.getPrecioCompra() %></td>
                        <td><%= prod.getIva() %></td>
                        <td><%= prod.getStock() %></td>
                        <td><%= prod.getCategoria() %></td>
                        <td>
                            <a>Editar</a> | 
                            <a>Eliminar</a>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
    </body>
</html>
