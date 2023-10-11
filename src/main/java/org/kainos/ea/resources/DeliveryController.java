package org.kainos.ea.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api")
public class DeliveryController {
    @GET
    @Path("/delivery")
    @Produces(MediaType.APPLICATION_JSON)
    public String getDelivery() {
        return "Replace this with a list of Delivery Employees";
    }
}