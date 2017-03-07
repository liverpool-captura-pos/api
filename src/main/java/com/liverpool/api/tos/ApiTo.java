package com.liverpool.api.tos;

import java.io.Serializable;
import java.util.Properties;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liverpool.api.modelos.Configuracion;
import com.liverpool.api.modelos.Resultado;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @autor: Genaro Bermúdez [26/02/2017]
 * @modificado: Genaro Bermúdez [26/02/2017]
 * @descripción: clase modelo que se utiliza para representar un objeto de tipo TransferObject
 * @since-versión: 1.0
 */
@Getter
@Setter
@ToString
public class ApiTo implements Serializable {

	/** Miembros de la clase */
	private static final long serialVersionUID = -4823563628249558463L;
	private Boolean propiedadesCargadas;
	private Boolean configuracionesCargadas;
	private Resultado resultado;
	private Configuracion configuracion;
	private Properties propiedades;
	private ObjectMapper objectMapper;

}
