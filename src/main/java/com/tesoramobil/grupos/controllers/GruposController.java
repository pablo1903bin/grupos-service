package com.tesoramobil.grupos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tesoramobil.grupos.dtos.GruposPorRolResponseDto;
import com.tesoramobil.grupos.services.GrupoServices;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/grupos") 
public class GruposController {


	@Autowired
	GrupoServices grupoServices;
	
	@Operation(summary = "Listar grupos por rol", description = "Devuelve los grupos en los que el usuario está registrado, agrupados por el rol que tiene en cada uno (ADMINISTRADOR, TESORERO, INVITADO).")
	@GetMapping("/grupos-por-rol/{usuarioId}")
	public GruposPorRolResponseDto listarGruposPorRol(@PathVariable Long usuarioId) {
		return grupoServices.listarGruposPorRol(usuarioId);
	}

	
}
