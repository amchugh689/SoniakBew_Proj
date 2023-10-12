package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.ProjectService;
import org.kainos.ea.client.*;
import org.kainos.ea.cli.ProjectRequestClientID;
import org.kainos.ea.cli.ProjectRequestCompleted;
import org.kainos.ea.client.FailedToGetProjectsException;
import org.kainos.ea.client.FailedToUpdateProjectException;
import org.kainos.ea.client.InvalidProjectException;
import org.kainos.ea.client.ProjectDoesNotExistException;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import javax.ws.rs.core.MediaType;

import java.util.List;

@Api("Soniak Bew Project Database API")
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
    @Path("/updatecompleteproject/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProjectCompleted(@PathParam("id") int id, ProjectRequestCompleted project) {
        try {

            projectService.updateProjectCompleted(id, project);

            return Response.ok().build();
        } catch (FailedToUpdateProjectException | ProjectDoesNotExistException e) {

            System.err.println(e.getMessage());

            return Response.serverError().build();
        } catch (InvalidProjectException e) {

            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/updateprojectclient/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProjectClient(@PathParam("id") int id, ProjectRequestClientID project) {
        try {

            projectService.updateProjectClient(id, project);

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

