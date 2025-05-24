package com.tesoramobil.grupos.dtos.notification;

import java.time.Instant;

public class ConsultaGruposUsuarioEvent {

    private Long usuarioId;
    private String timestamp;
    private String tipoEvento = "CONSULTA_GRUPOS_USUARIO";
    
    public ConsultaGruposUsuarioEvent() {}

    public ConsultaGruposUsuarioEvent(Long usuarioId) {
        this.usuarioId = usuarioId;
        this.timestamp = Instant.now().toString();
    }

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	@Override
	public String toString() {
		return "ConsultaGruposUsuarioEvent [usuarioId=" + usuarioId + ", timestamp=" + timestamp + ", tipoEvento="
				+ tipoEvento + "]";
	}

}
