<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.LinkedList,ar.edu.ubp.pdc.beans.TipoCertificadoBean" %>    
<%
@SuppressWarnings("unchecked")
	LinkedList<TipoCertificadoBean> certificados = (LinkedList<TipoCertificadoBean>)request.getAttribute("certificados");
	if(certificados.size()==0){
		out.println("<h1>No hay registos</h1>");
	}
	else{
%>
	 	 <table>

		<thead>
			<tr>
		    	<th>Descripcion certificado</th>
    		</tr>
		</thead>
    	<tbody>

<%      
		
 		for(TipoCertificadoBean c : certificados) {
 			
           	out.println("<tr>");
           	out.println("<td align=\"left\">" + c.getDescTipoCertificado() + "&nbsp;&nbsp;<input type=\"hidden\" name=\"numeroC\" value=\""+c.getNroTipoCertificado()+"\"></td>");
           	out.println("<td> <a name=\"eliminar\" href=\"#\" onclick=\"jMain.eliminar(this)\">eliminar</a> </td>");
            out.println("</tr>");
        }
%>	

		</tbody>
    </table>
    <a id="guardar" href="#" onclick="jMain.guardar()">Guardar</a>
	<a id="cancelar" href="#"  onclick="jMain.cancelar()">Cancelar</a>
<%} %>	