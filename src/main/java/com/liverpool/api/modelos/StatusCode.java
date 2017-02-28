package com.liverpool.api.modelos;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @autor: Genaro Bermúdez [25/02/2017]
 * @modificado: Genaro Bermúdez [25/02/2017]
 * @descripción: clase modelo que se utiliza para representar un objeto de tipo StatusCode
 * @since-versión: 1.0
 */
@Getter
@Setter
@ToString
public class StatusCode implements Serializable {

	/** Miembros de la clase */
	private static final long serialVersionUID = 6754009064214255403L;
	private int codigo;
	private String frase;
	private String mensaje;

}
