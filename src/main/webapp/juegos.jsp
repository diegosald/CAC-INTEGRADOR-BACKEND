<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="ar.cac.abm.clases.Juego"%>
<%@ page import="ar.cac.abm.clases.Conexion"%>
<%@ page import="java.sql.SQLException"%>
<%Conexion con;

con = new Conexion("prueba","12345","ventajuegos") ;
//HttpSession var_sesion = request.getSession(); 
//var_sesion.setAttribute("user", "pepito");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SISTEMA DE JUEGOS</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">


</head>
<body>
	<div class="d-flex justify-content-center">
		<h1 class="fw-bolder">ADMINISTRACION DE JUEGOS</h1>
	</div>

	<div class="container">

		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">TITULO</th>
					<th scope="col">GENERO</th>
					<th scope="col">PRECIO</th>
					<th scope="col">IMAGEN</th>
					<th scope="col">ACCIONES</th>
				</tr>
			</thead>
			<tbody>

				<%for( Juego a : con.listaJuegos()) { %>

				<tr>
					<th scope="row"><%=a.getId()%></th>
					<td><%=a.getTitulo() %></td>
					<td><%=a.getGenero() %></td>
					<td><%=a.getPrecio()%></td>
					<td><img src="images-upload/<%=a.getImgurl()%>" alt="<%=a.getImgurl()%>" style="height: 100px"></td>
					<td><a id="btn-eliminar" href="DelJuego?id=<%=a.getId() %>"
						class="btn btn-danger">ELIMINAR</a> <a
						href="juegos.jsp?id=<%=a.getId() %>&titulo=<%=a.getTitulo() %>&genero=<%=a.getGenero() %>&precio=<%=a.getPrecio()%> "
						class="btn btn-success">ACTUALIZAR</a></td>
				</tr>


				<%
}
%>
			</tbody>
		</table>
		<div class="d-flex justify-content-end mb-3">
			<button id="nuevo" class="btn btn-warning" onclick="abrirNuevo()">
				NUEVO</button>
		</div>
	</div>
	<div id="" class="container mb-3">

		<div id="form-nuevo" class="row d-none">
			<div class="col-lg-2"></div>
			<div class="col-lg-8">






				<div class="modal fade" id="exampleModal" tabindex="-1"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">....</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div id="modal-body"
								class="modal-body text-center pb-0 mb-0 fw-bold text-danger">

								<form id="form-action" method="post" action="AddJuego" enctype="multipart/form-data">
									<div
										class="mb-3 d-flex flex-column gap-3 justify-content-spacebetween">

										<input type="text" class="form-control" name="id-txt"
											id="id-txt" placeholder="id" readonly>
										<input type="text" class="form-control" name="titulo-txt"
											id="titulo-txt" placeholder="Titulo">
										<input type="text" class="form-control" name="genero-txt"
											id="genero-txt" placeholder="Genero">
										<input type="text" class="form-control" name="precio-txt"
											id="precio-txt" placeholder="Precio">
									    <input type="file" class="form-control" name="file" id="file" accept=".png,.jpg">
									</div>
									<div class="mb-3">
										<div>
											<button id="btn-enviar" type="submit"
												class="btn btn-success w-100">Enviar</button>
										</div>
										
									</div>

								</form>



							</div>

							
						</div>
					</div>
				</div>
			</div>

			<div class="col-lg-2"></div>



		</div>

	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
	
	<script src="script3.js" type="text/javascript"></script>
	</body>
</html>