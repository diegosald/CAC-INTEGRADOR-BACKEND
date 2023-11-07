package ar.cac.abm.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.SQLException;

import ar.cac.abm.clases.Conexion;
import ar.cac.abm.clases.Juego;

/**
 * Servlet implementation class ActJuego
 */

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class ActJuego extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActJuego() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		int id = Integer.parseInt(request.getParameter("id-txt"));
		String titulo = request.getParameter("titulo-txt");
		String genero = request.getParameter("genero-txt");
		double precio = Double.parseDouble(request.getParameter("precio-txt"));
		Part archivo = request.getPart("file");

		String context = request.getServletContext().getRealPath("images-upload");

		String foto = Paths.get(archivo.getSubmittedFileName()).getFileName().toString();

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		Conexion con = new Conexion("prueba", "12345", "ventajuegos");
		Juego juegoObj = new Juego(id, titulo, genero, precio, foto);

		System.out.print(juegoObj.getImgurl().equals(""));

		try {

			if (juegoObj.getImgurl().equals("")) {

				if (0 != con.actualizarJuego(juegoObj)) {
					pw.println("SE ACTUALIZO REGISTRO");
					pw.println(id);

				}

				else {
					pw.println("NO SE ACTUALIZO");
				}

			}

			else {

				if (0 != con.actualizarJuego(juegoObj)) {

					archivo.write(context + "/" + foto); // Escribimos el archivo al disco duro del servidor.
					pw.println("SE ACTUALIZO REGISTRO");
					pw.println(id);

				}

				else {
					pw.println("NO SE ACTUALIZO");
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.print("<meta http-equiv='refresh' content=5;URL='juegos.jsp'>");
		pw.println("<br><br><a href= 'juegos.jsp'>Home</a>");

	}

}
