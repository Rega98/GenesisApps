<%-- 
    Document   : add
    Created on : 25 nov 2021, 9:42:11
    Author     : uriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp" %>
<%
  int folio = Integer.parseInt((String)request.getAttribute("folio"));  
%>

<div class="container p-5 m-5 bg-white shadow rounded-3">
        <div class="">
            <div class="row">
                <div>
                    <h3>Agregar Observaciones</h3>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <form class="row g-3">                    

                    <div class="col-md-4">
                        <label for="txtFechaObs" class="form-label">Fecha</label>
                        <input type="date" class="form-control" id="txtFechaObs" name="txtFechaobserv" required >
                    </div>
                    <div class="col-md-4">
                        <label for="txtObservacion" class="form-label">Observación</label>
                        <input type="text" class="form-control" id="txtObservacion" name="txtobserobserv" required  minlength="3" maxlength="150" title="Obserción abierta">
                    </div>
                    <div class="col-md-4">
                        <label for="txtFolioCont" class="form-label">Folio de contrato</label>
                        <input type="text" readonly class="form-control" id="txtObservacion" name="txtContratFobserv" value="<%=folio%>" required>
                    </div>
                    <div class="col-6">
                        <input type="submit" name="action" class="btn btn-primary px-3" value="Guardar" />
                        <a type="button" class="btn btn-danger px-3" href="ObservacionController?action=show">Cancelar</a>
                    </div>
                </form>
            </div>
        </div>
 </div>
