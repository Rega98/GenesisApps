<%-- 
    Document   : edit
    Created on : 25 nov 2021, 9:47:33
    Author     : uriel
--%>

<%@page import="Model.Cliente"%>
<%@page import="ModelDAO.ClienteDAO"%>
<%@ include file = "../header.jsp" %>
<%
    ClienteDAO cdao = new ClienteDAO();
    String rfc = (String) request.getAttribute("rfcCli");
    Cliente cli = (Cliente) cdao.details(rfc);
%>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row">
        <div>
            <h3>Editar Cliente</b</h3>
        </div>
    </div>
    <div class="row">
        <form action="ClienteController">
            <div class="row my-3">
                <div class="col-3">
                    <label for="txtRfcCli" class="form-label">RFC Cliente</label>
                    <br>
                    <h4><%=cli.getRfc()%></h4>
                    <input type="hidden" class="form-control" name="txtRfcCli" value="<%=cli.getRfc()%>" minlength="3" maxlength="20" pattern="[A-ZÁÉÍÓÚÑ]{1}[a-záéíóúñ]{2,19}" title="Comienze con letra mayúscula, seguido de minusculas" required>
                </div>
                <div class="col-6">
                    <label for="txtNomCli" class="form-label">Nombre</label>
                    <input type="text" class="form-control" name="txtNomCli" value="<%=cli.getNombre()%>" minlength="3" maxlength="20" pattern="[A-ZÁÉÍÓÚÑ]{1}[a-záéíóúñ]{2,19}" title="Comienze con letra mayúscula, seguido de minusculas" required>
                </div>
                <div class="col-6">
                    <label for="txtAppPCli" class="form-label">Apellido Paterno</label>
                    <input type="text" class="form-control" name="txtAppPCli" value="<%=cli.getApPaterno()%>" minlength="3" maxlength="20" pattern="[A-ZÁÉÍÓÚÑ]{1}[a-záéíóúñ]{2,19}" title="Comienze con letra mayúscula, seguido de minusculas" required>
                </div>
                <div class="col-6">
                    <label for="txtAppMCli" class="form-label">Apellido Materno</label>
                    <input type="text" class="form-control" name="txtAppMCli" value="<%=cli.getApMaterno()%>" minlength="3" maxlength="20" pattern="[A-ZÁÉÍÓÚÑ]{1}[a-záéíóúñ]{2,19}" title="Comienze con letra mayúscula, seguido de minusculas" required>
                </div>
            </div>
            <div class="row my-3">
                <div class="col-6">
                    <label for="txtDirCli" class="form-label">Dirección</label>
                    <input type="text" class="form-control" name="txtDirCli" value="<%=cli.getDireccion()%>" minlength="3" maxlength="150" title="Descripción abierta" required>
                </div>
                <div class="col-3">
                    <label for="txtTelCli" class="form-label">Telefono</label>
                    <input type="text" class="form-control" name="txtTelCli" value="<%=cli.getTelefono()%>" minlength="10" maxlength="10" pattern="[0-9]{10}" title="10 dígitos numéricos" required>
                </div>
                <div class="col-6">
                    <label for="txtCorreoCli" class="form-label">Correo</label>
                    <input type="email" class="form-control" name="txtCorreoCli" value="<%=cli.getCorreo()%>" maxlength="20" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Formato válido: sample_01@exampl.com" required>
                </div>
            </div>
            <div class="row mt-5">
                <div class="col-8"></div>
                <div class="col-2">
                    <input type="submit" name="action" class="btn btn-primary px-5" value="Editar" />
                </div>
                <div class="col-2">
                    <a type="button" class="btn btn-danger px-5" href="ClienteController?action=show">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
</div>
<%@ include file = "../footer.jsp" %>

