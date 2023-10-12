package org.kainos.ea.api;

import org.kainos.ea.cli.Project;
import org.kainos.ea.cli.ProjectRequestClientID;
import org.kainos.ea.cli.ProjectRequestCompleted;
import org.kainos.ea.client.FailedToGetProjectsException;
import org.kainos.ea.client.FailedToUpdateProjectException;
import org.kainos.ea.client.InvalidProjectException;
import org.kainos.ea.client.ProjectDoesNotExistException;
import org.kainos.ea.core.ProjectValidator;
import org.kainos.ea.db.ProjectDao;

import java.sql.SQLException;

public class ProjectService {

    private ProjectValidator projectValidator = new ProjectValidator();
    private ProjectDao projectDao = new ProjectDao();

    public Project getProjectById(int id) throws FailedToGetProjectsException, ProjectDoesNotExistException {
        try{
            Project project = projectDao.getProjectById(id);

            if (project == null) {
                throw new ProjectDoesNotExistException();
            }
            return project;
        }catch (SQLException e){
            System.err.println(e.getMessage());

            throw new FailedToGetProjectsException();
        }
    }

    public void updateProjectCompleted(int id, ProjectRequestCompleted project)throws InvalidProjectException,ProjectDoesNotExistException, FailedToUpdateProjectException  {
        try{
            String validation = projectValidator.isValidProjectUpdateCompleted(project);

            if (validation != null){
                throw new InvalidProjectException(validation);
            }

            Project projectToUpdate = projectDao.getProjectById(id);

            if (projectToUpdate == null){
                throw new ProjectDoesNotExistException();
            }

            projectDao.updateProjectCompleted(id, project);
        } catch (SQLException e){
            System.err.println(e.getMessage());
            throw new FailedToUpdateProjectException();
        }

    }

    public void updateProjectClient(int id, ProjectRequestClientID project)throws InvalidProjectException,ProjectDoesNotExistException, FailedToUpdateProjectException  {
        try{

            String validation = projectValidator.isValidProjectUpdateClient(project);

            if (validation != null){
                throw new InvalidProjectException(validation);
            }

            Project projectToUpdate = projectDao.getProjectById(id);

            if (projectToUpdate == null){
                throw new ProjectDoesNotExistException();
            }

            projectDao.updateProjectClient(id, project);
        } catch (SQLException e){
            System.err.println(e.getMessage());
            throw new FailedToUpdateProjectException();
        }

    }
}
