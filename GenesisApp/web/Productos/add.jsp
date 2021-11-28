<%-- 
    Document   : add
    Created on : 10 nov. 2021, 13:15:52
    Author     : IsmaelSL
--%>
<%@ include file = "../header.jsp" %>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row">
        <div>
            <h3>Nuevo Producto</h3>
        </div>
    </div>
    <div class="row">
        <form action="ProductoController">
            <div class="row my-3">
                <div class="col-4">
                    <label for="txtNomProd" class="form-label">Nombre Producto</label>
                    <input type="text" class="form-control" name="txtNomProd" required>
                </div>
                <div class="col-6">
                    <label for="txtDesProd" class="form-label">Descripción Producto</label>
                    <input type="text" class="form-control" name="txtDesProd" required>
                </div>
                <div class="col-2">
                    <label for="txtStoProd" class="form-label">Stock</label>
                    <div class="input-group">
                        <span class="input-group-text">#</span>
                        <input type="number" class="form-control" name="txtStoProd" required>
                    </div>
                </div>
            </div>
            <div class="row my-3">
                <div class="col-3">
                    <label for="txtPreComProd" class="form-label">Precio Compra</label>
                    <div class="input-group">
                        <span class="input-group-text">$</span>
                        <input type="number" class="form-control" name="txtPreComProd" required>
                    </div>
                </div>
                <div class="col-3">
                    <label for="txtPreVenProd" class="form-label">Precio Venta</label>
                    <div class="input-group">
                        <span class="input-group-text">$</span>
                        <input type="number" class="form-control" name="txtPreVenProd" required>
                    </div>
                </div>
                <div class="col-4">
                    <label for="txtCatProd" class="form-label">Categoría</label>
                    <select class="form-select" name="txtCatProd">
                        <option selected disabled>Seleccione categoría...</option>
                        <option value="Electrodoméstico">Electrodoméstico</option>
                        <option value="Electrónica">Electrónica</option>
                        <option value="Mensual">Línea Blanca</option>
                    </select>
                </div>
                <div class="col-2">
                    <label for="radIvaProd" class="form-label">¿Aplica IVA?</label>
                    <div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="radIvaProd" value="true" checked>
                            <label class="form-check-label" for="radIvaProd1">Sí</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="radIvaProd" value="false">
                            <label class="form-check-label" for="radIvaProd2">No</label>
                        </div>
                    </div>
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
