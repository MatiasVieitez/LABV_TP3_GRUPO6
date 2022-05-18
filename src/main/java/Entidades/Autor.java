package Entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Autor")
public class Autor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	private Integer ID;
	@Column(name="Nombre") 
	private String Nombre;
	@Column(name="Apellido")
	private String Apellido;
	@Column(name="Nacionalidad")
	private Integer vNacionalidad;
	@Column(name="Email")
	private String Email;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="ID_Nacionalidad")
	private Nacionalidad nacionalidad; 
	
	public Autor() {
		
	}
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	

	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	

	public Integer getvNacionalidad() {
		return vNacionalidad;
	}

	public void setvNacionalidad(Integer vNacionalidad) {
		this.vNacionalidad = vNacionalidad;
	}

	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	@Override
	public String toString() {
		return "Autor [ID=" + ID + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", vNacionalidad=" + vNacionalidad
				+ ", Email=" + Email + ", nacionalidad=" + nacionalidad + "]";
	}

	
	
	
}
