<%-- 
    Document   : show
    Created on : 25 nov 2021, 9:41:57
    Author     : uriel
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Model.Observacion"%>
<%@page import="java.util.List"%>
<%@page import="ModelDAO.ObservacionDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp" %>
<%
  int folio = Integer.parseInt((String)request.getAttribute("folio"));  
%>

    <div class="container p-5 m-5 bg-white shadow rounded-3">
            <div class="row">
                <div>
                    <h3>Listado de observaciones</h3>
                    <br>
                    <a href="ObservacionController?action=add&folio=<%=folio%>" class="btn btn-success" id="btnAdd" role="button">Agregar Observacion</a>
                </div>
            </div>
        <br>
        <br>
        <div class="content">
            <div class="row">
                <table class="table table-striped">
                    <thead>
                      <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Fecha</th>
                        <th scope="col">Observación</th>
                        <th scope="col">Folio de contrato</th>
                        <!-- creo que no debrias mostrarse el password<th scope="col">Password</th>-->
                        <th scope="col"></th>
                        <th scope="col"></th>
                      </tr>
                    </thead>
                    <tbody>
                        <%
                            ObservacionDAO obDAO = new ObservacionDAO();
                            List<Observacion> list = obDAO.show(folio);
                            Iterator<Observacion> iter = list.iterator();
                            Observacion obs = null;
                                while (iter.hasNext()) {
                                    obs = iter.next();
                        %>
                      <tr>
                          <th scope="row"><%=obs.getId()%></th>
                        <td><%=obs.getFecha()%></td>
                        <td><%=obs.getObservacion() %></td>
                        <td><%=obs.getContratofolio() %></td>
                        <td>
                            
                            <!--<a href="ObservacionController?action=edit&Id=<%=obs.getId()%> " class="btn btn-primary" id="btnEdit" role="button">Editar</a>-->
                            <a class="btn btn-danger" href="ObservacionController?action=delete&Id=<%=obs.getId()%>">Borrar</a>
                        </td>
                      </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
             
            </div>
        </div>

<%@ include file = "../footer.jsp" %>