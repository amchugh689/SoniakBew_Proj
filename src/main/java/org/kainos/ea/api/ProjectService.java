package org.kainos.ea.api;

import org.kainos.ea.cli.Project;
import org.kainos.ea.cli.ProjectRequest;
import org.kainos.ea.cli.ProjectTechDel;
import org.kainos.ea.client.*;
import org.kainos.ea.core.ProjectValidator;
import org.kainos.ea.db.ProjectDao;

import javax.validation.constraints.Null;
import java.sql.SQLException;
import java.util.List;

public class ProjectService {

    private ProjectValidator projectValidator = new ProjectValidator();
    private ProjectDao projectDao = new ProjectDao();

    public List<ProjectTechDel> getProjectTechDelivery() throws FailedToGetProjectTechDelException {
        try {
            List<ProjectTechDel> projectList = projectDao.getProjectTechDelivery();

            return projectList;
        } catch (SQLException e) {
            throw new FailedToGetProjectTechDelException();
        }
    }

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
