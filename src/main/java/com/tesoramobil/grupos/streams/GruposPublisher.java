package com.tesoramobil.grupos.streams;

import lombok.AllArgsConstructor;

import java.nio.charset.StandardCharsets;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import com.tesoramobil.grupos.exceptions.KafkaPublicacionException;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;


//Clase responsable de publicar eventos del subdominio "Grupo" a Kafka
//Cada método representa un caso de uso que notifica a otros microservicios
@Component
@AllArgsConstructor
public class GruposPublisher {

 // StreamBridge es el componente de Spring Cloud Stream que nos permite enviar mensajes a Kafka dinámicamente
 private final StreamBridge streamBridge;

 /**
  * Método privado reutilizable para enviar mensajes a Kafka con clave (message key).
  * La clave permite que Kafka mantenga el orden de los mensajes con el mismo valor de clave
  * dentro de una partición.
  *
  * @param bindingName nombre lógico definido en application.yml que representa el destino (topic Kafka)
  * @param mensaje el contenido JSON a enviar como mensaje
  * @param messageKey clave del mensaje (normalmente grupoId o usuarioId) para garantizar orden por entidad
  */
 private void enviarConClave(String bindingName, String mensaje, String messageKey) {
	 
	 try {
		    Message<String> kafkaMessage = MessageBuilder.withPayload(mensaje)
		      .setHeader("kafka_messageKey", messageKey.getBytes(StandardCharsets.UTF_8))
		      .build();

		    boolean enviado = streamBridge.send(bindingName, kafkaMessage);

		    if (!enviado) {
		        String detalle = "No hay binding activo para el canal: " + bindingName;
		 
		        throw new KafkaPublicacionException("Kafka no pudo enviar el mensaje", detalle);
		    }

		} catch (Exception ex) {
		    throw new KafkaPublicacionException("Fallo inesperado al constuir y enviar el mensaje a Kafka", ex);
		}

	}


 /**
  * Publica un evento cuando se crea un grupo.
  * Este evento puede ser consumido por notificaciones, auditoría u otros sistemas.
  *
  * @param grupoId identificador del grupo creado (usado como clave del mensaje)
  * @param mensaje contenido del evento en formato JSON
  */
 public void publicarGrupoCreado(String grupoId, String mensaje) {
     enviarConClave("grupoCreado-out-0", mensaje, grupoId);
 }

 /**
  * Publica una consulta de grupos realizada por un usuario.
  * Este evento puede ser usado para generar estadísticas o alimentar un historial.
  *
  * @param usuarioId ID del usuario que consulta sus grupos (usado como clave)
  * @param mensaje contenido del evento
  */
 public void publicarConsultaGrupos(String usuarioId, String mensaje) {
     enviarConClave("consultaGrupos-out-0", mensaje, usuarioId);
 }

 /**
  * Publica un evento cuando un usuario solicita unirse a un grupo.
  * Puede ser usado para activar notificaciones o procesos de aprobación.
  *
  * @param grupoId ID del grupo al que se desea unir el usuario (clave)
  * @param mensaje contenido del evento
  */
 public void publicarSolicitudUnirseGrupo(String grupoId, String mensaje) {
     enviarConClave("solicitudUnirseGrupo-out-0", mensaje, grupoId);
 }

 /**
  * Publica un evento cuando un usuario ha sido aceptado como miembro de un grupo.
  * Útil para notificaciones o actualización de vistas.
  *
  * @param grupoId ID del grupo al que fue aceptado el usuario
  * @param mensaje contenido del evento
  */
 public void publicarMiembroAceptado(String grupoId, String mensaje) {
     enviarConClave("miembroAceptado-out-0", mensaje, grupoId);
 }

 /**
  * Publica un evento cuando la información de un grupo es modificada.
  * Ideal para sincronizar sistemas o generar alertas.
  *
  * @param grupoId ID del grupo editado
  * @param mensaje contenido del evento
  */
 public void publicarGrupoEditado(String grupoId, String mensaje) {
     enviarConClave("grupoEditado-out-0", mensaje, grupoId);
 }

 /**
  * Publica un evento cuando un grupo es eliminado (soft-delete).
  * Puede ser útil para actualizar búsquedas, vistas o mantener registros históricos.
  *
  * @param grupoId ID del grupo eliminado
  * @param mensaje contenido del evento
  */
 public void publicarGrupoEliminado(String grupoId, String mensaje) {
     enviarConClave("grupoEliminado-out-0", mensaje, grupoId);
 }
}
