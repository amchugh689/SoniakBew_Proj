package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.ClientProjectValueService;
import org.kainos.ea.client.FailedToGetClientProjectValueException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("Soniak Bew API")
@Path("/api")
public class ClientProjectValueController {
    private ClientProjectValueService clientProjectValueService = new ClientProjectValueService();
    @GET
    @Path("/clients/projectvalue")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientProjectValue() {
        try {
            return Response.ok(clientProjectValueService.getClientProjectValue()).build();
        } catch (FailedToGetClientProjectValueException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }
}
