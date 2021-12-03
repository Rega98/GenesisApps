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
<!DOCTYPE html>
<html>
    <head>
        <title>Geminis</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    </head>
    <body>
        

        <br>
        <br>
        <br>
        <br>
        <div class="container">
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
                        <input type="date" class="form-control" id="txtFechaObs" name="txtFechaobserv">
                    </div>
                    <div class="col-md-4">
                        <label for="txtObservacion" class="form-label">Observación</label>
                        <input type="text" class="form-control" id="txtObservacion" name="txtobserobserv">
                    </div>
                    <div class="col-md-4">
                        <label for="txtFolioCont" class="form-label">Folio de contrato</label>
                        <input type="text" readonly class="form-control" id="txtObservacion" name="txtContratFobserv" value="<%=folio%>">
                    </div>
                    <div class="col-6">
                        <input type="submit" name="action" class="btn btn-primary px-3" value="Guardar" />
                        <a type="button" class="btn btn-danger px-3" href="ObservacionController?action=show">Cancelar</a>
                    </div>
                </form>
            </div>
        </div>

    </body>
</html>
