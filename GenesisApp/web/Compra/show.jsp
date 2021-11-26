<%-- 
    Document   : show
    Created on : 25 nov 2021, 9:46:37
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
                    <h3>Listado de Compras</h3>
                    <br>
                    <a href="CompraController?action=add" class="btn btn-success" id="btnAdd" role="button">Agregar Compra</a>
                </div>
            </div>
        </div>
        <br>
        <br>
        <div class="container">
            <div class="row">
                <table class="table table-striped">
                    <thead>
                      <tr>
                        <th scope="col">Folio</th>
                        <th scope="col">Fecha</th>
                        <th scope="col">Cantidad</th>
                        <th scope="col">Iva</th>
                        <th scope="col">Monto Total</th>
                        <th scope="col">Estado</th>
                        <th scope="col">RFC de Proovedor</th>
                        <th scope="col">ID producto</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <th scope="row">FO-00-Compra</th>
                        <td>25/11/2021</td>
                        <td>12 Piezas</td>
                        <td>12</td>
                        <td>1200</td>
                        <td>1200</td>
                        <td>XAXA00000XX0</td>
                        <td>12590</td>
                        <td>
                            <a href="CompraController?action=edit" class="btn btn-primary" id="btnEdit" role="button">Editar</a>
                        </td>
                        <td><button type="button" class="btn btn-danger">Eliminar</button></td>
                      </tr>
                    </tbody>
                </table>
             
            </div>
        </div>
    </body>
</html>

