package com.tesoramobil.grupos.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.tesoramobil.grupos.models.MiembroGrupoId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import jakarta.persistence.FetchType;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "miembro_grupo")

public class MiembroGrupoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MiembroGrupoId id = new MiembroGrupoId();

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("usuarioId")
	@JoinColumn(name = "usuario_id")
	private UserEntity usuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("grupoId")
	@JoinColumn(name = "grupo_id")
	private GrupoEntity grupo;

	@Column(name = "rol_grupo", nullable = false)
	private String rolGrupo = "INVITADO";

	@Column(name = "fecha_ingreso", nullable = false)
	private LocalDateTime fechaIngreso = LocalDateTime.now();

	public MiembroGrupoEntity() {

	}

	public MiembroGrupoEntity(MiembroGrupoId id, UserEntity usuario, GrupoEntity grupo, String rolGrupo, LocalDateTime fechaIngreso) {
		this.id = id;
		this.usuario = usuario;
		this.grupo = grupo;
		this.rolGrupo = rolGrupo;
		this.fechaIngreso = fechaIngreso;
	}

	public MiembroGrupoId getId() {
		return id;
	}

	public void setId(MiembroGrupoId id) {
		this.id = id;
	}

	public UserEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UserEntity usuario) {
		this.usuario = usuario;
	}

	public GrupoEntity getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoEntity grupo) {
		this.grupo = grupo;
	}

	public String getRolGrupo() {
		return rolGrupo;
	}

	public void setRolGrupo(String rolGrupo) {
		this.rolGrupo = rolGrupo;
	}

	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public String toString() {
		return "MiembroGrupo [id=" + id + ", usuario=" + usuario + ", grupo=" + grupo + ", rolGrupo=" + rolGrupo
				+ ", fechaIngreso=" + fechaIngreso + "]";
	}

}
