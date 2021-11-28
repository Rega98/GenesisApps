<%-- 
    Document   : edit
    Created on : 10 nov. 2021, 14:46:44
    Author     : IsmaelSL
--%>

<%@page import="Model.Proveedor"%>
<%@page import="ModelDAO.ProveedorDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp" %>
<%
    ProveedorDAO pdao = new ProveedorDAO();
    String rfc = (String) request.getAttribute("rfcProv");

    Proveedor prov = (Proveedor) pdao.details(rfc);
%>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row">
        <div>
            <h3>Editar <b><%=prov.getRfc()%></b></h3>
        </div>
    </div>
    <div class="row">
        <form action="ProveedorController">
            <div class="row my-3">
                <div class="col-4">
                    <label for="txtRfcProv" class="form-label">RFC Empresa</label>
                    <input type="text" class="form-control" name="txtRfcProv" value="<%=prov.getRfc()%>" disabled>
                </div>
                <div class="col-5">
                    <label for="txtNomProv" class="form-label">Nombre Empresa</label>
                    <input type="text" class="form-control" name="txtNomProv" value="<%=prov.getNombre()%>">
                </div>
                <div class="col-3">
                    <label for="txtTelProv" class="form-label">Telefono Empresa</label>
                    <input type="text" class="form-control" name="txtTelProv" value="<%=prov.getTelefono()%>">
                </div>
            </div>
            <div class="row my-3">
                <div class="col-6">
                    <label for="txtDirProv" class="form-label">Dirección Empresa</label>
                    <input type="text" class="form-control" name="txtDirProv" value="<%=prov.getDireccion()%>">
                </div>
                <div class="col-6">
                    <label for="txtEmaProv" class="form-label">Correo Empresa</label>
                    <input type="email" class="form-control" name="txtEmaProv" value="<%=prov.getCorreo()%>">
                </div>
            </div>
            <div class="row mt-5">
                <div class="col-8"></div>
                <div class="col-2">
                    <input type="submit" name="action" class="btn btn-primary px-5" value="Editar" />
                </div>
                <div class="col-2">
                    <a type="button" class="btn btn-danger px-5" href="ProveedorController?action=show">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <%@ include file = "../footer.jsp" %>

