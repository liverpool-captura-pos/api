package com.liverpool.api.servicios;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
@Singleton
public class Aplicacion extends Application {

	public Aplicacion() {
		super();
		System.out.println("Se ha cargado el constructor de Aplicacion");
	}

}
