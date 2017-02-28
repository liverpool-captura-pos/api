package com.liverpool.api.modelos;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @autor: Genaro Bermúdez [25/02/2017]
 * @modificado: Genaro Bermúdez [25/02/2017]
 * @descripción: clase modelo que se utiliza para representar un objeto de tipo Tarjeta
 * @since-versión: 1.0
 */
@Getter
@Setter
@ToString
public class Tarjeta implements Serializable {

	/** Miembros de la clase */
	private static final long serialVersionUID = 8791554885878331341L;
	private String correo;
	private String numero;
	private String estatus;
	private String aceptaBeneficio;

}
