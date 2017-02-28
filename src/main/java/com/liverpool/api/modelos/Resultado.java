package com.liverpool.api.modelos;

import java.io.Serializable;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @autor: Genaro Bermúdez [25/02/2017]
 * @modificado: Genaro Bermúdez [25/02/2017]
 * @descripción: clase modelo que se utiliza para representar un objeto de tipo Resultado
 * @since-versión: 1.0
 */
@Getter
@Setter
@ToString
public class Resultado implements Serializable {

	/** Miembros de la clase */
	private static final long serialVersionUID = -5377974503622804640L;
	private StatusCode statusCode;
	private Negocio negocio;

	/** Método utilizado para convertir desde Objeto a JSON */
	public String toJson(ObjectMapper objectMapper) {
		String json = "";
		try {
			json = objectMapper.writeValueAsString(this);
		} catch (Exception e) {
		}
		return json;
	}

}
