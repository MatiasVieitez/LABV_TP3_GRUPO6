package Entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Biblioteca")
public class Biblioteca implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private Integer ID;
	@Column(name = "Fecha_de_alta")
	private Date FechaDeAlta;
	@Column(name = "Estado")
	private Integer Estado;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "ISBN_LIBRO")
	private Libro libro;

	public Biblioteca() {

	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Date getFechaDeAlta() {
		return FechaDeAlta;
	}

	public void setFechaDeAlta(Date fechaDeAlta) {
		FechaDeAlta = fechaDeAlta;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Integer getEstado() {
		return Estado;
	}

	public void setEstado(Integer estado) {
		Estado = estado;
	}
}
