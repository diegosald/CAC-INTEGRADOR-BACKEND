package ar.cac.abm.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import ar.cac.abm.clases.Conexion;
import ar.cac.abm.clases.Usuario;

/**
 * Servlet implementation class RegisterUser
 */
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		 
		Usuario usuario = new Usuario(request.getParameter("user-txt"),request.getParameter("pass-txt"),"" ,"user");
				
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		
		
		
		Conexion con = new Conexion("prueba","12345","ventajuegos") ;
		try {
			con.agregarUsuario(usuario);
			pw.println("USUARIO REGISTRADO");
			
			pw.print("<meta http-equiv='refresh' content=5;URL='login.html'>");
			pw.println("<br><br><a href= 'login.html'>Login</a>");
		} catch (SQLException e) {
			pw.println("USUARIO NO REGISTRADO");
			pw.print("<meta http-equiv='refresh' content=5;URL='register.html'>");
			pw.println("<br><br><a href= 'register.html'>Register</a>");
		}
		
		
	}

}
