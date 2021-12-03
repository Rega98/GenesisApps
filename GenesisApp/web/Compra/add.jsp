<%-- 
    Document   : add
    Created on : 25 nov 2021, 9:46:28
    Author     : uriel
--%>
<%@page import="Model.Producto"%>
<%@page import="ModelDAO.ProductoDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="Model.Proveedor"%>
<%@page import="java.util.List"%>
<%@page import="ModelDAO.ProveedorDAO"%>
<%@ include file = "../header.jsp" %>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="">
        <div class="row">
            <div>
                <h3>Agregar Compra</h3>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <form action="CompraController">
               <div class="row my-3">
                <div class="col-md-4">
                    <label for="txtFecCom" class="form-label">Fecha</label>
                    <input type="date" class="form-control" id="txtAppo" name="txtFecCom" required>
                </div>
                <div class="col-md-4">
                    <label for="numCantidadCom" class="form-label">Cantidad</label>
                    <input type="number" class="form-control" id="NumCantidadCom" name="txtCantCom" min="1" required>
                </div>
                <div class="col-md-4">
                    <label for="numberIvaCom" class="form-label">IVA</label>
                    <select class="form-select" aria-label="Default select example" name="txtIvaCom">
                        <option selected>Selecione una opción</option>
                        <option value="true">SI</option>
                        <option value="false">NO</option>
                    </select>
                </div>
              </div>
              <div class="row my-3">
                <div class="col-md-4">
                    <label for="numberMontooCom" class="form-label">Monto Total</label>
                    <input type="number" class="form-control" id="numberMonto" name="txtMontotCom" min="0" required>
                </div>
                <div class="col-md-4">
                    <label for="txtEstCom" class="form-label">Estado</label>
                    <select class="form-select" name="txtEstadoCom">
                        <option selected disabled>Seleccione un estado</option>
                        <option value="Pendiente">Pendiente</option>
                        <option value="Pagado">Pagado</option>
                    </select>
                </div>
                <div class="col-md-4">
                    <label for="txtProvCom" class="form-label">RFC del proveedor</label>
                    <select class="form-select" aria-label="Default select example" name="txtRfcCom">
                            <option selected disabled>Selecciona un proveedor</option>
                            <%
                            ProveedorDAO pdao = new ProveedorDAO();
                            List<Proveedor> list = pdao.show();
                            Iterator<Proveedor> iter = list.iterator();
                            Proveedor prov = null;
                            while(iter.hasNext()){
                                prov = iter.next();
                            %>
                            <option value="<%= prov.getRfc()%>"><%= prov.getNombre()%></option>
                            <%
                            }
                            %>
                        </select>
                </div>
              </div>
              <div class="row my-3">
                  <div class="col-md-4">
                    <label for="numIdPro" class="form-label">Producto</label>
                    <Select class="form-select" name="txtIdProductoCom" id="numIdPro" onchange="ShowSelected();">
                        <option selected disabled>Selecciona un producto</option>
                        <%
                            ProductoDAO prdao = new ProductoDAO();
                            List<Producto> list3 = prdao.show();
                            Iterator<Producto> iter3 = list3.iterator();
                            Producto prod = null;

                            while (iter3.hasNext()) {
                                prod = iter3.next();
                        %>
                        <option value="<%= prod.getId()%>"><%= prod.getNombre()%></option>
                        <%
                            }
                        %>
                    </Select>
                </div>
              </div>
                        <hr>
                <div class="row mt-5">
                <div class="col-8"></div>
                <div class="col-2">
                    <input type="submit" name="action" class="btn btn-primary px-5" value="Guardar" />
                </div>
                <div class="col-2">
                    <a type="button" class="btn btn-danger px-5" href="CompraController?action=show">Cancelar</a>
                </div>
                </div>
            </form>
        </div>
    </div>
</div>
<%@ include file = "../footer.jsp" %>