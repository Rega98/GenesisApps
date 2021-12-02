<%-- 
    Document   : details
    Created on : 30 nov. 2021, 20:26:11
    Author     : IsmaelSL
--%>
<%@ include file = "../header.jsp" %>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row">
        <div>
            <h3>Nuevo Contrato</h3>
        </div>
    </div>
    <div class="row">
        <form action="ContratoController">
            <%
                String fech = (String) request.getAttribute("fech");
                String idCl = (String) request.getAttribute("idCl");
                String idVe = (String) request.getAttribute("idVe");
                String idPr = (String) request.getAttribute("idPr");
                
                System.out.println("view: "+fech+" - "+idCl+" - "+idVe+" - "+idPr);
            %>
        </form>
    </div>
</div>
<%@ include file = "../footer.jsp" %>
