package com.liverpool.api.utilitarios;

import javax.ws.rs.core.Response;

import com.liverpool.api.tos.ApiTo;

/**
 * @autor: Genaro Bermúdez [26/02/2017]
 * @modificado: Genaro Bermúdez [26/02/2017]
 * @descripción: clase utilizada para servir como utilitarios a todo el componente
 * @since: v.1.0 [26/02/2017]
 */
public class Utilitario {

	/**
	 * @autor: Genaro Bermúdez [25/02/2017]
	 * @modificado: Genaro Bermúdez [25/02/2017]
	 * @descripción: Método que permite prepara un objeto de tipo Resultado
	 */
	public static ApiTo prepararResultado(ApiTo apiTo, Response.Status statusCode, String mensaje) {
		apiTo.getResultado().getStatusCode().setCodigo(statusCode.getStatusCode());
		apiTo.getResultado().getStatusCode().setFrase(statusCode.getReasonPhrase());
		apiTo.getResultado().getStatusCode().setMensaje(mensaje);
		return apiTo;
	}

}
