package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.SalesEmpService;
import org.kainos.ea.cli.SalesEmp;
import org.kainos.ea.cli.SalesEmpRequest;
import org.kainos.ea.client.FailedToCreateSalesEmpException;
import org.kainos.ea.client.FailedToGetSalesEmpException;
import org.kainos.ea.client.InvalidSalesEmpException;
import org.kainos.ea.client.SalesEmpDoesNotExistException;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Api("Soniak Bew Sales Employee API")
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

    @GET
    @Path("/salesemps/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSalesEmpByID(@PathParam("id") int id) {
        try{
            return Response.ok(salesEmpService.getSalesEmpByID(id)).build();
        }
        catch (FailedToGetSalesEmpException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
        catch (SalesEmpDoesNotExistException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).build();

        }
    }

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
        catch (InvalidSalesEmpException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }

    }





}
