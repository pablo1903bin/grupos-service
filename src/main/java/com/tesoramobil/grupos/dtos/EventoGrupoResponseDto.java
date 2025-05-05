package com.tesoramobil.grupos.dtos;

public class EventoGrupoResponseDto {
	public String tipoEvento;// Ej. "EXPULSION", "CAMBIO_ROL"
	public String descripcion; // Ej. "Juan fue expulsado del grupo"

	public String usuarioResponsable;
	public String fechaEvento;// nombre o email del autor del evento

	public EventoGrupoResponseDto() {

	}

	public EventoGrupoResponseDto(String tipoEvento, String descripcion, String usuarioResponsable,
			String fechaEvento) {

		this.tipoEvento = tipoEvento;
		this.descripcion = descripcion;
		this.usuarioResponsable = usuarioResponsable;
		this.fechaEvento = fechaEvento;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUsuarioResponsable() {
		return usuarioResponsable;
	}

	public void setUsuarioResponsable(String usuarioResponsable) {
		this.usuarioResponsable = usuarioResponsable;
	}

	public String getFechaEvento() {
		return fechaEvento;
	}

	public void setFechaEvento(String fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	@Override
	public String toString() {
		return "EventoGrupoResponseDto [tipoEvento=" + tipoEvento + ", descripcion=" + descripcion
				+ ", usuarioResponsable=" + usuarioResponsable + ", fechaEvento=" + fechaEvento + "]";
	}

}