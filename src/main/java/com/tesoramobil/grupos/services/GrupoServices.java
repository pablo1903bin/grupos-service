package com.tesoramobil.grupos.services;

import com.tesoramobil.grupos.dtos.CrearGrupoRequestDto;
import com.tesoramobil.grupos.dtos.EditarGrupoRequestDto;
import com.tesoramobil.grupos.dtos.EventoGrupoResponseDto;
import com.tesoramobil.grupos.dtos.GruposPorRolResponseDto;
import com.tesoramobil.grupos.dtos.InvitarMiembroRequestDto;
import com.tesoramobil.grupos.dtos.MiembroGrupoResponseDto;
import com.tesoramobil.grupos.entities.GrupoEntity;
import com.tesoramobil.grupos.entities.UserEntity;

import java.util.List;

public interface GrupoServices {

    // 1. Crear grupo
    GrupoEntity crearGrupo(CrearGrupoRequestDto request, UserEntity usuarioAutenticado);

    // 2. Editar información del grupo
    GrupoEntity editarGrupo(Long grupoId, EditarGrupoRequestDto request, UserEntity usuarioAutenticado);

    // 3. Ver detalles del grupo
    GrupoEntity verDetallesGrupo(Long grupoId, UserEntity usuarioAutenticado);

    // 4. Listar grupos del usuario por rol
    GruposPorRolResponseDto listarGruposPorRol(Long usuarioId);

    // 5. Cambiar grupo activo
    void cambiarGrupoActivo(Long grupoId, Long usuarioId);

    // 6. Eliminar grupo (soft delete)
    void eliminarGrupo(Long grupoId, UserEntity usuarioAutenticado);

    // 7. Invitar miembro al grupo
    void invitarMiembro(InvitarMiembroRequestDto request, UserEntity usuarioAutenticado);

    // 8. Aceptar invitación
    void aceptarInvitacion(Long grupoId, UserEntity usuarioAutenticado);

    // 9. Cambiar rol de miembro
    void cambiarRolMiembro(Long grupoId, Long usuarioId, String nuevoRol, UserEntity administrador);

    // 10. Expulsar miembro del grupo
    void expulsarMiembro(Long grupoId, Long usuarioId, UserEntity administrador);

    // 11. Ver miembros del grupo
    List<MiembroGrupoResponseDto> listarMiembros(Long grupoId);

    // 12. Ver historial de eventos (opcional)
    List<EventoGrupoResponseDto> verHistorialEventos(Long grupoId);

    // 13. Archivar grupo
    void archivarGrupo(Long grupoId, UserEntity administrador);

    // 14. Exportar datos del grupo
    byte[] exportarDatos(Long grupoId, String formato, UserEntity usuario);
} 
