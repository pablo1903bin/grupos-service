package com.tesoramobil.grupos.dtos;

public class MiembroGrupoResponseDto {
	public Long usuarioId;
	public String nombre;
	public String apellido;
	public String email;
	public String rol;
	public String telefono;
	public String username;
	public String fechaIngreso;

	public MiembroGrupoResponseDto() {
		super();
	}

	public MiembroGrupoResponseDto(Long usuarioId, String nombre, String apellido, String email, String rol,
			String telefono, String username, String fechaIngreso) {

		this.usuarioId = usuarioId;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.rol = rol;
		this.telefono = telefono;
		this.username = username;
		this.fechaIngreso = fechaIngreso;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public String toString() {
		return "MiembroGrupoResponseDto [usuarioId=" + usuarioId + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", email=" + email + ", rol=" + rol + ", telefono=" + telefono + ", username=" + username
				+ ", fechaIngreso=" + fechaIngreso + "]";
	}

}