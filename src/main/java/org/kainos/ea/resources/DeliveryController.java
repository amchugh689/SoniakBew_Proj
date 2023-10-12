package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.DeliveryService;
import org.kainos.ea.cli.Delivery;
import org.kainos.ea.cli.DeliveryRequest;
import org.kainos.ea.client.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
@Api("Soniak Bew Delivery Employee API")
@Path("/api")
public class DeliveryController {
    private DeliveryService deliveryService = new DeliveryService();
    @GET
    @Path("/delivery")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Delivery> getDelivery() throws SQLException {
        return deliveryService.getAllDeliverys();
    }

    @POST
    @Path("/delivery")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDelivery(DeliveryRequest delivery) {
        try {
            return Response.ok(deliveryService.createDelivery(delivery)).build();
        } catch (FailedToCreateDeliveryException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        } catch (InvalidDeliveryException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/delivery/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeliveryById(@PathParam("id") int id) {
        try {
            return Response.ok(deliveryService.getDeliveryById(id)).build();
        } catch (FailedToGetDeliveryException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        } catch (DeliveryDoesNotExistException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("/delivery/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDelivery(@PathParam("id") int id, DeliveryRequest delivery) {
        try {
            deliveryService.updateDelivery(id, delivery);

            return Response.ok().build();
        } catch (InvalidDeliveryException | DeliveryDoesNotExistException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (FailedToUpdateDeliveryException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }
    @DELETE
    @Path("/delivery/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDelivery(@PathParam("id") int id) {
        try {
            deliveryService.deleteDelivery(id);

            return Response.ok().build();
        } catch (DeliveryDoesNotExistException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (FailedToDeleteDeliveryException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }
}