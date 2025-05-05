package com.tesoramobil.grupos.dtos;

import java.util.ArrayList;
import java.util.List;

public class GruposPorRolResponseDto {

	private List<GrupoResumenDto> gruposComoAdmin = new ArrayList<>();
	private List<GrupoResumenDto> gruposComoTesorero = new ArrayList<>();
	private List<GrupoResumenDto> gruposComoInvitado = new ArrayList<>();

	public GruposPorRolResponseDto() {}

	public List<GrupoResumenDto> getGruposComoAdmin() {
		return gruposComoAdmin;
	}

	public List<GrupoResumenDto> getGruposComoTesorero() {
		return gruposComoTesorero;
	}

	public List<GrupoResumenDto> getGruposComoInvitado() {
		return gruposComoInvitado;
	}

	// Métodos para agregar si quieres
	public void addGrupoComoAdmin(GrupoResumenDto grupo) {
		gruposComoAdmin.add(grupo);
	}

	public void addGrupoComoTesorero(GrupoResumenDto grupo) {
		gruposComoTesorero.add(grupo);
	}

	public void addGrupoComoInvitado(GrupoResumenDto grupo) {
		gruposComoInvitado.add(grupo);
	}
}
