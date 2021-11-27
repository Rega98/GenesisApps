<%-- 
    Document   : add
    Created on : 25 nov 2021, 9:46:28
    Author     : uriel
--%>
<%@ include file = "../header.jsp" %>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="">
        <div class="row">
            <div>
                <h3>Agregar Compra</h3>
            </div>
        </div>
    </div>
    <div class="">
        <div class="row">
            <form class="row g-3">                    
                <!--<div class="col-md-4">
                  <label for="txtNombre" class="form-label">Nombre</label>
                  <input type="text" class="form-control" id="txtNombre">
                </div>-->
                <div class="col-md-4">
                    <label for="txtFecCom" class="form-label">Fecha</label>
                    <input type="date" class="form-control" id="txtAppo" name="txtFecCom">
                </div>
                <div class="col-md-4">
                    <label for="numCantidadCom" class="form-label">Cantidad</label>
                    <input type="number" class="form-control" id="NumCantidadCom" name="txtCantCom">
                </div>
                <div class="col-md-4">
                    <label for="numberIvaCom" class="form-label">IVA</label>
                    <select class="form-select" aria-label="Default select example" name="txtIvaCom">
                        <option selected>Selecione una opción</option>
                        <option value="1">SI</option>
                        <option value="0">NO</option>
                    </select>
                </div>
                <div class="col-6">
                    <label for="numberMontooCom" class="form-label">Monto Total</label>
                    <input type="number" class="form-control" id="numberMonto" name="txtMontotCom">
                </div>
                <div class="col-6">
                    <label for="txtEstCom" class="form-label">Estado</label>
                    <input type="text" class="form-control" id="txtEstCom" name="txtEstadoCom">
                </div>
                <div class="col-6">
                    <label for="txtProvCom" class="form-label">RFC del profesor</label>
                    <input type="text" class="form-control" id="txtProvCom" name="txtRfcCom">
                </div>

                <div class="col-6">
                    <button type="submit" class="btn btn-primary">Agregar</button>

                    <button type="submit" class="btn btn-danger">Cancelar</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%@ include file = "../footer.jsp" %>