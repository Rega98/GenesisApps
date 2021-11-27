<%-- 
    Document   : show
    Created on : 25 nov 2021, 9:44:54
    Author     : uriel
--%>
<%@ include file = "../header.jsp" %>

    <div class="container p-5 m-5 bg-white shadow rounded-3">
        <div class="">
            <div class="row">
                <div>
                    <h3>Listado de Contratos</h3>
                    <br>
                    <a href="ContratoController?action=add" class="btn btn-success">Agregar Contrato</a>
                </div>
            </div>
        </div>
        <div class="">
            <div class="row">
                <table class="table table-striped">
                    <thead>
                      <tr>
                        <th scope="col">Folio</th>
                        <th scope="col">Enganche</th>
                        <th scope="col">Plan de pago</th>
                        <th scope="col">Día de cobro</th>
                        <th scope="col">Estado</th>
                        <th scope="col">Fecha</th>
                        <th scope="col">Subtotal</th>
                        <th scope="col">IVA</th>
                        <th scope="col">Total</th>
                        <th scope="col">RFC de Vendedor</th>
                        <th scope="col">RFC de Cliente</th>
                        <th scope="col">ID producto</th>
                        <th scope="col">Usuario rua</th>
                        <th scope="col"></th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <th scope="row">FT-00-CO</th>
                        <td>10 MIL </td>
                        <td>Plan mensual</td>
                        <td>Viernes</td>
                        <td>Calle 1</td>
                        <td>Por pagar</td>
                        <td>25/11/2021</td>
                        <td>15</td>
                        <td>15 mill</td>
                        <td>REGA980324</td>
                        <td>REGA980324</td>
                        <td>1243</td>
                        <td>Arturo</td>
                        <td>
                            
                            <a href="#" class="btn btn-primary" id="btnEdit" role="button">Editar</a>
                        
                        </td>
                        <td><button type="button" class="btn btn-danger">Eliminar</button></td>
                      </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

<%@ include file = "../footer.jsp" %>