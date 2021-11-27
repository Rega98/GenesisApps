<%-- 
    Document   : add
    Created on : 25 nov 2021, 9:46:28
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
                <a class="navbar-brand" href="#">Geminis App | Compras</a>
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
                    <h3>Agregar Compra</h3>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <form class="row g-3">                    
                    <!--<div class="col-md-4">
                      <label for="txtNombre" class="form-label">Nombre</label>
                      <input type="text" class="form-control" id="txtNombre">
                    </div>-->
                    <div class="col-md-4">
                      <label for="txtFecCom" class="form-label">Fecha</label>
                      <input type="date" class="form-control" id="txtAppo" name="txtFecCom">
                    </div>
                    <div class="col-md-4">
                      <label for="numCantidadCom" class="form-label">Cantidad</label>
                      <input type="number" class="form-control" id="NumCantidadCom" name="txtCantCom">
                    </div>
                    <div class="col-md-4">
                       <label for="numberIvaCom" class="form-label">IVA</label>
                       <select class="form-select" aria-label="Default select example" name="txtIvaCom">
                        <option selected>Selecione una opción</option>
                        <option value="1">SI</option>
                        <option value="0">NO</option>
                      </select>
                    </div>
                    <div class="col-6">
                      <label for="numberMontooCom" class="form-label">Monto Total</label>
                      <input type="number" class="form-control" id="numberMonto" name="txtMontotCom">
                    </div>
                    <div class="col-6">
                      <label for="txtEstCom" class="form-label">Estado</label>
                      <input type="text" class="form-control" id="txtEstCom" name="txtEstadoCom">
                    </div>
                    <div class="col-6">
                      <label for="txtProvCom" class="form-label">RFC del profesor</label>
                      <input type="text" class="form-control" id="txtProvCom" name="txtRfcCom">
                    </div>
                    
                    <div class="col-6">
                      <button type="submit" class="btn btn-primary">Agregar</button>

                      <button type="submit" class="btn btn-danger">Cancelar</button>
                    </div>
                </form>
            </div>
        </div>

    </body>
</html>
