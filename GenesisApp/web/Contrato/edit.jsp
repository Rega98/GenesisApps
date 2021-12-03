<%-- 
    Document   : edit
    Created on : 25 nov 2021, 9:46:06
    Author     : IsmaelSL
--%>

<%@page import="Model.Contrato"%>
<%@page import="ModelDAO.ContratoDAO"%>
<%@page import="Model.Producto"%>
<%@page import="ModelDAO.ProductoDAO"%>
<%@page import="Model.Empleado"%>
<%@page import="ModelDAO.EmpleadoDAO"%>
<%@page import="Model.Cliente"%>
<%@page import="ModelDAO.ClienteDAO"%>
<%@ include file = "../header.jsp" %>
<%
    int folio = Integer.parseInt((String) request.getAttribute("folio"));
    ContratoDAO cdao = new ContratoDAO();
    Contrato con = (Contrato) cdao.details(folio);
    
    ClienteDAO cldao = new ClienteDAO();
    Cliente cli = (Cliente) cldao.details(con.getRfcCliente());
    
    EmpleadoDAO edao = new EmpleadoDAO();
    Empleado emp = (Empleado) edao.details(con.getRfcVendedor());
    
    ProductoDAO pdao = new ProductoDAO();
    Producto pro = (Producto) pdao.details(con.getIdProducto());
%>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <form action="ContratoController">
        <div class="row">
            <div class="col-4">
                <h3>Detalles Contrato #<%=con.getFolio()%></h3>
            </div>
            <div class="col-4">
                <input type="hidden" class="form-control" name="txtFolCont" value="<%=con.getFolio()%>" required>
            </div>
            <div class="col-2">
                <label class="form-label">Ruta</label>
                <br>
                <h4>ID-<%=con.getIdRuta()%></h4>
            </div>
            <div class="col-2">
                <label for="cbxEdoCon" class="form-label">Estado</label>
                <select class="form-select" name="cbxEdoCon">
                    <option value="<%=con.getEstado()%>" selected><%=con.getEstado()%></option>
                    <option value="EN_RUTA">EN RUTA</option>
                    <option value="ABONADO">ABONADO</option>
                    <option value="SALDADO">SALDADO</option>
                    <%  
                        boolean cancel = cdao.cancel(folio);
                        if(cancel==false){
                    %>
                    <option value="CANCELADO">CANCELADO</option>
                    <%
                        }
                    %>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="row mb-3">
                <div class="col-3">
                    <label for="txtRfcCli" class="form-label">RFC Cliente</label>
                    <br>
                    <h4><%=cli.getRfc()%></h4>
                    <input type="hidden" class="form-control" name="txtRfcCli" value="<%=cli.getRfc()%>" required>
                </div>
                <div class="col-4">
                    <label for="txtRfcCli" class="form-label">Nombre Cliente</label>
                    <br>
                    <h4><%=cli.getNombre()+" "+cli.getApPaterno()+" "+cli.getApPaterno()%></h4>
                </div>
                <div class="col-5">
                    <label for="txtRfcCli" class="form-label">Datos Contacto Cliente</label>
                    <br>
                    <h4><%=cli.getCorreo()+" - "+cli.getTelefono()%></h4>
                </div>
            </div>
            <hr>
            <div class="row my-3">
                <div class="col-2">
                    <label for="txtIdPro" class="form-label">ID Producto</label>
                    <br>
                    <h4><%=pro.getId()%></h4>
                    <input type="hidden" class="form-control" name="txtIdPro" value="<%=pro.getId()%>" required>
                </div>
                <div class="col-4">
                    <label class="form-label">Nombre Producto</label>
                    <br>
                    <h4><%=pro.getNombre()%></h4>
                </div>
                <div class="col-4">
                    <label class="form-label">Descripción</label>
                    <br>
                    <h5><%=pro.getDescripcion()%></h5>
                </div>
                <div class="col-2">
                    <label class="form-label">Precio</label>
                    <br>
                    <h4>$ <%=pro.getPrecioVenta()%></h4>
                </div>
            </div>
            <hr>
            <div class="row my-3">
                <div class="col-2">
                    <label for="txtPlaCon" class="form-label">Plan de pago</label>
                    <br>
                    <h4><%=con.getPlanPago() %></h4>
                </div>
                <div class="col-2">
                    <label for="txtDiaCon" class="form-label">Día de pago</label>
                    <br>
                    <h4><%=con.getDiaCobro() %></h4>
                </div>
                <div class="col-2">
                    <label for="numIvaCon" class="form-label">IVA</label>
                    <br>
                    <h4 class="text-warning">$ <%=con.getIva() %></h4>
                </div>
                <div class="col-2">
                    <label for="numSubCon" class="form-label">Sub Total</label>
                    <br>
                    <h4 class="text-primary">$ <%=con.getSubtotal() %></h4>
                </div>
                <div class="col-2">
                    <label for="numEngaCon" class="form-label">Engache</label>
                    <br>
                    <h4 class="text-success">$ <%=con.getEnganche() %></h4>
                </div>
                <div class="col-2">
                    <label for="numTotalCon" class="form-label">Por Pagar</label>
                    <br>
                    <h4 class="text-danger">$ <%=con.getTotal() %></h4>
                </div>
            </div>
            </div>
            <hr>
            <div class="row mt-3">
                <div class="col-8">
                    <label for="txtRfcVen" class="form-label">Vendido Por:</label>
                    <br>
                    <h6><%=emp.getRfc()+" - "+emp.getNombre()+" "+emp.getApPaterno()+" "+emp.getApPaterno()%></h6>
                    <input type="hidden" class="form-control" name="txtRfcVen" value="<%=emp.getRfc()%>" required>
                </div>
                <div class="col-4 mt-3">
                    <input type="submit" name="action" class="btn btn-primary px-5" value="Editar" />
                    <a type="submit" class="btn btn-danger px-5" href="ContratoController?action=show">Regresar</a>
                </div>
            </div>
        </div>
    </form>
</div>
<%@ include file = "../footer.jsp" %>
