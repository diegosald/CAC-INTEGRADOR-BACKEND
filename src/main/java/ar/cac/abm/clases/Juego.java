package ar.cac.abm.clases;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Juego {

	private int id;
	private String titulo;
	private double precio;
	private String genero;
	private String imgurl;

	public Juego(int id, String titulo, String genero, double precio, String imgurl) {

		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
		this.genero = genero;
		this.imgurl = imgurl;
	}

	public Juego(String titulo, String genero, double precio, String imgurl) {

		this.titulo = titulo;
		this.precio = precio;
		this.genero = genero;
		this.imgurl = imgurl;
	}

	public Juego(int id, String titulo, String genero, double precio) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Juego [id=" + id + ", titulo=" + titulo + ", precio=" + precio + ", genero=" + genero + ", imgurl="
				+ imgurl + "]";
	}

}
