<%-- 
    Document   : edit
    Created on : 30 nov. 2021, 18:41:39
    Author     : bardo_3u8azdb
--%>
<%@page import="Model.Vale"%>
<%@page import="ModelDAO.ValeDAO"%>
<%@ include file = "../header.jsp" %>

<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row">
        <div>
            <h3>Editar Nuevo</b></h3>
        </div>
    </div>
    <div class="row">
        <form action="ValeController">
            <div class="row my-3">
                <div class="col-4">
                    <label for="txtFolio" class="form-label">Folio</label>
                    <br>
                    <h4></h4>
                    <input type="number" class="form-control" name="txtFolio" value="" required>
                </div>
                <div class="col-4">
                    <label for="txtMontoval" class="form-label">Monto</label>
                    <input type="number" class="form-control" name="txtMontoval" value="" required>
                </div>
                <div class="col-4">
                    <label for="txtFechaval" class="form-label">Fecha Vale</label>
                    <input type="date" class="form-control" name="txtFechaval" value="" required>
                </div>
                
            </div>
            <div class="row my-3">
                <div class="col-6">
                    <label for="txtConc" class="form-label">Concepto</label>
                    <input type="text" class="form-control" name="txtConc" value="" required>
                </div>
                <div class="col-6">
                    <label for="txtRfcEmp" class="form-label">RFC Vendedor</label>
                    <input type="text" class="form-control" name="txtRfcEmp" value="" required>
                </div>
            </div>
            <div class="row mt-5">
                <div class="col-8"></div>
                <div class="col-2">
                    <input type="submit" name="action" class="btn btn-primary px-5" value="Editar" />
                </div>
                <div class="col-2">
                    <a type="button" class="btn btn-danger px-5" href="ValeController?action=show">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <%@ include file = "../footer.jsp" %>

