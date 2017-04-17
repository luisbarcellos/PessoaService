package br.com.pessoaservice.controller.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import br.com.pessoaservice.controller.v1.RestEndPoint;

@Component
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig{
	public JerseyConfig(){
		super();
		register(RestEndPoint.class);
		packages("io.swagger.jaxrs.json");
	    register(io.swagger.jaxrs.listing.ApiListingResource.class);
	    register(io.swagger.jaxrs.listing.SwaggerSerializers.class);
	}
}