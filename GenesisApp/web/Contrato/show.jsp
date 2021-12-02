<%-- 
    Document   : show
    Created on : 25 nov 2021, 9:44:54
    Author     : uriel
--%>
<%@page import="java.util.Iterator"%>
<%@page import="Model.Contrato"%>
<%@page import="java.util.List"%>
<%@page import="ModelDAO.ContratoDAO"%>
<%@ include file = "../header.jsp" %>

<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row">
        <div class="col-10">
            <h3>Listado de Contratos</h3>
        </div>
        <div class="col-2">
            <a href="ContratoController?action=add" class="btn btn-success">Agregar Contrato</a>
        </div>
    </div>
    <div class="row">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Folio</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Cliente</th>
                    <th scope="col">Vendedor</th>
                    <th scope="col">Plan Pago</th>
                    <th scope="col">Total</th>
                    <th scope="col">Estado</th>
                    <th scope="col">Ruta</th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody>
                <%
                    ContratoDAO cdao = new ContratoDAO();
                    List<Contrato> list = cdao.show();
                    Iterator<Contrato> iter = list.iterator();
                    Contrato cont = null;
                    while (iter.hasNext()) {
                        cont = iter.next();
                %>
                <tr>
                    <th scope="row"><%=cont.getFolio()%></th>
                    <td><%=cont.getFechaContrato() %></td>
                    <td><%=cont.getRfcCliente() %></td>
                    <td><%=cont.getRfcVendedor() %></td>
                    <td><%=cont.getDiaCobro()+" - "+cont.getPlanPago() %></td>
                    <td><%=cont.getTotal() %></td>
                    <td><%=cont.getEstado() %></td>
                    <td><%=cont.getIdRuta() %></td>
                    <td>
                        <a class="btn btn-primary" href="ContratoController?action=edit&folio=<%=cont.getFolio()%>">Detalles</a>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
</div>

<%@ include file = "../footer.jsp" %>