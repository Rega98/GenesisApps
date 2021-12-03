<%-- 
    Document   : details
    Created on : 30 nov. 2021, 20:26:11
    Author     : IsmaelSL
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Model.Ruta"%>
<%@page import="ModelDAO.RutaDAO"%>
<%@page import="Model.Producto"%>
<%@page import="ModelDAO.ProductoDAO"%>
<%@page import="Model.Empleado"%>
<%@page import="ModelDAO.EmpleadoDAO"%>
<%@page import="Model.Cliente"%>
<%@page import="ModelDAO.ClienteDAO"%>
<%@ include file = "../header.jsp" %>
<%
    String rfc_c = (String) request.getAttribute("idCl");
    String rfc_e = (String) request.getAttribute("idVe");
    int idPr = Integer.parseInt((String) request.getAttribute("idPr"));
        
    ClienteDAO cdao = new ClienteDAO();
    Cliente cli = (Cliente) cdao.details(rfc_c);
    
    EmpleadoDAO edao = new EmpleadoDAO();
    Empleado emp = (Empleado) edao.details(rfc_e);
    
    ProductoDAO pdao = new ProductoDAO();
    Producto pro = (Producto) pdao.details(idPr);

    float pre = pro.getPrecioVenta();
    double iva;
%>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row">
        <div>
            <h3>Detalles Contrato</h3>
        </div>
    </div>
    <div class="row">
        <form action="ContratoController">
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
                    <select class="form-select" name="txtPlaCon">
                        <option selected disabled>Seleccionar...</option>
                        <option value="Semanal">Semanal</option>
                        <option value="Quincenal">Quincenal</option>
                        <option value="Mensual">Mensual</option>
                    </select>
                </div>
                <div class="col-2">
                    <label for="txtDiaCon" class="form-label">Día de pago</label>
                    <select class="form-select" name="txtDiaCon">
                        <option selected disabled>Seleccionar...</option>
                        <option value="Lunes">Lunes</option>
                        <option value="Martes">Martes</option>
                        <option value="Miércoles">Miércoles</option>
                        <option value="Jueves">Jueves</option>
                        <option value="Sábado">Sábado</option>
                    </select>
                </div>
                <div class="col-2">
                    <%
                    if(pro.getIva()){
                        iva = pre * 0.16;
                    %>
                    <label for="numIvaCon" class="form-label">IVA (16%)</label>
                    <div class="input-group">
                        <span class="input-group-text">$</span>
                        <input type="number" class="form-control" value="<%=iva%>" disabled>
                        <input type="hidden" name="numIvaCon" value="<%=iva%>">

                    </div>
                    <%
                    } else {
                        iva = 0.0;
                    %>
                    <label for="numIvaCon" class="form-label">IVA (0%)</label>
                    <div class="input-group">
                        <span class="input-group-text">$</span>
                        <input type="number" class="form-control" value="<%=iva%>" disabled>
                        <input type="hidden" name="numIvaCon" value="<%=iva%>">
                    </div>
                    <%
                    }

                    double sub = pre + iva;
                    %>
                </div>
                <div class="col-2">
                    <label for="numSubCon" class="form-label">Sub Total</label>
                    <div class="input-group">
                        <span class="input-group-text">$</span>
                        <input type="number" class="form-control" id="numSubCon" value="<%=sub%>" disabled>
                        <input type="hidden" name="numSubCon" value="<%=sub%>">
                    </div>
                </div>
                <div class="col-2">
                    <label for="numEngaCon" class="form-label">Engache</label>
                    <div class="input-group">
                        <span class="input-group-text">$</span>
                        <input type="number" class="form-control" id="numEngaCon" name="numEngaCon" onchange="Calculo();" required>
                    </div>
                </div>
                <div class="col-2">
                    <label for="numTotalCon" class="form-label">Por pagar</label>
                    <div class="input-group">
                        <span class="input-group-text">$</span>
                        <input type="number" class="form-control" id="val" disabled>
                        <input type="hidden" id="numTotCon" name="numTotCon">
                    </div>
                </div>
            </div>
            <hr>
            <div class="row mt-3">
                <div class="col-4">
                    <label for="txtRfcVen" class="form-label">Vendido Por:</label>
                    <br>
                    <h6><%=emp.getRfc()+" - "+emp.getNombre()+" "+emp.getApPaterno()+" "+emp.getApPaterno()%></h6>
                    <input type="hidden" class="form-control" name="txtRfcVen" value="<%=emp.getRfc()%>" required>
                </div>
                <div class="col-2 mt-3">
                    <select class="form-select" name="cbxIdRuta" required>
                        <option selected disabled>Ruta Cobro...</option>
                        <%
                            RutaDAO rdao = new RutaDAO();
                            List<Ruta> list = rdao.show();
                            Iterator<Ruta> iter = list.iterator();
                            Ruta rut = null;
                            while(iter.hasNext()){
                                rut = iter.next();
                        %>
                        <option value="<%=rut.getIdRuta()%>"><%=rut.getIdRuta()%></option>
                        <% 
                            }
                        %>
                    </select>
                </div>
                <div class="col-2"></div>
                <div class="col-4 mt-3">
                    <input type="submit" name="action" class="btn btn-primary px-5" value="Guardar" />
                    <a type="submit" class="btn btn-danger px-5" href="ContratoController?action=add">Regresar</a>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    function Calculo(){
        var sub = document.getElementById("numSubCon").value;
        var eng = document.getElementById("numEngaCon").value;
        
        if(eng <= sub) {
            document.getElementById("val").value = (sub - eng);
            document.getElementById("numTotCon").value = (sub - eng);
        } else {
            alert("El -Enganche- no puede ser mayor al -SubTotal- de la compra.");
        }
    }
</script>
<%@ include file = "../footer.jsp" %>
