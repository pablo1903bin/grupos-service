package com.tesoramobil.grupos.dtos;

import java.util.List;

import com.tesoramobil.grupos.entities.UserEntity;
import lombok.Data;

@Data
public class InvitarMiembroRequestDto {
    private Long grupoId;
    private List<UserEntity> usuarios;
}
