package com.tesoramobil.grupos.dtos;

public class GrupoResumenDto {

	private Long grupoId;
	private String nombre;
	private String descripcion;
	private String rol;

	public GrupoResumenDto() {}

	public GrupoResumenDto(Long grupoId, String nombre, String descripcion, String rol) {
		this.grupoId = grupoId;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.rol = rol;
	}


	public Long getGrupoId() {
		return grupoId;
	}

	public void setGrupoId(Long grupoId) {
		this.grupoId = grupoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}
