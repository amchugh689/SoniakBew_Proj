package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.ClientProjectEmpService;
import org.kainos.ea.api.ClientService;
//import org.kainos.ea.cli.Client;
import org.kainos.ea.cli.ClientProjectEmp;
import org.kainos.ea.client.FailedToGetClientProjectListException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api("Soniak Bew API")
@Path("/api")
public class ClientProjectEmpController {
    private ClientProjectEmpService clientProjectEmpService = new ClientProjectEmpService();
    @GET
    @Path("/clients")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientProductEmp() {
        try {
            return Response.ok(clientProjectEmpService.getAllClientProjectEmp()).build();
        } catch (FailedToGetClientProjectListException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }
}
