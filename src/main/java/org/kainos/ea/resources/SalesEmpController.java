package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.SalesEmpService;
import org.kainos.ea.cli.SalesEmp;
import org.kainos.ea.cli.SalesEmpRequest;
import org.kainos.ea.client.FailedToCreateSalesEmpException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Api("Soniak Bew API")
@Path("/api")
public class SalesEmpController {

    SalesEmpService salesEmpService = new SalesEmpService();


    //Task 11. Pretend this isn't here ;)
   /*@GET
    @Path("/salesemps")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSalesEmployees() {
        return "test value";
    }*/

    @POST
    @Path("/salesemps")
    @Produces (MediaType.APPLICATION_JSON)
    public Response createSalesEmp(SalesEmpRequest se) {
        try{
            return Response.ok(salesEmpService.createSalesEmp(se)).build();
        }
        catch (FailedToCreateSalesEmpException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }

    }



}
