package Entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Genero")
public class Genero implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID")
	private Integer ID;
	@Column(name="Descripcion")
	private String Descripcion;
	public Genero(){}
	//Gets y sets
	public Integer getID() {return ID;}
	public void setID(Integer iD) {ID = iD;}
	public String getDescripcion() {return Descripcion;}
	public void setDescripcion(String descripcion) {Descripcion = descripcion;}
	public void setGenero(String genero) {Descripcion = genero;}

	@Override
	public String toString() {return "Genero [id=" + ID + ", Genero=" + Descripcion + "]";}
	
}
