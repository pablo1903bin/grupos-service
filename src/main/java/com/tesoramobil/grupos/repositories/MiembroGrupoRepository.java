package com.tesoramobil.grupos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tesoramobil.grupos.entities.MiembroGrupoEntity;
import com.tesoramobil.grupos.models.MiembroGrupoId;

public interface MiembroGrupoRepository extends JpaRepository<MiembroGrupoEntity, MiembroGrupoId> {
	
	//findBy [EntidadRelacionada].[Campo]


    List<MiembroGrupoEntity> findByUsuario_Id(Long usuarioId);
    
    
}
