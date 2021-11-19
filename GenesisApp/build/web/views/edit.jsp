<%-- 
    Document   : edit
    Created on : 10 nov. 2021, 14:46:44
    Author     : ucmex
--%>

<%@page import="Model.Proveedor"%>
<%@page import="ModelDAO.ProveedorDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Editar Proveedor</h1>
        <div>
            <%
                ProveedorDAO pdao = new ProveedorDAO();
                String id = (String)request.getAttribute("idProv");
                
                Proveedor prov = (Proveedor) pdao.details(id);
            %>
            <form action="ProveedorController">
                <label>ID: <%=prov.getId()%></label>
                <input type="hidden" name="txtIdProv" value="<%=prov.getId()%>" />
                <br>
                <label>Nombre: </label>
                <input type="text" name="txtNomProv" value="<%=prov.getNom()%>" />
                <br>
                <input type="submit" name="action" value="Editar" />
            </form>
        </div>
    </body>
</html>
