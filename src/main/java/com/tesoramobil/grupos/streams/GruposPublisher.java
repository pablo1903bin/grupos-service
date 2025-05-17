package com.tesoramobil.grupos.streams;

import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GruposPublisher {

    private final StreamBridge streamBridge;

    public void publicarMensaje(String mensaje) {
        // Este nombre debe coincidir con tu binding de salida en el application.yml
        streamBridge.send("output", mensaje);

    }
}
