package org.kainos.ea.api;

import org.kainos.ea.cli.Project;
import org.kainos.ea.cli.ProjectRequest;
import org.kainos.ea.client.FailedToUpdateProjectException;
import org.kainos.ea.client.InvalidProjectException;
import org.kainos.ea.client.ProjectDoesNotExistException;
import org.kainos.ea.core.ProjectValidator;
import org.kainos.ea.db.ProjectDao;

import javax.validation.constraints.Null;
import java.sql.SQLException;

public class ProjectService {

    private ProjectValidator projectValidator = new ProjectValidator();
    private ProjectDao projectDao = new ProjectDao();

    public void updateProject (int id, ProjectRequest project)throws InvalidProjectException,ProjectDoesNotExistException, FailedToUpdateProjectException  {
        try{
            String validation = projectValidator.isValidProjectUpdate(project);

            if (validation != null){
                throw new InvalidProjectException(validation);
            }

            Project projectToUpdate = projectDao.getProjectById(id);

            if (projectToUpdate == null){
                throw new ProjectDoesNotExistException();
            }

            projectDao.updateProject(id, project);
        } catch (SQLException e){
            System.err.println(e.getMessage());
            throw new FailedToUpdateProjectException();
        }

    }
}
