package com.liverpool.api.modelos;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @autor: Genaro Bermúdez [25/02/2017]
 * @modificado: Genaro Bermúdez [25/02/2017]
 * @descripción: clase modelo que se utiliza para representar un objeto de tipo Negocio
 * @since-versión: 1.0
 */
@Getter
@Setter
@ToString
public class Negocio implements Serializable {

	/** Miembros de la clase */
	private static final long serialVersionUID = -5872840850706216899L;
	private Aplicacion aplicacion;
	private Cliente cliente;
	private List<Tarjeta> tarjetas;

}
