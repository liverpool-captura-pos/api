package com.liverpool.api.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.liverpool.api.modelos.Aplicacion;
import com.liverpool.api.modelos.Cliente;
import com.liverpool.api.modelos.Negocio;
import com.liverpool.api.modelos.Resultado;
import com.liverpool.api.modelos.StatusCode;
import com.liverpool.api.modelos.Tarjeta;
import com.liverpool.api.tos.ApiTo;

import lombok.extern.slf4j.Slf4j;

@Path("/tarjetas")
@Slf4j
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class Tarjetas {

	/** Miembros de la clase */
	private static volatile ApiTo apiTo;

	/** Intercambio de parámetros */
	public static void RegistrarInstancia(ApiTo apiTo) {
		Tarjetas.apiTo = apiTo;
	}

	@GET
	@Path("/tarjeta/healthCheck")
	public Response isAlive() {

		/** 1.- Ir a BD */

		/** 2.- Ir al GET */

		return Response.status(Response.Status.OK).build();
	}

	@GET
	@Path("/tarjeta/{numero}")
	public Response consultarTarjeta(@Context HttpHeaders header, @PathParam("numero") String numero) {

		log.info("Ha entrado en el recuros Tarjeta en la operación: consultarTarjeta");

		String idAplicacion = header.getHeaderString("idAplicacion");
		String idTienda = header.getHeaderString("idTienda");
		String idBoleta = header.getHeaderString("idBoleta");

		/** 01.- Preparación del Status Code */
		StatusCode statusCode = new StatusCode();
		statusCode.setCodigo(Response.Status.OK.getStatusCode());
		statusCode.setFrase(Response.Status.OK.getReasonPhrase());
		statusCode.setMensaje("Se ha realizado la operación XYZ correctamente");

		/** 02.- Preparación del Pos */
		Aplicacion aplicacion = new Aplicacion();
		aplicacion.setMensaje("¿Desea recibir el beneficio?");

		/** 03.- Preparación del Cliente */
		Cliente cliente = new Cliente();
		cliente.setNombres("Genaro Bermúdez");
		cliente.setApellidos("Bermúdez Bastardo");
		cliente.setCorreo("gbermudez@gmail.com");
		cliente.setNacimiento("04/04/1980");
		cliente.setGenero("M");

		/** 04.- Preparación de las Tarjetas */
		Tarjeta tarjeta = new Tarjeta();
		tarjeta.setCorreo(cliente.getCorreo());
		tarjeta.setNumero(numero);
		tarjeta.setAceptaBeneficio("S");
		List<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
		tarjetas.add(tarjeta);

		/** 05.- Preparación del Negocio */
		Negocio negocio = new Negocio();
		negocio.setAplicacion(aplicacion);
		negocio.setCliente(cliente);
		negocio.setTarjetas(tarjetas);

		/** 06.- Preparación del Resultado */
		Resultado resultado = new Resultado();
		resultado.setStatusCode(statusCode);
		resultado.setNegocio(negocio);

		log.info("Ha finalizado la ejecución del recuro Tarjeta en la operación: consultarTarjeta");

		return Response.status(statusCode.getCodigo()).entity(resultado.toJson(apiTo.getObjectMapper())).build();

	}

	@POST
	@Path("/tarjeta")
	public Response registrarTarjeta(@Context HttpHeaders header, Tarjeta tarjeta) {

		log.info("Ha entrado en el recuros Tarjeta en la operación: consultarTarjeta");

		String idAplicacion = header.getHeaderString("idAplicacion");
		String idTienda = header.getHeaderString("idTienda");
		String idBoleta = header.getHeaderString("idBoleta");

		/** 01.- Preparación del Status Code */
		StatusCode statusCode = new StatusCode();
		statusCode.setCodigo(Response.Status.OK.getStatusCode());
		statusCode.setFrase(Response.Status.OK.getReasonPhrase());
		statusCode.setMensaje("Se ha realizado la operación XYZ correctamente");

		/** 02.- Preparación del Pos */
		Aplicacion aplicacion = new Aplicacion();
		aplicacion.setMensaje("¿Desea recibir el beneficio?");

		/** 03.- Preparación del Cliente */
		Cliente cliente = new Cliente();
		cliente.setNombres("Genaro Bermúdez");
		cliente.setApellidos("Bermúdez Bastardo");
		cliente.setCorreo("gbermudez@gmail.com");
		cliente.setNacimiento("04/04/1980");
		cliente.setGenero("M");

		/** 04.- Preparación de las Tarjetas */
		List<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
		tarjetas.add(tarjeta);

		/** 05.- Preparación del Negocio */
		Negocio negocio = new Negocio();
		negocio.setAplicacion(aplicacion);
		negocio.setCliente(cliente);
		negocio.setTarjetas(tarjetas);

		/** 06.- Preparación del Resultado */
		Resultado resultado = new Resultado();
		resultado.setStatusCode(statusCode);
		resultado.setNegocio(negocio);

		log.info("Ha finalizado la ejecución del recuro Tarjeta en la operación: consultarTarjeta");

		return Response.status(statusCode.getCodigo()).entity(resultado.toJson(apiTo.getObjectMapper())).build();

	}

	@PUT
	@Path("/tarjeta")
	public Response actualizarTarjeta(@Context HttpHeaders header, Tarjeta tarjeta) {

		log.info("Ha entrado en el recuros Tarjeta en la operación: actualizarTarjeta");

		String idAplicacion = header.getHeaderString("idAplicacion");
		String idTienda = header.getHeaderString("idTienda");
		String idBoleta = header.getHeaderString("idBoleta");

		/** 01.- Preparación del Status Code */
		StatusCode statusCode = new StatusCode();
		statusCode.setCodigo(Response.Status.OK.getStatusCode());
		statusCode.setFrase(Response.Status.OK.getReasonPhrase());
		statusCode.setMensaje("Se ha realizado la operación XYZ correctamente");

		/** 02.- Preparación del Pos */
		Aplicacion aplicacion = new Aplicacion();
		aplicacion.setMensaje("¿Desea recibir el beneficio?");

		/** 03.- Preparación del Cliente */
		Cliente cliente = new Cliente();
		cliente.setNombres("Genaro Bermúdez");
		cliente.setApellidos("Bermúdez Bastardo");
		cliente.setCorreo("gbermudez@gmail.com");
		cliente.setNacimiento("04/04/1980");
		cliente.setGenero("M");

		/** 04.- Preparación de las Tarjetas */
		List<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
		tarjetas.add(tarjeta);

		/** 05.- Preparación del Negocio */
		Negocio negocio = new Negocio();
		negocio.setAplicacion(aplicacion);
		negocio.setCliente(cliente);
		negocio.setTarjetas(tarjetas);

		/** 06.- Preparación del Resultado */
		Resultado resultado = new Resultado();
		resultado.setStatusCode(statusCode);
		resultado.setNegocio(negocio);

		log.info("Ha finalizado la ejecución del recuro Tarjeta en la operación: consultarTarjeta");

		return Response.status(statusCode.getCodigo()).entity(resultado.toJson(apiTo.getObjectMapper())).build();

	}

}
