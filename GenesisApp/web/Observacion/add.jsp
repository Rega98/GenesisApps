<%-- 
    Document   : add
    Created on : 25 nov 2021, 9:42:11
    Author     : uriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <nav class="navbar navbar-expand-lg navbar-light bg-light" >
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Geminis App | Observaciones</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <!-- <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                         <li class="nav-item">
                             <a class="nav-link active" aria-current="page" href="ProveedorController?action=show">Proveedores</a>
                         </li>
                         <li class="nav-item">
                             <a class="nav-link active" aria-current="page" href="src/views/">Clientes</a>
                         </li>
                         <li class="nav-item">
                             <a class="nav-link active" aria-current="page" href="#">Productos</a>
                         </li>
                     </ul>
                     <form class="d-flex">
                       <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                       <button class="btn btn-outline-success" type="submit">Search</button>
                     </form>-->
                </div>
            </div>
        </nav>

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
                        <select class="form-select" aria-label="Default select example" id="txtFolioCont" name="txtContratFobserv">
                            <option selected>0</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                        </select>
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
