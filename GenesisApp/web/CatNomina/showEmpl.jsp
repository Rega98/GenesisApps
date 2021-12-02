<%-- 
    Document   : showEmpl
    Created on : 1/12/2021, 06:12:42 PM
    Author     : Adolfo Meza Romero
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Model.Empleado"%>
<%@page import="ModelDAO.EmpleadoDAO"%>
<%@ include file = "../header.jsp" %>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row mb-3">
        <div class="col-10">
            <h3>Lista de Empleados</h3>
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
                    <th scope="col">Tipo</th>
                    <th scope="col">Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    EmpleadoDAO edao = new EmpleadoDAO();
                    List<Empleado> list = edao.show3();
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
                            <a class="btn btn-primary " href="CalcNomEmplController?action=calcular&rfc=<%=emp.getRfc()%>">Calcular Nomina</a>
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
