<%-- 
    Document   : add
    Created on : 25 nov 2021, 9:45:06
    Author     : uriel
--%>

<%@page import="Model.Producto"%>
<%@page import="ModelDAO.ProductoDAO"%>
<%@page import="Model.Empleado"%>
<%@page import="ModelDAO.EmpleadoDAO"%>
<%@page import="Model.Cliente"%>
<%@page import="ModelDAO.ClienteDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ include file = "../header.jsp" %>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row">
        <div>
            <h3>Nuevo Contrato</h3>
        </div>
    </div>
    <div class="row">
        <form action="ContratoController">
            <div class="row my-3">
                <div class="col-3">
                    <label for="txtFeCon" class="form-label">Fecha de Contrato</label>
                    <input type="date" class="form-control" name="txtFeCon">
                </div>
                <div class="col-3">
                    <label for="cbxIdCli" class="form-label">Cliente</label>
                    <select class="form-select" name="cbxIdCli">
                        <option selected disabled>Selecciona un cliente</option>
                        <%
                            ClienteDAO cdao = new ClienteDAO();
                            List<Cliente> list = cdao.show();
                            Iterator<Cliente> iter = list.iterator();
                            Cliente clie = null;
                            while (iter.hasNext()) {
                                clie = iter.next();
                        %>
                        <option value="<%= clie.getRfc()%>"><%= clie.getNombre() + " " + clie.getApPaterno() + " " + clie.getApMaterno()%></option>
                        <%
                            }
                        %>
                    </select>
                </div>
                <div class="col-3">
                    <label for="cbxIdVed" class="form-label">Vendedor</label>
                    <select class="form-select" name="cbxIdVed">
                        <option selected disabled>Selecciona un vendedor</option>
                        <%
                            EmpleadoDAO edao = new EmpleadoDAO();
                            List<Empleado> list2 = edao.show();
                            Iterator<Empleado> iter2 = list2.iterator();
                            Empleado vend = null;
                            while (iter2.hasNext()) {
                                vend = iter2.next();
                                if (vend.getTipo().equalsIgnoreCase("Vendedor")) {
                        %>
                        <option value="<%= vend.getRfc()%>"><%= vend.getNombre() + " " + vend.getApPaterno() + " " + vend.getApMaterno()%></option>
                        <%
                                }
                            }
                        %>
                    </select>
                </div>
                <div class="col-3">
                    <label for="cbxIdPro" class="form-label">Producto</label>
                    <Select class="form-select" name="cbxIdPro">
                        <option selected disabled>Selecciona un producto</option>
                        <%
                            ProductoDAO pdao = new ProductoDAO();
                            List<Producto> list3 = pdao.show();
                            Iterator<Producto> iter3 = list3.iterator();
                            Producto prod = null;

                            while (iter3.hasNext()) {
                                prod = iter3.next();
                        %>
                        <option value="<%= prod.getId()%>"><%= prod.getNombre()%></option>
                        <%
                            }
                        %>
                    </Select>
                </div>
            </div>
            <div class="row my-3">
                <div class="col-8"></div>
                <div class="col-4">
                    <hr>
                    <a type="submit" class="btn btn-primary px-5" href="ContratoController?action=details">Continuar</a>
                    <a type="submit" class="btn btn-danger px-5" href="ContratoController?action=show">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
</div>
<%@ include file = "../footer.jsp" %>