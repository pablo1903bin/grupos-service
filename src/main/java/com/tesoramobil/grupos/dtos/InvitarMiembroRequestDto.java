package com.tesoramobil.grupos.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class InvitarMiembroRequestDto {

	@NotNull
	private Long grupoId;

	@NotBlank
	private String emailInvitado;

	@NotBlank
	private String rolGrupo; // ADMINISTRADOR, TESORERO, INVITADO

	public InvitarMiembroRequestDto() {

	}

	public InvitarMiembroRequestDto(@NotNull Long grupoId, @NotBlank String emailInvitado, @NotBlank String rolGrupo) {
		super();
		this.grupoId = grupoId;
		this.emailInvitado = emailInvitado;
		this.rolGrupo = rolGrupo;
	}

	public Long getGrupoId() {
		return grupoId;
	}

	public void setGrupoId(Long grupoId) {
		this.grupoId = grupoId;
	}

	public String getEmailInvitado() {
		return emailInvitado;
	}

	public void setEmailInvitado(String emailInvitado) {
		this.emailInvitado = emailInvitado;
	}

	public String getRolGrupo() {
		return rolGrupo;
	}

	public void setRolGrupo(String rolGrupo) {
		this.rolGrupo = rolGrupo;
	}

	@Override
	public String toString() {
		return "InvitarMiembroRequestDto [grupoId=" + grupoId + ", emailInvitado=" + emailInvitado + ", rolGrupo="
				+ rolGrupo + "]";
	}

}