package ar.edu.ubp.pdc.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.ubp.pdc.beans.TicketBean;

/**
 * Servlet implementation class tickets
 */
@WebServlet("/tickets.jsp")
public class TicketsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn;
		PreparedStatement stmt;
		ResultSet result;
	
		LinkedList<TicketBean> tickets;
		TicketBean ticket;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "P@55w0rd");
            stmt = conn.prepareStatement("select ticket        = convert(varchar(4), t.año_ticket) + '-' + replicate('0', 5 - len(convert(varchar(5), t.nro_ticket))) + convert(varchar(5), t.nro_ticket),\n" + 
            		"       fecha_ticket  = convert(varchar(10), t.fecha_ticket, 103) + ' ' + convert(varchar(5), t.fecha_ticket, 108), \n" + 
            		"	   solicitante   = s.nom_solicitante,\n" + 
            		"	   asunto_ticket = t.asunto_ticket,\n" + 
            		"	   texto_ticket  = t.texto_ticket\n" + 
            		"  from dbo.tickets t (nolock)\n" + 
            		"       join dbo.solicitantes s (nolock)\n" + 
            		"	     on t.nro_solicitante = s.nro_solicitante\n" + 
            		" where (t.asunto_ticket   like '%' + isnull(ltrim(rtrim(?)), '') + '%'\n" + 
            		"    or  t.texto_ticket    like '%' + isnull(ltrim(rtrim(?)), '') + '%'\n" + 
            		"  	or  s.nom_solicitante like '%' + isnull(ltrim(rtrim(?)), '') + '%')\n" + 
            		" order by case ?\n" + 
            		"               when 'F'\n" + 
            		"			   then convert(varchar(10), t.fecha_ticket, 112) + ' ' + convert(varchar(5), t.fecha_ticket, 108)\n" + 
            		"			   when 'S'\n" + 
            		"			   then s.nom_solicitante\n" + 
            		"			   when 'T'\n" + 
            		"			   then convert(varchar(4), t.año_ticket) + '-' + replicate('0', 5 - len(convert(varchar(5), t.nro_ticket))) + convert(varchar(5), t.nro_ticket)\n" + 
            		"		 end");
           
            stmt.setString(1, request.getParameter("string_busqueda"));
            stmt.setString(2, request.getParameter("string_busqueda"));
            stmt.setString(3, request.getParameter("string_busqueda"));
            stmt.setString(4, request.getParameter("ordernar_por"));
            
            result = stmt.executeQuery();
            tickets = new LinkedList<TicketBean>();
            
            while(result.next()) {
            	ticket = new TicketBean();
            	ticket.setAsuntoTicket(result.getString("asunto_ticket"));
            	ticket.setFechaTicket(result.getString("fecha_ticket"));
            	ticket.setSolicitante(result.getString("solicitante"));
            	ticket.setTextoTicket(result.getString("texto_ticket"));
            	ticket.setTicket(result.getString("ticket"));
            	tickets.add(ticket);
            }
            
            stmt.close();
            conn.close();
            
            request.setAttribute("tickets", tickets);
            gotoPage("/tickets_listado.jsp", request, response);
			
			
		} 
		catch (ClassNotFoundException | SQLException e) {
			response.setStatus(400);
			request.setAttribute("error", e.getMessage());
			gotoPage("/error.jsp", request, response);
		}
		
	}
	
	private void gotoPage(String address, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
		                  dispatcher.forward(request, response);
	}

}
