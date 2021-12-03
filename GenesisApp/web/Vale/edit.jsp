<%-- 
    Document   : edit
    Created on : 30 nov. 2021, 18:41:39
    Author     : bardo_3u8azdb
--%>
<%@page import="java.util.Iterator"%>
<%@page import="Model.Empleado"%>
<%@page import="Model.Empleado"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="ModelDAO.EmpleadoDAO"%>
<%@page import="Model.Vale"%>
<%@page import="ModelDAO.ValeDAO"%>
<%@ include file = "../header.jsp" %>
<%
    ValeDAO vdao = new ValeDAO();
    int folio = Integer.parseInt((String)request.getAttribute("folio"));

    Vale val = (Vale) vdao.details(folio);
%>
<div class="container p-5 m-5 bg-white shadow rounded-3">
    <div class="row">
        <div>
            <h3>Editar Vale</b></h3>
        </div>
    </div>
    <div class="row">
        <form action="ValeController">
            <div class="row my-3">
                <div class="col-4">
                    <label for="txtFolio" class="form-label">Folio</label>
                    <br>
                    <h4><%=val.getFolio()%></h4>
                    <input type="hidden" class="form-control" name="txtFolio" value="<%=val.getFolio()%>" required>
                </div>
                <div class="col-4">
                    <label for="txtMontoval" class="form-label">Monto</label>
                    <input type="text" class="form-control" name="txtMonto" value="<%=val.getMonto()%>" minlength="3" maxlength="20" title="El monto debe estar conformado números" required>
                </div>
                <div class="col-4">
                    <label for="txtFechaval" class="form-label">Fecha Vale</label>
                    <input type="date" class="form-control" name="txtdatevale" value="<%=val.getFechaVale() %>" required>
                </div>
                
            </div>
            <div class="row my-3">
                <div class="col-6">
                    <label for="txtConc" class="form-label">Concepto</label>
                    <input type="text" class="form-control" name="txtConcepto" value="<%=val.getConcepto()%>" minlength="3" maxlength="20" title="El concepto es abierto" required>
                </div>
                <div class="col-6">
                   <label for="txtrfcVendedor" class="form-label">Rfc Vendedor</label>
                    <select class="form-select" aria-label="Default select example" name="txtrfcVendedor" value="<%=val.getRfcVendedor()%>" required="required">
                            <%
                             EmpleadoDAO edao = new EmpleadoDAO();
                            List<Empleado> list = edao.show4();
                            Iterator<Empleado> iter = list.iterator();
                            Empleado emp = null;
                            while(iter.hasNext()){
                                emp = iter.next();
                            %>
                            <option 
                                <% 
                            if(emp.getRfc().equalsIgnoreCase(val.getRfcVendedor())  ){    
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
                    <a type="button" class="btn btn-danger px-5" href="ValeController?action=show">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <%@ include file = "../footer.jsp" %>

