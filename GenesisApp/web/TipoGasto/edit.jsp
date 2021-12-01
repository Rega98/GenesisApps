<%-- 
    Document   : show
    Created on : 29 nov. 2021, 01:17:00
    Author     : bardo_3u8azdb
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Model.TipoGasto"%>
<%@page import="ModelDAO.TipoGastoDAO"%>
<%@ include file = "../header.jsp" %>

<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row">
        <div>
            <h3>Editar Tipo Gasto</b></h3>
        </div>
    </div>
    <div class="row">
        <form action="TipoGastoController">
            <div class="row my-3">
                <div class="col-md-3">
                    <label for="txtidtp" class="form-label">Id</label>
                    <br>
                    <h4></h4>
                    <input type="hidden" class="form-control" name="txtidtp" value="" required>
                </div>
                <div class="col-6">
                    <label for="txtDes" class="form-label">Descripcion</label>
                    <input type="text" class="form-control" name="txtDes" value="" required>
                </div>
                <div class="col-3">
                    <label for="txtTGasto" class="form-label">Tipo</label>
                    <input type="text" class="form-control" name="txtTGasto" value="" required>
                </div>
            </div>
                    
            <div class="row my-3">
            <div class="row mt-5">
                <div class="col-8"></div>
                <div class="col-2">
                    <input type="submit" name="action" class="btn btn-primary px-5" value="Editar" />
                </div>
                <div class="col-2">
                    <a type="button" class="btn btn-danger px-5" href="TipoGastoController?action=show">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <%@ include file = "../footer.jsp" %>

