<%-- 
    Document   : Edit
    Created on : 25 nov 2021, 9:41:35
    Author     : uriel
--%>

<%@page import="Model.Ruta"%>
<%@page import="ModelDAO.RutaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp" %>
<%
    RutaDAO rDAO = new RutaDAO();
    int id = Integer.parseInt((String) request.getAttribute("Id"));

    Ruta ruta = (Ruta) rDAO.details(id);
%>

<div class="container p-5 m-5 bg-white shadow rounded-3" >
    <div class="container">
        <div class="row">
            <div>
                <h3>Editar Ruta</h3>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <form class="row g-3">                    
                <div class="col-md-1">
                    <label for="txtDescRuta" class="form-label">Id</label>
                    <input readonly type="text" class="form-control" id="txtDescRuta" name="txtIdRuta" value="<%=ruta.getIdRuta()%>">
                </div>
                <div class="col-md-4">
                    <label for="txtDescRuta" class="form-label">Descripción</label>
                    <input type="text" class="form-control" id="txtDescRuta" name="txtDesRuta" value="<%=ruta.getDescripcionRuta()%>" minlength="3" maxlength="150" title="Descripción abierta" required>
                </div>
                <div class="col-md-4">
                    <label for="numRuta" class="form-label">Rutas</label>
                    <input type="number" class="form-control" id="numRuta" name="txtRutasRuta" value="<%=ruta.getRutas()%>" required>
                </div>
        </div>
        <br>
        <div class="col-6">
            <input type="submit" name="action" class="btn btn-primary px-3" value="Editar" />

            <a type="button" class="btn btn-danger px-3" href="RutaController?action=show">Cancelar</a>
        </div>
        </form>
    </div>
</div>


</div>




<%@ include file = "../footer.jsp" %>

