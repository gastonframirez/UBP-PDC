package ar.edu.ubp.pdc.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.ubp.pdc.beans.RecursoBean;

/**
 * Servlet implementation class RecursosServlet
 */
@WebServlet("/index.jsp")
public class RecursosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecursosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=iso-8859-1");
		Connection conn;
		Statement stmt;
		ResultSet result;
		
		LinkedList<RecursoBean> recursos = new LinkedList<RecursoBean>();
		RecursoBean r;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "36130801");
			conn.setAutoCommit(true);
			
			stmt = conn.createStatement();
			stmt.executeQuery("select desc_recurso     = desc_recurso, " +
                              "cod_tipo_recurso = cod_tipo_recurso, " +
	                          "tipo_propietario = case when nro_leg_personal is not null " + 
	                          "then 'P' " +
							  "else 'A' " +
						      "end, " +	   
	                          "nro_leg_personal = nro_leg_personal, " +
	                          "nro_area         = nro_area, " +
	                          "vigente          = vigente, " +
	                          "nro_recurso      = nro_recurso " +
                              "from dbo.recursos (nolock) " +
                              "order by desc_recurso");
			
			result = stmt.getResultSet();
			while(result.next()) {
				r = new RecursoBean();
				r.setCodTipoRecurso(result.getString("cod_tipo_recurso"));
				r.setDescRecurso(result.getString("desc_recurso"));
				r.setNroArea(result.getInt("nro_area"));
				r.setNroLegPersonal(result.getInt("nro_leg_personal"));
				r.setNroRecurso(result.getInt("nro_recurso"));
				r.setTipoPropietario(result.getString("tipo_propietario"));
				r.setVigente(result.getString("vigente"));
				recursos.add(r);
			}
			
			stmt.close();
			conn.close();
			
			request.setAttribute("recursos", recursos);
			this.gotoPage("/listado_recursos.jsp", request, response);
		} 
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			this.printError(e.getMessage(), request, response);
		}
	}

	private void printError(String error, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("error", error);
		this.gotoPage("/error.jsp", request, response);
	}

	private void gotoPage(String address, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(address);
		                  dispatcher.forward(request, response);
	}
}