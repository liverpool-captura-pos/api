package com.liverpool.api.servicios;

import java.util.Properties;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.liverpool.api.enumerados.Propiedades;
import com.liverpool.api.modelos.Configuracion;
import com.liverpool.api.tos.ApiTo;
import com.liverpool.api.utilitarios.Utilitario;

import lombok.extern.slf4j.Slf4j;

/**
 * @autor: Genaro Bermúdez [03/03/2017]
 * @modificado: Genaro Bermúdez [03/03/2017]
 * @descripción: clase que realiz operaciones de inicialización de configuraciones de la aplicación
 * @since-versión: 1.0
 */
@ApplicationPath("/app")
@Singleton
@Slf4j
public class Aplicacion extends Application {

	/** Miembros de la clase */
	private static volatile ApiTo apiTo = new ApiTo();

	/** Constructor especializado para iniciar la carga de configuracion */
	public Aplicacion() {
		super();
		cargarPropiedades(apiTo);
		cargarConfiguracion(apiTo);
		Tarjetas.RegistrarInstancia(apiTo);
	}

	/**
	 * @autor: Genaro Bermúdez [03/03/2017]
	 * @modificado: Genaro Bermúdez [03/03/2017]
	 * @descripción: método que permite cargar las propiedades del API
	 */
	private ApiTo cargarPropiedades(ApiTo apiTo) {
		try {
			apiTo.setPropiedadesCargadas(false);
			apiTo.setPropiedades(new Properties());
			apiTo.getPropiedades().load(getClass().getClassLoader().getResourceAsStream("Api.properties"));
			if (apiTo.getPropiedades().isEmpty()) {
				Utilitario.prepararResultado(apiTo, Response.Status.INTERNAL_SERVER_ERROR, apiTo.getPropiedades().getProperty(Propiedades.API_PROPIEDADES_ERROR_001.getClave()));
				return apiTo;
			}
			apiTo.setPropiedadesCargadas(true);
			log.info(apiTo.getPropiedades().getProperty(Propiedades.API_PROPIEDADES_EXITO.getClave()));
		} catch (Exception ex) {
			apiTo.setPropiedadesCargadas(false);
			Utilitario.prepararResultado(apiTo, Response.Status.INTERNAL_SERVER_ERROR, apiTo.getPropiedades().getProperty(Propiedades.API_PROPIEDADES_ERROR_002.getClave()));
			log.error(apiTo.getPropiedades().getProperty(Propiedades.API_PROPIEDADES_ERROR_002.getClave()));
		}
		return apiTo;
	}

	/**
	 * @autor: Genaro Bermúdez [06/03/2017]
	 * @modificado: Genaro Bermúdez [06/03/2017]
	 * @descripción: método que permite cargar la configuración del Api
	 */
	private ApiTo cargarConfiguracion(ApiTo apiTo) {
		try {
			apiTo.setConfiguracionesCargadas(false);
			if (apiTo.getPropiedadesCargadas()) {
				apiTo.setObjectMapper(new ObjectMapper());
				apiTo.setConfiguracion(new ObjectMapper(new YAMLFactory()).readValue(getClass().getClassLoader().getResourceAsStream("configuracion.yml"), Configuracion.class));
				if (apiTo.getConfiguracion() == null) {
					Utilitario.prepararResultado(apiTo, Response.Status.INTERNAL_SERVER_ERROR, apiTo.getPropiedades().getProperty(Propiedades.API_CONFIGURACION_ERROR_001.getClave()));
					return apiTo;
				}
				apiTo.setConfiguracionesCargadas(true);
				log.info(apiTo.getPropiedades().getProperty(Propiedades.API_CONFIGURACION_EXITO.getClave()));
			}
		} catch (Exception ex) {
			apiTo.setConfiguracionesCargadas(false);
			Utilitario.prepararResultado(apiTo, Response.Status.INTERNAL_SERVER_ERROR, apiTo.getPropiedades().getProperty(Propiedades.API_CONFIGURACION_ERROR_002.getClave()));
			log.error(apiTo.getPropiedades().getProperty(Propiedades.API_CONFIGURACION_ERROR_002.getClave()));
		}
		return apiTo;
	}

}
