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
import ar.cac.abm.clases.Mensaje;

/**
 * Servlet implementation class DelJuego
 */
public class DelJuego extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelJuego() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Conexion con = new Conexion("prueba", "12345", "ventajuegos");
		Mensaje mensaje = new Mensaje();
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		if (request.getParameter("id") != null) {
			int id = Integer.parseInt(request.getParameter("id"));

			try {
				if (0 != con.eliminarJuego(id)) {
					mensaje.setValor("Error");
					mensaje.setMensaje("SE ELIMINO EL REGISTRO NUMERO " + id);
					pw.println("Se Elimino el registro " + id);
				} else {

					pw.println("No se Elimino Ningun Registro");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			pw.print("<meta http-equiv='refresh' content=5;URL='juegos.jsp'>");
			pw.println("<br><br><a href= 'juegos.jsp'>Home</a>");
		}

		else {

			pw.println("id invalido");
			pw.print("<meta http-equiv='refresh' content=5;URL='juegos.jsp'>");
			pw.println("<br><br><a href= 'juegos.jsp'>Home</a>");

		}

   }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
