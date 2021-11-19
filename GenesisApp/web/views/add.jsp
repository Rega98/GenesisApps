<%-- 
    Document   : add
    Created on : 10 nov. 2021, 13:15:52
    Author     : ucmex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nuevo Proveedor</h1>
        <div>
            <form action="ProveedorController">
                <label>Nombre: </label>
                <input type="text" name="txtNomProv" placeholder="Escribe el nombre" />
                <br>
                <input type="submit" name="action" value="Guardar" />
            </form>
        </div>
    </body>
</html>
