package org.kainos.ea.resources;

import io.swagger.annotations.Api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Api("Soniak Bew API")
@Path("/api")
public class SalesEmpController {

    //Task 11. Pretend this isn't here ;)
    @GET
    @Path("/salesemp")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSalesEmployees() {
        return "test value";
    }
}
