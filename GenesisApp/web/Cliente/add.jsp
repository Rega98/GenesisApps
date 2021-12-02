<%@ include file = "../header.jsp" %>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row">
        <div>
            <h3>Nuevo Cliente</h3>
        </div>
    </div>
    <div class="row">
        <form action="ClienteController">
            <div class="row my-3">
                <div class="col-3">
                    <label for="txtRfcCli" class="form-label">RFC Cliente</label>
                    <input type="text" class="form-control" name="txtRfcCli" required maxlength="13" pattern="[A-Za-z0-9]+" title="El RFC esta conformado de letras y números" >
                </div>
                <div class="col-6">
                    <label for="txtNomCli" class="form-label">Nombre</label>
                    <input type="text" class="form-control" name="txtNomCli" required maxlength="50" pattern="[A-Za-z0-9]+">
                </div>
                <div class="col-6">
                    <label for="txtAppPCli" class="form-label">Apellido Paterno</label>
                    <input type="text" class="form-control" name="txtAppPCli" required maxlength="50" pattern="[A-Za-z0-9]+">
                </div>
                <div class="col-6">
                    <label for="txtAppMCli" class="form-label">Apellido Materno</label>
                    <input type="text" class="form-control" name="txtAppMCli" required maxlength="50" pattern="[A-Za-z0-9]+">
                </div>
            </div>
            <div class="row my-3">
                <div class="col-6">
                    <label for="txtDirCli" class="form-label">Dirección</label>
                    <input type="text" class="form-control" name="txtDirCli" required maxlength="100" pattern="[A-Za-z0-9]+">
                </div>
                <div class="col-3">
                    <label for="txtTelCli" class="form-label">Telefono</label>
                    <input type="text" class="form-control" name="txtTelCli" required maxlength="10" pattern="[0-9]{10}"> 
                </div>
                <div class="col-6">
                    <label for="txtCorreoCli" class="form-label">Correo</label>
                    <input type="email" class="form-control" name="txtCorreoCli" required maxlength="10" pattern=".+@globex\.com">
                </div>
            </div>
            <div class="row mt-5">
                <div class="col-8"></div>
                <div class="col-2">
                    <input type="submit" name="action" class="btn btn-primary px-5" value="Guardar" />
                </div>
                <div class="col-2">
                    <a type="button" class="btn btn-danger px-5" href="ClienteController?action=show">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
   <%@ include file = "../footer.jsp" %>
