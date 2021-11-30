<%-- 
    Document   : edit
    Created on : 25 nov 2021, 9:43:21
    Author     : uriel
--%>

<%@page import="Model.Empleado"%>
<%@page import="ModelDAO.EmpleadoDAO"%>
<%@ include file = "../header.jsp" %>
<%
    EmpleadoDAO edao = new EmpleadoDAO();
    String rfc = (String) request.getAttribute("rfcEmpl");

    Empleado empl = (Empleado) edao.details(rfc);
%>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row">
        <div>
            <h3>Editar Empleado</h3>
        </div>
    </div>
    <div class="row">
        <form action="EmpleadoController">
            <div class="col-3">
                <label for="txtRfcProv" class="form-label">RFC</label><br>
                <h4><%=empl.getRfc()%></h4>
                <input type="hidden" class="form-control" name="txtRfcEmpl" value="<%=empl.getRfc()%>" required>
            </div>
            <div class="col-md-4">
                <label for="txtNomEmpl" class="form-label">Nombre</label>
                <input type="text" class="form-control" name="txtNomEmpl" value="<%=empl.getNombre()%>" required>
            </div>
            <div class="col-md-4">
                <label for="txtAppPEmpl" class="form-label">Apellido Paterno</label>
                <input type="text" class="form-control" name="txtAppPEmpl" value="<%=empl.getApPaterno()%>" required>
            </div>
            <div class="col-md-4">
                <label for="txtAppMEmpl" class="form-label">Apellido Materno</label>
                <input type="text" class="form-control" name="txtAppMEmpl" value="<%=empl.getApMaterno()%>" required>
            </div>
            <div class="col-6">
                <label for="txtUsrEmpl" class="form-label">Usuario</label>
                <input type="text" class="form-control" name="txtUsrEmpl" value="<%=empl.getUser()%>" required>
            </div>
            <div class="col-6">
                <label for="txtPassEmpl" class="form-label">Password</label>
                <input type="password" class="form-control" name="txtPassEmpl" value="<%=empl.getPass()%>" required>
            </div>
            <div class="col-md-6">
                <label for="txtTipoEmpl" class="form-label">Tipo de Empleado</label>
                <select class="form-select" aria-label="Default select example" value="<%=empl.getTipo()%>" name="txtTipoEmpl" >
                    <option value="Gerente" selected>Gerente</option>
                    <option value="Vendedor">Vendedor</option>
                    <option value="Cobrador">Cobrador</option>
                </select>
            </div>
            <div class="row mt-5">
                <div class="col-8"></div>
                <div class="col-2">
                    <input type="submit" name="action" class="btn btn-primary px-5" value="Editar" />
                </div>
                <div class="col-2">
                    <a type="button" class="btn btn-danger px-5" href="EmpleadoController?action=show">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <%@ include file = "../footer.jsp" %>
