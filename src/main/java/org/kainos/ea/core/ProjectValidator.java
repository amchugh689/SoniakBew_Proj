package org.kainos.ea.core;

import org.kainos.ea.cli.ProjectRequest;
import org.kainos.ea.db.ProjectDao;

import java.sql.SQLException;

public class ProjectValidator {
    private ProjectDao projectDao = new ProjectDao();
    public String isValidProjectUpdate(ProjectRequest project){


        if (project.getProject_Completed() != 0 && project.getProject_Completed() != 1 ) {
            return "Value for Project_Completed is not valid (valid values are 1 or 0)";
        }

        return null;
    }
}
