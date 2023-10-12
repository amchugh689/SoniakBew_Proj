package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.ProjectService;
import org.kainos.ea.cli.ProjectRequest;
import org.kainos.ea.client.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import javax.ws.rs.core.MediaType;

import java.util.List;

@Api("Soniak Bew Database API")
@Path("/api")
public class ProjectController {

    private ProjectService projectService = new ProjectService();

    @GET
    @Path("/projecttechdelivery")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrders(){
        try {
            return Response.ok(projectService.getProjectTechDelivery()).build();
        } catch (FailedToGetProjectTechDelException e){
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }

    @GET
    @Path("/projects/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProjectById(@PathParam("id") int id) {
        try {
            return Response.ok(projectService.getProjectById(id)).build();
        } catch (FailedToGetProjectsException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        } catch (ProjectDoesNotExistException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

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

