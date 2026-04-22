package com.hibernate.model;

import jakarta.persistence.*;

@Entity
@Table(name="medicamentos")
public class Medicamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idmedicamentos")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="formato")
	private String formato;
	
	@Column(name="caducidad")
	private String caducidad;
	
	@Column(name="existencias")
	private String existencias;
	
	public Medicamento() {
		super();
	}
	
	public Medicamento(int id, String nombre, String formato, String caducidad, String existencias) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.formato = formato;
		this.caducidad = caducidad;
		this.existencias = existencias;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(String caducidad) {
		this.caducidad = caducidad;
	}

	public String getExistencias() {
		return existencias;
	}

	public void setExistencias(String existencias) {
		this.existencias = existencias;
	}

}
