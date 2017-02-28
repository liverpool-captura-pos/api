package com.liverpool.api.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liverpool.api.modelos.Aplicacion;
import com.liverpool.api.modelos.Cliente;
import com.liverpool.api.modelos.Negocio;
import com.liverpool.api.modelos.Resultado;
import com.liverpool.api.modelos.StatusCode;
import com.liverpool.api.modelos.Tarjeta;

import lombok.extern.slf4j.Slf4j;

@Path("/clientes")
@Slf4j
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class Clientes {

	private static final ObjectMapper ob = new ObjectMapper();

	public Clientes() {
		super();
		System.out.println("Se ha cargado el constructor");
	}

	@GET
	@Path("/cliente/healthCheck")
	public Response isAlive() {

		/** 1.- Ir a BD */

		/** 2.- Ir al GET */

		return Response.status(Response.Status.OK).build();
	}

	@GET
	@Path("/cliente")
	public Response consultarCliente(@Context HttpHeaders header, @QueryParam("correo") String correo, @QueryParam("numeroTarjeta") String numeroTarjeta) {

		log.info("Ha entrado en el recuros Tarjeta en la operación: consultarCliente");

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
		tarjeta.setNumero(numeroTarjeta);
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

		log.info("Ha finalizado la ejecución del recuro Tarjeta en la operación: consultarCliente");

		return Response.status(statusCode.getCodigo()).entity(resultado.toJson(ob)).build();

	}

	@POST
	@Path("/cliente")
	public Response registrarCliente(@Context HttpHeaders header, Cliente cliente) {

		log.info("Ha entrado en el recuros Tarjeta en la operación: registrarCliente");

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

		/** 03.- Preparación de la Tarjeta */
		Tarjeta tarjeta = new Tarjeta();
		tarjeta.setCorreo(cliente.getCorreo());
		tarjeta.setNumero("324324324");
		tarjeta.setAceptaBeneficio("S");

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

		log.info("Ha finalizado la ejecución del recuro Tarjeta en la operación: registrarCliente");

		return Response.status(statusCode.getCodigo()).entity(resultado.toJson(ob)).build();

	}

	@PUT
	@Path("/cliente")
	public Response actualizarCliente(@Context HttpHeaders header, Cliente cliente) {

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

		/** 03.- Preparación de la Tarjeta */
		Tarjeta tarjeta = new Tarjeta();
		tarjeta.setCorreo(cliente.getCorreo());
		tarjeta.setNumero("324324324");
		tarjeta.setAceptaBeneficio("S");

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

		return Response.status(statusCode.getCodigo()).entity(resultado.toJson(ob)).build();

	}

}
