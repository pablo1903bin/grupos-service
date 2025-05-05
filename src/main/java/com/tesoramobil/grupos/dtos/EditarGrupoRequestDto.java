package com.tesoramobil.grupos.dtos;

public class EditarGrupoRequestDto {
    public String nombre;
    public String descripcion;
    public String ubicacion;
    public String categoria;
    public Integer maxMiembros;
    public Boolean esPublico;
    public Boolean requiereAprobacion;
    public String configuracionDefault;
    
    
    
    
	public EditarGrupoRequestDto() {
		super();
	}




	public EditarGrupoRequestDto(String nombre, String descripcion, String ubicacion, String categoria,
			Integer maxMiembros, Boolean esPublico, Boolean requiereAprobacion, String configuracionDefault) {

		this.nombre = nombre;
		this.descripcion = descripcion;
		this.ubicacion = ubicacion;
		this.categoria = categoria;
		this.maxMiembros = maxMiembros;
		this.esPublico = esPublico;
		this.requiereAprobacion = requiereAprobacion;
		this.configuracionDefault = configuracionDefault;
	}
    
    
    
}