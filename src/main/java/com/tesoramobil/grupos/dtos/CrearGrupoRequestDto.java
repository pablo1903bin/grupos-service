package com.tesoramobil.grupos.dtos;

public class CrearGrupoRequestDto {
	
	
    public String nombre;
    public String descripcion;
    public String tipo;
    public String ubicacion;
    public Boolean esPublico = true;
    public Integer maxMiembros;
    public String categoria;
    public String configuracionDefault;
    public Boolean requiereAprobacion = false;
    
    
	public CrearGrupoRequestDto() {


	}


	public CrearGrupoRequestDto(String nombre, String descripcion, String tipo, String ubicacion, Boolean esPublico,
			Integer maxMiembros, String categoria, String configuracionDefault, Boolean requiereAprobacion) {


		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.ubicacion = ubicacion;
		this.esPublico = esPublico;
		this.maxMiembros = maxMiembros;
		this.categoria = categoria;
		this.configuracionDefault = configuracionDefault;
		this.requiereAprobacion = requiereAprobacion;
	}
    
    
}