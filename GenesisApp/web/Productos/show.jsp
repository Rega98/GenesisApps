<%-- 
    Document   : show
    Created on : 9 nov. 2021, 17:05:51
    Author     : IsmaelSL
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Model.Producto"%>
<%@page import="ModelDAO.ProductoDAO"%>
<%@ include file = "../header.jsp" %>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row mb-3">
        <div class="col-10">
            <h3>Lista de Productos</h3>
        </div>
        <div class="col-2">
            <a href="ProductoController?action=add" class="btn btn-success">Nuevo Producto</a>
        </div>
    </div>
    <div class="row">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Descripción</th>
                    <th scope="col">P. Compra</th>
                    <th scope="col">P. Venta</th>
                    <th scope="col">Aplica IVA</th>
                    <th scope="col">Stock</th>
                    <th scope="col">Categoría</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ProductoDAO pdao = new ProductoDAO();
                    List<Producto> list = pdao.show();
                    Iterator<Producto> iter = list.iterator();
                    Producto prod = null;
                    while (iter.hasNext()) {
                        prod = iter.next();
                %>
                <tr>
                    <th><%= prod.getId()%></th>
                    <td><%= prod.getNombre()%></td>
                    <td><%= prod.getDescripcion()%></td>
                    <td><%= prod.getPrecioCompra()%></td>
                    <td><%= prod.getPrecioVenta()%></td>
                    <td><%  if(prod.getIva()){
                            %> <small class="bg-success text-white rounded-3 px-2">Sí</small><% 
                            } else {
                            %> <small class="bg-danger text-white rounded-3 px-2">No</small><% 
                            }   
                        %></td>
                    <td><%= prod.getStock()%></td>
                    <td><%= prod.getCategoria()%></td>
                    <td class="px-0">
                        <div class="btn-group btn-group-sm" role="group">
                            <a class="btn btn-primary " href="ProductoController?action=edit&id=<%=prod.getId()%>">Editar</a>
                            <a class="btn btn-danger" href="ProductoController?action=delete&id=<%=prod.getId()%>">Borrar</a>
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