package com.liverpool.api.enumerados;

import lombok.Getter;

/**
 * @autor: Genaro Bermúdez [26/02/2017]
 * @modificado: Genaro Bermúdez [26/02/2017]
 * @descripción: enumerado que contiene el catálogo de mensajes y constantes de todo el componente
 * @since-versión: 1.0
 */
public enum Propiedades {

	/** Constantes para los estatus del Cliente */
	ESTATUS_SIN_OFRECIMIENTO("0"),
	ESTATUS_TARJETA_NO_MOLESTAR("1"),
	ESTATUS_TARJETA_EMAIL_POR_VALIDAR("2"),
	ESTATUS_TARJETA_EMAIL_VALIDADO("3"),
	ESTATUS_TARJETA_EMAIL_REINTENTO("4"),
	ESTATUS_TARJETA_EMAIL_INCORRECTO("5"),
	ESTATUS_TARJETA_MDM_ENVIO_EXITOSO("6"),
	ESTATUS_TARJETA_MDM_ENVIO_FALLIDO("7"),
	ESTATUS_EFECTIVO_NO_MOLESTAR("8"),
	ESTATUS_EFECTIVO_EMAIL_POR_VALIDAR("9"),
	ESTATUS_EFECTIVO_EMAIL_VALIDADO("10"),
	ESTATUS_EFECTIVO_EMAIL_REINTENTO("11"),
	ESTATUS_EFECTIVO_EMAIL_INCORRECTO("12"),
	ESTATUS_EFECTIVO_MDM_ENVIO_EXITOSO("13"),
	ESTATUS_EFECTIVO_MDM_ENVIO_FALLIDO("14"),
	
	/** Códigos utilizados durante la operación Cargar Configuración */
	API_CONFIGURACION_NOMBRE("API_CONFIGURACION_NOMBRE"),
	API_CONFIGURACION_EXITO_CODIGO("API_CONFIGURACION_EXITO_CODIGO"),
	API_CONFIGURACION_EXITO_MENSAJE("API_CONFIGURACION_EXITO_MENSAJE"),
	API_CONFIGURACION_CODIGO_ERROR_001("API_CONFIGURACION_CODIGO_ERROR_001"),
	API_CONFIGURACION_MENSAJE_ERROR_001("API_CONFIGURACION_MENSAJE_ERROR_001"),
	
	;

	/** Constructor con los valores requeridos en este enumerado */
	Propiedades(String clave) {
		this.clave = clave;
	}

	@Getter
	/** Declaración de miembros privados */
	private String clave;

}
