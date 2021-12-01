<%-- 
    Document   : show
    Created on : 29 nov. 2021, 01:17:00
    Author     : bardo_3u8azdb
--%>
<%@page import="Model.TipoGasto"%>
<%@page import="ModelDAO.TipoGastoDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>

<%@ include file = "../header.jsp" %>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row">
        <div>
            <h3>Nuevo Tipo Gasto</h3>
        </div>
    </div>
    <div class="row">
        <form action="TipoGastoController">
            <div class="row my-3">
                <div class="col-6">
                    <label for="txtDes" class="form-label">Descripcion</label>
                    <input type="text" class="form-control" name="txtDesTipoGast" required>
                </div>
                <div class="col-3">
                    <label for="txtTGasto" class="form-label">Tipo</label>
                    <input type="text" class="form-control" name="txtTipoTGast" required>
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
                    <a type="button" class="btn btn-danger px-5" href="TipoGastoController?action=show">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <%@ include file = "../footer.jsp" %>
