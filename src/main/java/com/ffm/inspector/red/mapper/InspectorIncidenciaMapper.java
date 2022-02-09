package com.ffm.inspector.red.mapper;


import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import com.ffm.inspector.red.component.Configuracion;
import com.ffm.inspector.red.model.input.DetalleIncidencia;
import com.ffm.inspector.red.model.input.RegistroIncidencia;

import feign.Param;



@Mapper
public interface InspectorIncidenciaMapper {
	
	@MapKey("llave")
	public Map<String,Configuracion> consultaConfiguracion(@Param(value = "idPropietario") Integer idPropietario,@Param(value = "idUnidadNegocio") Integer idUnidadNegocio);
	
	int consultaGeografia(String clusterTotalplay);

	int registroIncidencia(RegistroIncidencia inputRegistro);
	
	int registroDetalleIncidente(DetalleIncidencia inputDetalle);
}