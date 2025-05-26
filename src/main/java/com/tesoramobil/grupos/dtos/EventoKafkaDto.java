package com.tesoramobil.grupos.dtos;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventoKafkaDto {

    private String evento; // Ej: "CONSULTA_GRUPOS_USUARIO"
    private String timestamp; // ISO-8601
    private UsuarioOrigen usuarioOrigen;
    //private UsuarioDestino usuarioDestino;
    private Map<String, Object> datos; // Información adicional del evento
    private String descripcion; // Opcional para notificaciones

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UsuarioOrigen {
        private Long id;
        private String nombre;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UsuarioDestino {
        private Long id;
        private String nombre;
    }
}
