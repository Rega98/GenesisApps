<%-- 
    Document   : add
    Created on : 10 nov. 2021, 13:15:52
    Author     : IsmaelSL
--%>
<%@ include file = "../header.jsp" %>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row">
        <div>
            <h3>Nuevo Contrato</h3>
        </div>
    </div>
    <div class="row">
        <form action="ProveedorController">
            <div class="row my-3">
                <div class="col-4">
                    <label for="txtRfcProv" class="form-label">RFC Empresa</label>
                    <input type="text" class="form-control" name="txtRfcProv">
                </div>
                <div class="col-5">
                    <label for="txtNomProv" class="form-label">Nombre Empresa</label>
                    <input type="text" class="form-control" name="txtNomProv">
                </div>
                <div class="col-3">
                    <label for="txtTelProv" class="form-label">Telefono Empresa</label>
                    <input type="text" class="form-control" name="txtTelProv">
                </div>
            </div>
            <div class="row my-3">
                <div class="col-6">
                    <label for="txtDirProv" class="form-label">Dirección Empresa</label>
                    <input type="text" class="form-control" name="txtDirProv">
                </div>
                <div class="col-6">
                    <label for="txtEmaProv" class="form-label">Correo Empresa</label>
                    <input type="email" class="form-control" name="txtEmaProv">
                </div>
            </div>
            <div class="row mt-5">
                <div class="col-8"></div>
                <div class="col-2">
                    <input type="submit" name="action" class="btn btn-primary px-5" value="Guardar" />
                </div>
                <div class="col-2">
                    <a type="button" class="btn btn-danger px-5" href="ProveedorController?action=show">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <%@ include file = "../footer.jsp" %>
