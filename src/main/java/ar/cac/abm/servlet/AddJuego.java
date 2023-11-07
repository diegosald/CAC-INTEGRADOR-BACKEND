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
 * Servlet implementation class AddDest
 */

@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)
public class AddJuego extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddJuego() {
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
		
		String  titulo = request.getParameter("titulo-txt") ;
		String  genero = request.getParameter("genero-txt") ;
		double  precio =  Double.parseDouble(request.getParameter("precio-txt"));
		Part archivo = request.getPart("file"); //llamada al parámetro foto de mi formulario.
		
		String context = request.getServletContext().getRealPath("images-upload"); //img es la carpeta que he creado en mi proyecto, dentro de la carpeta Web Content.

		String foto = Paths.get(archivo.getSubmittedFileName()).getFileName().toString(); 
        
		
        System.out.println(foto);
		//String fotoName = UPLOAD_DIR + "/" + foto;
   		
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Conexion con = new Conexion("prueba","12345","ventajuegos") ;
		
		try {
			if (0 != con.agregarJuego(new Juego(titulo,genero,precio,foto))) {
				archivo.write(context + "/" + foto); // Escribimos el archivo al disco duro del servidor.
				pw.println("SE AGREGO REGISTRO");
			    pw.println(titulo);
		        
		      
			}
			else {pw.println("NO SE AGREGO");}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pw.print("<meta http-equiv='refresh' content=5;URL='juegos.jsp'>");
		pw.println("<br><br><a href= 'juegos.jsp'>Home</a>");
	}

}
