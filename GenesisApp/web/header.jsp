<%-- 
    Document   : header
    Created on : 26 nov. 2021, 19:01:15
    Author     : IsmaSL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Grupo Géminis</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    </head>
    <style>
        input[type=number]::-webkit-inner-spin-button, 
        input[type=number]::-webkit-outer-spin-button { 
          -webkit-appearance: none; 
          margin: 0; 
        }
    </style>
    <body style="background-color: #EAEAEA;">
        <nav class="navbar navbar-expand-lg navbar-light bg-white shadow" >
            <div class="container-fluid">
                <a class="navbar-brand" href="/">Geminis App</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                  <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="ContratoController?action=show">Contratos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="ClienteController?action=show">Clientes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="ProductoController?action=show">Productos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="PagoController?action=show">Pago</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="ProveedorController?action=show">Proveedores</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="GastoController?action=show">Gastos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="CompraController?action=show">Compras</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="CalcNomEmplController?action=showEmpl">Nóminas</a>
                        </li>
                         <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="RutaController?action=show">Ruta</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="EmpleadoController?action=show">Empleados</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>