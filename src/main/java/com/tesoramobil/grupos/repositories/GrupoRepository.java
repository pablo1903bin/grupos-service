package com.tesoramobil.grupos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tesoramobil.grupos.entities.GrupoEntity;
import com.tesoramobil.grupos.entities.UserEntity;

public interface GrupoRepository extends JpaRepository<GrupoEntity, Long> {
    List<GrupoEntity> findByCreadoPor(UserEntity userId);
    
}
