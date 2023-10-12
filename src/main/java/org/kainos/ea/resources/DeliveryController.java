package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.checkerframework.checker.units.qual.A;
import org.kainos.ea.api.DeliveryService;
import org.kainos.ea.cli.Delivery;
import org.kainos.ea.cli.DeliveryRequest;
import org.kainos.ea.client.FailedToCreateProductException;
import org.kainos.ea.client.InvalidDeliveryException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
@Api("Soniak Bew API")
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
        } catch (FailedToCreateProductException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        } catch (InvalidDeliveryException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}