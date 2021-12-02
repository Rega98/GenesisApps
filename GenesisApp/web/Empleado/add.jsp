<%-- 
    Document   : add
    Created on : 25 nov 2021, 9:43:09
    Author     : uriel
--%>

<%@ include file = "../header.jsp" %>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row">
        <div>
            <h3>Nuevo Empleado</h3>
        </div>
    </div>
    <div class="row">
        <form action="EmpleadoController">
            <div class="col-6">
                <label for="txtRfcEmpl" class="form-label">RFC</label>
                <input type="text" class="form-control" name="txtRfcEmpl" required>
            </div>
            <div class="col-md-4">
                <label for="txtNomEmpl" class="form-label">Nombre</label>
                <input type="text" class="form-control" name="txtNomEmpl" required>
            </div>
            <div class="col-md-4">
                <label for="txtAppPEmpl" class="form-label">Apellido Paterno</label>
                <input type="text" class="form-control" name="txtAppPEmpl" required>
            </div>
            <div class="col-md-4">
                <label for="txtAppMEmpl" class="form-label">Apellido Materno</label>
                <input type="text" class="form-control" name="txtAppMEmpl" required>
            </div>
            <div class="col-6">
                <label for="txtUsrEmpl" class="form-label">Usuario</label>
                <input type="text" class="form-control" name="txtUsrEmpl" required>
            </div>
            <div class="col-6">
                <label for="txtPassEmpl" class="form-label">Password</label>
                <input type="password" class="form-control" name="txtPassEmpl" required>
            </div>
            <div class="col-md-6">
                <label for="txtTipoEmpl" class="form-label">Tipo de Empleado</label>
                <select class="form-select" aria-label="Default select example" name="txtTipoEmpl" >
                    <option value="Gerente" selected>Gerente</option>
                    <option value="Vendedor">Vendedor</option>
                    <option value="Cobrador">Cobrador</option>
                </select>
            </div>
            <div class="row mt-5">
                <div class="col-8"></div>
                <div class="col-2">
                    <input type="submit" name="action" class="btn btn-primary px-5" value="Guardar" />
                </div>
                <div class="col-2">
                    <a type="button" class="btn btn-danger px-5" href="EmpleadoController?action=show">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
<%@ include file = "../footer.jsp" %>
    
