<%-- 
    Document   : show
    Created on : 25 nov 2021, 9:43:00
    Author     : uriel
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Model.Empleado"%>
<%@page import="ModelDAO.EmpleadoDAO"%>
<%@ include file = "../header.jsp" %>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row mb-3">
        <div class="col-8">
            <h3>Lista de Empleados</h3>
        </div>
        <div class="col-2">
            <a href="EmpleadoController?action=add" class="btn btn-success">Nuevo Empleado</a>
        </div>
        <div class="col-2">
            <a href="ValeController?action=show"  class="btn btn-info">Vales Empleados</a>
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
                        <th scope="col">Usuario</th>
                        <!-- creo que no debrias mostrarse el password<th scope="col">Password</th>-->
                        <th scope="col">Tipo</th>
                        <th scope="col">Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    EmpleadoDAO edao = new EmpleadoDAO();
                    List<Empleado> list = edao.show();
                    Iterator<Empleado> iter = list.iterator();
                    Empleado emp = null;
                    while (iter.hasNext()) {
                        emp = iter.next();
                %>
                <tr>
                    <th><%= emp.getRfc()%></th>
                    <td><%= emp.getNombre()%></td>
                    <td><%= emp.getApPaterno()%></td>
                    <td><%= emp.getApMaterno()%></td>
                    <td><%= emp.getUser()%></td>
                    <td><%= emp.getTipo()%></td>
                    <td class="px-0">
                        <div class="btn-group btn-group-sm" role="group">
                            <a class="btn btn-primary " href="EmpleadoController?action=edit&rfc=<%=emp.getRfc()%>">Editar</a>
                            <a class="btn btn-danger" href="EmpleadoController?action=delete&rfc=<%=emp.getRfc()%>">Borrar</a>
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
