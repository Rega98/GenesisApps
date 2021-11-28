<%-- 
    Document   : show
    Created on : 25 nov 2021, 9:46:37
    Author     : uriel
--%>
<%@page import="java.util.Iterator"%>
<%@page import="Model.Compra"%>
<%@page import="java.util.List"%>
<%@page import="ModelDAO.CompraDAO"%>
<%@ include file = "../header.jsp" %>

    <div class="container p-5 m-5 bg-white shadow rounded-3">
        <!--<div class="">
            <div class="row">
                <div>
                    <h3>Listado de Compras</h3>
                    <br>
                    <div class="col-2">
                        <a href="CompraController?action=add" class="btn btn-success">Agregar Compra</a>
                    </div>
                </div>
            </div>
        </div>-->
        <div class="row mb-3">
        <div class="col-10">
            <h3>Lista de Compras</h3>
        </div>
        <div class="col-2">
            <a href="CompraController?action=add" class="btn btn-success">Agregar Compra</a>
        </div>
        </div>
        <div class="content">
            <div class="row">
                <table class="table table-striped">
                    <thead>
                      <tr>
                        <th scope="col">Folio</th>
                        <th scope="col">Fecha</th>
                        <th scope="col">Cantidad</th>
                        <th scope="col">Iva</th>
                        <th scope="col">Monto Total</th>
                        <th scope="col">Estado</th>
                        <th scope="col">RFC de Proovedor</th>
                        <th scope="col">ID producto</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                      </tr>
                    </thead>
                    <tbody>
                      <%
                        CompraDAO cdao = new CompraDAO();
                        List<Compra> list = cdao.show();
                        Iterator<Compra> iter = list.iterator();
                        Compra com = null;
                        while(iter.hasNext()){
                            com = iter.next();
                      %>
                      <tr>
                        <td><%= com.getFolio() %></td>
                        <td><%= com.getFechaCompra()%></td>
                        <td><%= com.getCantidad() %></td>
                        <td>
                            <%  if(com.getIva()){ %>
                            Si
                            <%
                                }
                                else{
                                %>
                                No
                                <%
                                    }
                                %>
                        </td>
         
                        <td><%= com.getMontoTotal() %></td>
                        <td><%= com.getEstado() %></td>
                        <td><%= com.getRfcProveedor() %></td>
                        <td><%= com.getProductoid() %></td>
                        <td class="px-0">
                        <div class="btn-group btn-group-sm" role="group">
                            <a class="btn btn-primary " href="CompraController?action=edit&folio=<%=com.getFolio()%>">Editar</a>
                            <a class="btn btn-danger" href="CompraController?action=delete&folio=<%=com.getFolio()%>">Borrar</a>
                        </div>
                        </td>
                        <!--<td>
                            <a href="CompraController?action=edit$folio=<%=com.getFolio()%>" class="btn btn-primary" id="btnEdit" role="button">Editar</a>
                        </td>
                        <td>
                            <a href="CompraController?action=delete$folio=<%=com.getFolio()%>" class="btn btn-danger" id="btnEdit" role="button">Eliminar</a>
                            <!--<button type="button" class="btn btn-danger">Eliminar</button>-->
                        <!--</td>-->
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
             
            </div>
        </div>

<%@ include file = "../footer.jsp" %>