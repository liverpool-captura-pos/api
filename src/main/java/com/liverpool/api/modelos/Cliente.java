package com.liverpool.api.modelos;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @autor: Genaro Bermúdez [25/02/2017]
 * @modificado: Genaro Bermúdez [25/02/2017]
 * @descripción: clase modelo que se utiliza para representar un objeto de tipo Cliente
 * @since-versión: 1.0
 */
@Getter
@Setter
@ToString
public class Cliente implements Serializable {

	/** Miembros de la clase */
	private static final long serialVersionUID = -8764460831543014885L;
	private String correo;
	private String nombres;
	private String apellidos;
	private String nacimiento;
	private String genero;
	private String aceptaBeneficio;
	private String estatus;

}
