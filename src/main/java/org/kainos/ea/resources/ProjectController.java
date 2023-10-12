package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.ProjectService;
import org.kainos.ea.cli.ProjectRequest;
import org.kainos.ea.client.FailedToUpdateProjectException;
import org.kainos.ea.client.InvalidProjectException;
import org.kainos.ea.client.ProjectDoesNotExistException;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import javax.ws.rs.core.MediaType;

import java.util.List;

@Api("Engineering Academy Dropwizard Product API")
@Path("/api")
public class ProjectController {

    private ProjectService projectService = new ProjectService();

    @PUT
    @Path("/completeproject/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProject(@PathParam("id") int id, ProjectRequest projectRequest ) {
        try {

            projectService.updateProject(id, projectRequest);

            return Response.ok().build();
        } catch (FailedToUpdateProjectException | ProjectDoesNotExistException e) {

            System.err.println(e.getMessage());

            return Response.serverError().build();
        } catch (InvalidProjectException e) {

            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}

