<%-- 
    Document   : show
    Created on : 28 nov. 2021, 01:17:00
    Author     : bardo_3u8azdb
--%>
<%@page import="Model.Empleado"%>
<%@page import="Model.Empleado"%>
<%@page import="ModelDAO.EmpleadoDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Model.TipoGasto"%>
<%@page import="ModelDAO.TipoGastoDAO"%>
<%@page import="ModelDAO.TipoGastoDAO"%>
<%@page import="Model.Gasto"%>
<%@page import="ModelDAO.GastoDAO"%>
<%@ include file = "../header.jsp" %>
<%
    GastoDAO gdao = new GastoDAO();
    int folio = Integer.parseInt((String)request.getAttribute("folio"));

    Gasto gas = (Gasto) gdao.details(folio);
%>

<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row">
        <div>
            <h3>Editar Gasto</b></h3>
        </div>
    </div>
    <div class="row">
        <form action="GastoController">
            <div class="row my-3">
                <div class="col-md-4">
                    <label for="txtFolioCom" class="form-label">Folio</label>
                    <br>
                    <h4><%=gas.getFolio()%></h4>
                    <input type="hidden" class="form-control" name="txtFolio" value="<%=gas.getFolio()%>" required>
                </div>
                <div class="col-3">
                    <label for="txtFecha" class="form-label">Fecha</label>
                    <input type="date" class="form-control" name="txtDateGasto" value="<%=gas.getFecha() %>" required>
                </div>
                <div class="col-6">
                    <label for="txtDef" class="form-label">Definicion</label>
                    <input type="text" class="form-control" name="txtDefGasto" value="<%=gas.getDefinicion()  %>" minlength="3" maxlength="50" title="Descripción abierta" required>
                </div>
            </div>
                    
            <div class="row my-3">
                <div class="col-3">
                    <label for="txtImpiva" class="form-label">Importe con Iva</label>
                    <!--<input type="text" class="form-control" name="txtCivaGasto" value="" required>-->
                    <input type="number" class="form-control" name="txtCivaGasto" value="<%=gas.getImporteCiva()%>" required>
                </div>
                <div class="col-3">
                    <label for="txtImpsiniva" class="form-label">Importe sin Iva</label>
                    <!--<input type="text" class="form-control" name="txtSivaGasto" value="" required>-->
                    <input type="number" class="form-control" name="txtSivaGasto" value="<%=gas.getImporteCiva()%>" required>
                </div>
                 <div class="col-3">
                    <label for="txtTipogas" class="form-label">Tipo gasto</label>
                    <select class="form-select" aria-label="Default select example" name="txtidTipo" value="<%=gas.getIdTipoGasto() %>" required="required">
                            <%
                             TipoGastoDAO tdao = new TipoGastoDAO();
                            List<TipoGasto> list = tdao.show();
                            Iterator<TipoGasto> iter = list.iterator();
                            TipoGasto tipo = null;
                            while(iter.hasNext()){
                                tipo = iter.next();
                            %>
                            <option 
                                <% 
                            if(tipo.getId()== gas.getIdTipoGasto() ){    
                            %>
                            selected
                            <%
                                }
                                %>
                                value="<%= tipo.getId() %>"><%= tipo.getTipo() %></option>
                            <%
                            }
                            %>
                        </select>
                </div>
                <div class="col-3">
                    <label for="txtRfcGer" class="form-label">Rfc Gerente</label>
                    <select class="form-select" aria-label="Default select example" name="txtGerente" value="<%=gas.getRfGerente()  %>" required="required">
                            <%
                             EmpleadoDAO edao = new EmpleadoDAO();
                            List<Empleado> list2 = edao.show2();
                            Iterator<Empleado> iter2 = list2.iterator();
                            Empleado emp = null;
                            while(iter2.hasNext()){
                                emp = iter2.next();
                            %>
                            <option 
                                <% 
                            if(emp.getRfc().equalsIgnoreCase(gas.getRfGerente())  ){    
                            %>
                            selected
                            <%
                                }
                                %>
                                value="<%= emp.getRfc() %>"><%= emp.getNombre() %></option>
                            <%
                            }
                            %>
                        </select>
                </div>
            </div>
                    
            <div class="row mt-5">
                <div class="col-8"></div>
                <div class="col-2">
                    <input type="submit" name="action" class="btn btn-primary px-5" value="Editar" />
                </div>
                <div class="col-2">
                    <a type="button" class="btn btn-danger px-5" href="GastoController?action=show">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <%@ include file = "../footer.jsp" %>

