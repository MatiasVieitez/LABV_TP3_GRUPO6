package Entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Libros")
public class Libro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ISBN")
	private String ISBN;
	@Column(name = "Titulo")
	private String Titulo;
	@Column(name = "FechaLanzamiento")
	private Date FechaLanzamiento;
	@Column(name = "Idioma")
	private String Idioma;
	@Column(name = "Paginas")
	private int Paginas;
	@Column(name = "Descripcion")
	private String Descripcion;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "ID_Autor")
	private Autor autor;

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public Date getFechaLanzamiento() {
		return FechaLanzamiento;
	}

	public void setFechaLanzamiento(Date fechaLanzamiento) {
		FechaLanzamiento = fechaLanzamiento;
	}

	public String getIdioma() {
		return Idioma;
	}

	public void setIdioma(String idioma) {
		Idioma = idioma;
	}

	public int getPaginas() {
		return Paginas;
	}

	public void setPaginas(int paginas) {
		Paginas = paginas;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Libro(String iSBN, String titulo, Date fechaLanzamiento, String idioma, int paginas, String descripcion,
			Autor autor) {
		super();
		ISBN = iSBN;
		Titulo = titulo;
		FechaLanzamiento = fechaLanzamiento;
		Idioma = idioma;
		Paginas = paginas;
		Descripcion = descripcion;
		this.autor = autor;
	}

	public Libro() {
	}

}
