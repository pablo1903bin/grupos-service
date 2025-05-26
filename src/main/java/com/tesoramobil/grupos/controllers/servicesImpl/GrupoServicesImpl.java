package com.tesoramobil.grupos.controllers.servicesImpl;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesoramobil.grupos.dtos.CrearGrupoRequestDto;
import com.tesoramobil.grupos.dtos.EditarGrupoRequestDto;
import com.tesoramobil.grupos.dtos.EventoGrupoResponseDto;
import com.tesoramobil.grupos.dtos.EventoKafkaDto;
import com.tesoramobil.grupos.dtos.GrupoResumenDto;
import com.tesoramobil.grupos.dtos.GruposPorRolResponseDto;
import com.tesoramobil.grupos.dtos.InvitarMiembroRequestDto;
import com.tesoramobil.grupos.dtos.MiembroGrupoResponseDto;
import com.tesoramobil.grupos.dtos.notification.ConsultaGruposUsuarioEvent;
import com.tesoramobil.grupos.entities.GrupoEntity;
import com.tesoramobil.grupos.entities.MiembroGrupoEntity;
import com.tesoramobil.grupos.entities.UserEntity;
import com.tesoramobil.grupos.repositories.MiembroGrupoRepository;
import com.tesoramobil.grupos.services.GrupoServices;
import com.tesoramobil.grupos.streams.GruposPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GrupoServicesImpl implements GrupoServices {

	@Autowired
	private MiembroGrupoRepository miembroGrupoRepository;

	@Autowired
	private GruposPublisher publisher;

	@Autowired
	private ObjectMapper objectMapper;

	/**
	 * Lista los grupos a los que pertenece un usuario, agrupados por su rol en cada
	 * grupo.
	 *
	 * <p>
	 * Roles posibles: ADMINISTRADOR, TESORERO, INVITADO.
	 * </p>
	 *
	 * @param usuarioId ID del usuario autenticado.
	 * @return Objeto que contiene tres listas de grupos separados por rol.
	 */
	@Override
	public GruposPorRolResponseDto listarGruposPorRol(Long usuarioId) {
		List<MiembroGrupoEntity> membresias = miembroGrupoRepository.findByUsuario_Id(usuarioId);

		GruposPorRolResponseDto respuesta = new GruposPorRolResponseDto();

		for (MiembroGrupoEntity miembro : membresias) {
			GrupoEntity grupo = miembro.getGrupo();
			String rol = miembro.getRolGrupo();

			GrupoResumenDto resumen = new GrupoResumenDto();
			resumen.setGrupoId(grupo.getId());
			resumen.setNombre(grupo.getNombre());
			resumen.setDescripcion(grupo.getDescripcion());
			resumen.setRol(rol);

			switch (rol) {
			case "ADMINISTRADOR" -> respuesta.addGrupoComoAdmin(resumen);
			case "TESORERO" -> respuesta.addGrupoComoTesorero(resumen);
			case "INVITADO" -> respuesta.addGrupoComoInvitado(resumen);
			}
		}

		// ✅ Intentamos enviar el evento, pero que no afecte el resultado
		notificarConsultaDeGrupos(usuarioId);

		return respuesta;
	}

	@Override
	public GrupoEntity crearGrupo(CrearGrupoRequestDto request, UserEntity usuarioAutenticado) {

		return null;
	}

	@Override
	public GrupoEntity editarGrupo(Long grupoId, EditarGrupoRequestDto request, UserEntity usuarioAutenticado) {

		return null;
	}

	@Override
	public GrupoEntity verDetallesGrupo(Long grupoId, UserEntity usuarioAutenticado) {

		return null;
	}

	@Override
	public void cambiarGrupoActivo(Long grupoId, Long usuarioId) {

	}

	@Override
	public void eliminarGrupo(Long grupoId, UserEntity usuarioAutenticado) {

	}

	@Override
	public void invitarMiembro(InvitarMiembroRequestDto request, UserEntity usuarioAutenticado) {

	}

	@Override
	public void aceptarInvitacion(Long grupoId, UserEntity usuarioAutenticado) {

	}

	@Override
	public void cambiarRolMiembro(Long grupoId, Long usuarioId, String nuevoRol, UserEntity administrador) {

	}

	@Override
	public void expulsarMiembro(Long grupoId, Long usuarioId, UserEntity administrador) {

	}

	@Override
	public List<MiembroGrupoResponseDto> listarMiembros(Long grupoId) {

		return null;
	}

	@Override
	public List<EventoGrupoResponseDto> verHistorialEventos(Long grupoId) {

		return null;
	}

	@Override
	public void archivarGrupo(Long grupoId, UserEntity administrador) {

	}

	@Override
	public byte[] exportarDatos(Long grupoId, String formato, UserEntity usuario) {

		return null;
	}


	
	private void notificarConsultaDeGrupos(Long usuarioId) {
	    try {
	        EventoKafkaDto.UsuarioOrigen origen = new EventoKafkaDto.UsuarioOrigen(usuarioId, "Nombre del usuario"); // Si tienes el nombre, inclúyelo

	        Map<String, Object> datos = new HashMap<>();
	        datos.put("cantidadGrupos", 3); // Ejemplo
	        datos.put("roles", List.of("ADMINISTRADOR", "TESORERO")); // Opcional

	        EventoKafkaDto evento = new EventoKafkaDto(
	            "CONSULTA_GRUPOS_USUARIO",
	            Instant.now().toString(),
	            origen,
	            datos,
	            "El usuario consultó sus grupos"
	        );

	        String json = objectMapper.writeValueAsString(evento);
	        publisher.publicarConsultaGrupos(usuarioId.toString(), json);

	    } catch (Exception e) {
	        // fallback
	    }
	}


}
