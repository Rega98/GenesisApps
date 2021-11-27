<%-- 
    Document   : show
    Created on : 25 nov 2021, 9:46:37
    Author     : uriel
--%>
<%@ include file = "../header.jsp" %>

    <div class="container p-5 m-5 bg-white shadow rounded-3">
        <div class="">
            <div class="row">
                <div>
                    <h3>Listado de Compras</h3>
                    <br>
                    <a href="CompraController?action=add" class="btn btn-success">Agregar Compra</a>
                </div>
            </div>
        </div>
        <div class="content">
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

<%@ include file = "../footer.jsp" %>