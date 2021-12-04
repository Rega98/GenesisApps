<%-- 
    Document   : show
    Created on : 25 nov 2021, 9:41:08
    Author     : uriel
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Model.Ruta"%>
<%@page import="java.util.List"%>
<%@page import="ModelDAO.RutaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp" %>

<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="container">
        <div class="row">
            <div>
                <h3>Listado de Rutas</h3>
                <br>
                <a href="RutaController?action=add" class="btn btn-success" id="btnAdd" role="button">Agregar Ruta</a>
            </div>
        </div>
    </div>
    
    <br><!-- comment -->
    <br>
    


    <div class="container">
        <div class="row">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Descripcion</th>
                        <th scope="col">Rutas</th>
                        <th scope="col">Folio de contrato</th>
                        <!-- creo que no debrias mostrarse el password<th scope="col">Password</th>-->
                        <th scope="col"></th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        RutaDAO rdao = new RutaDAO();
                        List<Ruta> list = rdao.show();
                        Iterator<Ruta> iter = list.iterator();
                        Ruta ruta = null;
                        while (iter.hasNext()) {
                            ruta = iter.next();
                    %>
                    <tr>
                        <th scope="row"><%=ruta.getIdRuta()%></th>
                        <td><%=ruta.getDescripcionRuta()%></td>
                        <td><%=ruta.getRutas()%></td>
                        <td></td>
                        <td>

                            <a href="RutaController?action=edit&Id=<%=ruta.getIdRuta()%>" class="btn btn-primary" id="btnEdit" role="button">Editar</a>
                            <a class="btn btn-danger" href="RutaController?action=delete&Id=<%=ruta.getIdRuta()%> ">Borrar</a>
                        </td>
                    </tr>

                    <%
                        }
                    %>
                </tbody>
            </table>

        </div>
    </div>

</div>




<%@ include file = "../footer.jsp" %>
