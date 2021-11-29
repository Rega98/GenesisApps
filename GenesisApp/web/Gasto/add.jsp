<%-- 
    Document   : show
    Created on : 28 nov. 2021, 01:17:00
    Author     : bardo_3u8azdb
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>

<%@ include file = "../header.jsp" %>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row">
        <div>
            <h3>Gasto Nuevo</h3>
        </div>
    </div>
    <div class="row">
        <form action="PagoController">
            <div class="row my-3">
                <div class="col-3">
                    <label for="txtFolio" class="form-label">Folio</label>
                    <input type="number" class="form-control" name="txtFolio" required>
                </div>
                <div class="col-3">
                    <label for="txtFecha" class="form-label">Fecha</label>
                    <input type="date" class="form-control" name="txtFecha" required>
                </div>
                <div class="col-6">
                    <label for="txtDef" class="form-label">Definicion</label>
                    <input type="text" class="form-control" name="txtDef" required>
                </div>
            </div>
            <div class="row my-3">
                <div class="col-3">
                    <label for="txtImpiva" class="form-label">Importe con Iva</label>
                    <input type="text" class="form-control" name="txtImpiva" required>
                </div>
                <div class="col-3">
                    <label for="txtImpsiniva" class="form-label">Importe sin Iva</label>
                    <input type="text" class="form-control" name="txtImpsiniva" required>
                </div>
                <div class="col-3">
                    <label for="txtTipogas" class="form-label">Tipo gasto</label>
                    <input type="number" class="form-control" name="txtTipogas" required>
                </div>
                <div class="col-3">
                    <label for="txtRfcGer" class="form-label">Rfc Gerente</label>
                    <input type="text" class="form-control" name="txtRfcGer" required>
                </div>
            </div>
            <div class="row mt-5">
                <div class="col-8"></div>
                <div class="col-2">
                    <input type="submit" name="action" class="btn btn-primary px-5" value="Guardar" />
                </div>
                <div class="col-2">
                    <a type="button" class="btn btn-danger px-5" href="GastoController?action=show">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <%@ include file = "../footer.jsp" %>
