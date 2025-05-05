package com.tesoramobil.grupos.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")

public class GrupoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String categoria;

	@Column(name = "descripcion", columnDefinition = "text")
	private String descripcion;

	@Column(name = "es_publico", nullable = false)
	private Boolean esPublico = true;

	private String estatus = "activo";

	@Column(name = "fecha_actualizacion", nullable = false)
	private LocalDateTime fechaActualizacion;

	@Column(name = "fecha_creacion", nullable = false)
	private LocalDateTime fechaCreacion;

	@Column(name = "max_miembros")
	private Integer maxMiembros;

	@Column(columnDefinition = "jsonb")
	private String metadata;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private String tipo = "escolar";

	private String ubicacion;

	@Column(name = "configuracion_default", columnDefinition = "jsonb")
	private String configuracionDefault;

	private Boolean requiereAprobacion = false;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "creado_por", nullable = false)
	private UserEntity creadoPor;

	@OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MiembroGrupoEntity> miembros = new ArrayList<>();

	public GrupoEntity() {
	}

	public GrupoEntity(Long id, String categoria, String descripcion, Boolean esPublico, String estatus,
			LocalDateTime fechaActualizacion, LocalDateTime fechaCreacion, Integer maxMiembros, String metadata,
			String nombre, String tipo, String ubicacion, String configuracionDefault, Boolean requiereAprobacion,
			UserEntity creadoPor, List<MiembroGrupoEntity> miembros) {

		this.id = id;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.esPublico = esPublico;
		this.estatus = estatus;
		this.fechaActualizacion = fechaActualizacion;
		this.fechaCreacion = fechaCreacion;
		this.maxMiembros = maxMiembros;
		this.metadata = metadata;
		this.nombre = nombre;
		this.tipo = tipo;
		this.ubicacion = ubicacion;
		this.configuracionDefault = configuracionDefault;
		this.requiereAprobacion = requiereAprobacion;
		this.creadoPor = creadoPor;
		this.miembros = miembros;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEsPublico() {
		return esPublico;
	}

	public void setEsPublico(Boolean esPublico) {
		this.esPublico = esPublico;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Integer getMaxMiembros() {
		return maxMiembros;
	}

	public void setMaxMiembros(Integer maxMiembros) {
		this.maxMiembros = maxMiembros;
	}

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getConfiguracionDefault() {
		return configuracionDefault;
	}

	public void setConfiguracionDefault(String configuracionDefault) {
		this.configuracionDefault = configuracionDefault;
	}

	public Boolean getRequiereAprobacion() {
		return requiereAprobacion;
	}

	public void setRequiereAprobacion(Boolean requiereAprobacion) {
		this.requiereAprobacion = requiereAprobacion;
	}

	public UserEntity getCreadoPor() {
		return creadoPor;
	}

	public void setCreadoPor(UserEntity creadoPor) {
		this.creadoPor = creadoPor;
	}

	public List<MiembroGrupoEntity> getMiembros() {
		return miembros;
	}

	public void setMiembros(List<MiembroGrupoEntity> miembros) {
		this.miembros = miembros;
	}

	@Override
	public String toString() {
		return "Grupo [id=" + id + ", categoria=" + categoria + ", descripcion=" + descripcion + ", esPublico="
				+ esPublico + ", estatus=" + estatus + ", fechaActualizacion=" + fechaActualizacion + ", fechaCreacion="
				+ fechaCreacion + ", maxMiembros=" + maxMiembros + ", metadata=" + metadata + ", nombre=" + nombre
				+ ", tipo=" + tipo + ", ubicacion=" + ubicacion + ", configuracionDefault=" + configuracionDefault
				+ ", requiereAprobacion=" + requiereAprobacion + ", creadoPor=" + creadoPor + ", miembros=" + miembros
				+ "]";
	}

}
