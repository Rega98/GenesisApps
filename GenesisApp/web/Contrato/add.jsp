<%-- 
    Document   : add
    Created on : 25 nov 2021, 9:45:06
    Author     : uriel
--%>

<%@page import="Model.Empleado"%>
<%@page import="ModelDAO.EmpleadoDAO"%>
<%@page import="Model.Cliente"%>
<%@page import="ModelDAO.ClienteDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="Model.Contrato"%>
<%@page import="java.util.List"%>
<%@page import="ModelDAO.ContratoDAO"%>
<%@ include file = "../header.jsp" %>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div>
        <div class="row">
            <div>
                <h3>Nuevo Contrato</h3>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <form class="">
                <div class="row my-3">
                    <div class="col-4">
                        <label for="dateFechaCon" class="form-label">Fecha de Contrato</label>
                        <input type="date" class="form-control" id="dateFechaCon" name="dateFechaCon">
                    </div>
                    <div class="col-4">
                        <label for="txtRfcCliCon" class="form-label">Cliente</label>
                        <select class="form-select" aria-label="Default select example" name="">
                            <option selected disabled>Selecciona un cliente</option>
                            <%
                            ClienteDAO cdao = new ClienteDAO();
                            List<Cliente> list = cdao.show();
                            Iterator<Cliente> iter = list.iterator();
                            Cliente clie = null;
                            while(iter.hasNext()){
                                clie = iter.next();
                            %>
                            <option value="<%= clie.getRfc()%>"><%= clie.getNombre()+" "+clie.getApPaterno()+" "+clie.getApMaterno()%></option>
                            <%
                            }
                            %>
                        </select>
                    </div>
                    <div class="col-4">
                        <label for="txtRfcVCon" class="form-label">Vendedor</label>
                        <select class="form-select" name="txtRfcVCon">
                            <option selected disabled>Selecciona un vendedor</option>
                            <%
                            EmpleadoDAO edao = new EmpleadoDAO();
                            List<Empleado> list2 = edao.show();
                            Iterator<Empleado> iter2 = list2.iterator();
                            Empleado vend = null;
                            while(iter2.hasNext()){
                                vend = iter2.next();
                                if(vend.getTipo().equalsIgnoreCase("Vendedor")){
                            %>
                            <option value="<%= vend.getRfc()%>"><%= vend.getNombre()+" "+vend.getApPaterno()+" "+vend.getApMaterno()%></option>
                            <%
                                }
                            }
                            %>
                        </select>
                    </div>
                </div>
                <div class="row my-3">
                    <div class="col-4">
                        <label for="numIdPro" class="form-label">ID de producto</label>
                        <input type="number" class="form-control" id="numIdPro" name="numIdPro">
                    </div>
                    <div class="col-4">
                        <label for="numSubCon" class="form-label">Sub Total</label>
                        <input type="number" class="form-control" id="numSubCon" name="numSubCon">
                    </div>
                </div>
                <div class="col-md-4">
                    <label for="numEngaCon" class="form-label">Engache</label>
                    <input type="number" class="form-control" id="numEngaCon" name="numEngaCon">
                </div>
                <div class="col-md-4">
                    <label for="txtPlanCon" class="form-label">Plan de pago</label>
                    <select class="form-select" name="txtPlanCon">
                        <option selected disabled>Seleccione un plan</option>
                        <option value="Semanal">Semanal</option>
                        <option value="Quincenal">Quincenal</option>
                        <option value="Mensual">Mensual</option>
                    </select>
                </div>
                <div class="col-md-4">
                    <label for="txtDiaCon" class="form-label">D�a de pago</label>
                    <select class="form-select" name="txtDiaCon">
                        <option selected disabled>Seleccione un d�a</option>
                        <option value="Lunes">Lunes</option>
                        <option value="Martes">Martes</option>
                        <option value="Mi�rcoles">Mi�rcoles</option>
                        <option value="Jueves">Jueves</option>
                        <option value="S�bado">S�bado</option>
                    </select>
                </div>
                <!-- No se usa 
                <div class="col-4">
                    <label for="txtEstCon" class="form-label">Estado</label>
                    <input type="text" class="form-control" id="txtEstCon" name="txtEstCon">
                </div>
                -->
                

                <div class="col-4">
                    <label for="numIvaCon" class="form-label">IVA</label>
                    <input type="number" class="form-control" id="numIvaCon" name="numIvaCon">
                </div>
                <div class="col-4">
                    <label for="numTotalCon" class="form-label">Total</label>
                    <input type="number" class="form-control" id="numTotalCon" name="numTotalCon">
                </div>

                <div class="col-4">
                    <label for="numIdRuta" class="form-label">ID de la Ruta</label>
                    <input type="number" class="form-control" id="numIdRuta" name="numIdRuta">
                </div>
                <div class="col-6">
                    <button type="submit" class="btn btn-primary">Agregar</button>

                    <button type="submit" class="btn btn-danger">Cancelar</button>
                </div>
            </form>
        </div>
    </div>
</div>