package org.kainos.ea.resources;


import io.swagger.annotations.Api;
import org.kainos.ea.api.DeliveryProjectService;
import org.kainos.ea.cli.DeliveryProjectRequest;
import org.kainos.ea.client.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("Soniak Bew Project Delivery Link API")
@Path("/api")
public class DeliveryProjectController {
    DeliveryProjectService deliveryProjectService = new DeliveryProjectService();




    @POST
    @Path("/projectdelivery/{id1}_{id2}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDeliveryProject(@PathParam("id1") int projId, @PathParam("id2") int delId) {
        try {
            DeliveryProjectRequest dpr = new DeliveryProjectRequest(projId, delId);
            deliveryProjectService.createDeliveryProject(dpr);
            return Response.ok().build();
        } catch (FailedToCreateDeliveryProjectException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();

        } catch (InvalidDeliveryProjectException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();


        }
    }

    @PUT
    @Path("/projectdelivery")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDeliveryProject(DeliveryProjectRequest der) {
        try {
            deliveryProjectService.updateDeliveryProject(der);
            return Response.ok().build();
        } catch (FailedToUpdateDeliveryProjectException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        } catch (InvalidDeliveryProjectException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }


    }
}
