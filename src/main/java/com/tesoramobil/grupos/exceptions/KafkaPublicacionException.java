package com.tesoramobil.grupos.exceptions;





public class KafkaPublicacionException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final String detalle;

	
    public KafkaPublicacionException(String mensaje, String detalleTecnico) {
        super(mensaje);
        this.detalle = detalleTecnico;
    }

    public KafkaPublicacionException(String mensaje, Throwable causa) {
        super(mensaje, causa);
        this.detalle = causa.getMessage(); // opcionalmente stacktrace.toString()
    }

    public String getDetalle() {
        return detalle;
    }
}
