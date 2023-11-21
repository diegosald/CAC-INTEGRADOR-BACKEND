package ar.cac.abm.clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Conexion {
 
	
	public Connection con;
	public Statement stm;
	
	public Conexion (String usuario, String pass , String database) {
		
		
			try {
				this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ database,usuario,pass);
				this.stm = this.con.createStatement(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
			
	}
	
	
	
public  List<Juego> listaJuegos() throws SQLException   {
		
	   ResultSet rs =  this.stm.executeQuery("select * from juegos");
	   ArrayList<Juego> juego = new ArrayList<Juego>();
			
		while (rs.next()){
			
			juego.add(new Juego(rs.getInt(1),rs.getString(2) ,rs.getString(3), rs.getDouble(4) ,rs.getString(5)));
					
		}
		
		
		
		return juego ;
		
	   			
	}

public int eliminarJuego(int id) throws SQLException {
	
	return this.stm.executeUpdate("delete from juegos where id="+ id );
	
}
	
public int agregarJuego(Juego juego) throws SQLException {
	
	String sqlQ	= "insert into juegos (titulo , genero , precio, imgurl) values (?,?,?,?)";
	PreparedStatement stm  =  this.con.prepareStatement(sqlQ);
	
	stm.setString(1, juego.getTitulo());
	stm.setString(2, juego.getGenero());
	stm.setDouble(3, juego.getPrecio());
	stm.setString(4, juego.getImgurl());
	
	
	return stm.executeUpdate();
	
	}	

public int actualizarJuego(Juego juego) throws SQLException {
	String sqlQ;
	PreparedStatement stm = null;
	if (juego.getImgurl().equals("")) {
		sqlQ = "update juegos set titulo = ?, genero = ? , precio = ? where id = ?";
		stm =  this.con.prepareStatement(sqlQ);
			
		stm.setString(1, juego.getTitulo());
		stm.setString(2, juego.getGenero());
		stm.setDouble(3, juego.getPrecio());
		stm.setInt(4, juego.getId());
		}
	else {
		sqlQ = "update juegos set titulo = ?, genero = ? , precio = ? , imgurl = ? where id = ?";
		stm  =  this.con.prepareStatement(sqlQ);
		
		stm.setString(1, juego.getTitulo());
		stm.setString(2, juego.getGenero());
		stm.setDouble(3, juego.getPrecio());
		stm.setString(4, juego.getImgurl());
		stm.setInt(5, juego.getId());
	}
	
	
	
	return stm.executeUpdate();
	
	}
	
	
	
	
	public void cerrarConexion() {
		
		try {
			this.con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Usuario usuarioLog(String user , String pass) {
		
		String sqlQ	= "Select * from usuarios" ;
		PreparedStatement stm;
		Usuario usuarioLog = null;
		
		try {
			stm = this.con.prepareStatement(sqlQ);
			
			ResultSet rs = stm.executeQuery(sqlQ);
			
			while (rs.next()) {
				
				
				if (user.equals(rs.getString(2)) && pass.equals(rs.getString(3)) ) {
					
					
					usuarioLog = new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
					
				}
					
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(usuarioLog.getUsuario());
		return usuarioLog;
				
	}
	public int agregarUsuario(Usuario usuario) throws SQLException {
		
		String sqlQ	= "insert into usuarios (usuario , password , email, rol) values (?,?,?,?)";
		PreparedStatement stm  =  this.con.prepareStatement(sqlQ);
		
		stm.setString(1, usuario.getUser());
		stm.setString(2, usuario.getPass());
		stm.setString(3, usuario.getEmail());
		stm.setString(4, usuario.getRole());
		
		
		return stm.executeUpdate();
		
		}
	
}
