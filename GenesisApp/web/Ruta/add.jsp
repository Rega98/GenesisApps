<%-- 
    Document   : add
    Created on : 25 nov 2021, 9:41:16
    Author     : uriel
--%>

<%@ include file = "../header.jsp" %>

<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="container">
        <div class="row">
            <div>
                <h3>Agregar Ruta</h3>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <form class="row g-3">                    

                <div class="col-md-4">
                    <label for="txtDescRuta" class="form-label">Descripción</label>
                    <input type="text" class="form-control" id="txtDescRuta" name="txtDesRuta" minlength="3" maxlength="150" title="Descripción abierta" required>
                </div>
                <div class="col-md-4">
                    <label for="numRuta" class="form-label">Rutas</label>
                    <input type="number" class="form-control" id="numRuta" name="txtRutasRuta" required>
                </div>

                <div class="col-6">
                    <input type="submit" name="action" class="btn btn-primary px-3" value="Guardar" />

                    <a type="button" class="btn btn-danger px-3" href="RutaController?action=show">Cancelar</a>
                </div>
            </form>
        </div>
    </div>

</div>
<%@ include file = "../footer.jsp" %>