package org.supcom.javase.services;

import org.supcom.javase.managers.CityManager;
import org.supcom.javase.models.City;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/cities")
@ApplicationScoped
public class CityService {
    @Inject
    private CityManager manager;

    @GET
    @Path("/{id}")
    @Produces("application/xml")
    public Response getById(@PathParam("id")Integer id){
        return Response.ok().entity(manager.findById(id)).build();
    }

    @GET //te5ou
    @Path("/byName/{name}")
    @Produces("application/xml")
    public Response getByName(@PathParam("name")String name){
        List<City> cities = manager.findByName(name);
        final GenericEntity<List<City>> ret = new GenericEntity<>(cities){};
        return Response.ok().entity(ret).build();
    }

    @GET
    @Path("/byCountryCode/{countryCode}")
    @Produces("application/xml")
    public Response getByCountryCode(@PathParam("countryCode")String countryCode){
        List<City> cities = manager.findByCountryCode(countryCode);
        final GenericEntity<List<City>> ret = new GenericEntity<>(cities){};
        return Response.ok().entity(ret).build();
    }

    @POST //add
    @Consumes("application/xml")
    public void create(City city){
        manager.addEntity(city);
    }

    @PUT //update
    @Consumes("application/xml")
    public void update(City city){
        manager.editCity(city);
    }

    @DELETE //remove
    @Consumes("application/xml")
    public void delete(City city){
        manager.removeEntity(city);
    }
}
