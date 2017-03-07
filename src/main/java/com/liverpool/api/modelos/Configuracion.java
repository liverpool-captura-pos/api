package com.liverpool.api.modelos;

import java.io.Serializable;

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
public class Configuracion implements Serializable {

	/** Miembros de la clase */
	private static final long serialVersionUID = -198028161551430392L;
	private Api api;
	private BaseDatos baseDatos;

	@Getter
	@Setter
	@ToString
	public class Api {
		/** Miembros de la sub-clase */
		private String nombre;
		private String version;
	}

	@Getter
	@Setter
	@ToString
	public class BaseDatos {
		/** Miembros de la sub-clase */
		private String nombre;
		private String host;
		private String puerto;
		private String usuario;
		private String clave;
		private String jndi;
	}

}
