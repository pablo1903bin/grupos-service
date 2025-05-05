package com.tesoramobil.grupos.models;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class MiembroGrupoId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "usuario_id")
	private Long usuarioId;

	@Column(name = "grupo_id")
	private Long grupoId;

	public MiembroGrupoId() {
	}

	public MiembroGrupoId(Long usuarioId, Long grupoId) {
		this.usuarioId = usuarioId;
		this.grupoId = grupoId;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Long getGrupoId() {
		return grupoId;
	}

	public void setGrupoId(Long grupoId) {
		this.grupoId = grupoId;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof MiembroGrupoId))
			return false;
		MiembroGrupoId that = (MiembroGrupoId) o;
		return Objects.equals(usuarioId, that.usuarioId) && Objects.equals(grupoId, that.grupoId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(usuarioId, grupoId);
	}
}
