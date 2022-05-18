package Entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Nacionalidad")
public class Nacionalidad implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_Nacionalidad")
	private Integer ID;
	@Column(name="Descripcion")
	private String Descripcion;
	
	public Nacionalidad() {
		
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Nacionalidad [ID=" + ID + ", Descripcion=" + Descripcion + "]";
	}
	
	
	
}
