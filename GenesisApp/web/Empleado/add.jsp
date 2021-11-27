<%-- 
    Document   : add
    Created on : 25 nov 2021, 9:43:09
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
                <a class="navbar-brand" href="#">Geminis App | Empleados</a>
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
                    <h3>Agregar Empleado</h3>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <form class="row g-3">                    
                    <div class="col-md-4">
                      <label for="txtNombreEmp" class="form-label">Nombre</label>
                      <input type="text" class="form-control" id="txtNombreEmp" name="txtNombreEmp">
                    </div>
                    <div class="col-md-4">
                      <label for="txtAppoEmp" class="form-label">Apellido Paterno</label>
                      <input type="text" class="form-control" id="txtAppoEmp" name="txtAppoEmp">
                    </div>
                    <div class="col-md-4">
                      <label for="txtApmoEmp" class="form-label">Apellido Materno</label>
                      <input type="text" class="form-control" id="txtApmoEmp" name="txtApmoEmp">
                    </div>
                    <div class="col-6">
                      <label for="txtRfcEmp" class="form-label">RFC</label>
                      <input type="text" class="form-control" id="txtRfcEmp" name="txtRfcEmp">
                    </div>
                    <div class="col-6">
                      <label for="txtUserEmp" class="form-label">Usuario</label>
                      <input type="text" class="form-control" id="txtUserEmp" name="txtUserEmp">
                    </div>
                    <div class="col-6">
                      <label for="pwdEmp" class="form-label">Password</label>
                      <input type="password" class="form-control" id="pwdEmp" name="pwdEmp">
                    </div>
                    <div class="col-md-6">
                        <label for="txtTipoEmp" class="form-label">Tipo de Empleado</label>
                        <select class="form-select" aria-label="Default select example" id="txtTipoEmp" name="txtTipoEmp" >
                            <option selected>Seleccione un tipo</option>
                            <option value="Gerente">Gerente</option>
                            <option value="Vendedor">Vendedor</option>
                            <option value="Cobrador">Cobrador</option>
                        </select>
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

