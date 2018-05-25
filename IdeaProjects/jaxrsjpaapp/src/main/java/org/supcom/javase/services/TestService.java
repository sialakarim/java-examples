package org.supcom.javase.services;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/test")
@ApplicationScoped
public class TestService {
    @GET
    @Produces("text/plain")
    public Response getClichedMessage(){
        return Response.ok().entity("Hello World from REST Web Service").build();
    }
}
