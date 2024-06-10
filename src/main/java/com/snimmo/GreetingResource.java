package com.snimmo;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api")
public class GreetingResource {

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }
    @GET
    @Path("/Show")
    @Produces(MediaType.APPLICATION_JSON)
    public String Show() {
        return "{\"message\":\"Hello from Quarkus REST\"}";
    }

}
