package org.kainos.ea.core;

import org.kainos.ea.cli.ProjectRequestClientID;
import org.kainos.ea.cli.ProjectRequestCompleted;
import org.kainos.ea.db.ProjectDao;

public class ProjectValidator {
    private ProjectDao projectDao = new ProjectDao();
    public String isValidProjectUpdateCompleted(ProjectRequestCompleted project){

        if (project.getProject_Completed() != 0 && project.getProject_Completed() != 1 ) {
            return "Value for Project_Completed is not valid (valid values are 1 or 0)";
        }

        return null;
    }

    public String isValidProjectUpdateClient(ProjectRequestClientID project){

        if (project.getClient_ID() <= 0 ) {
            return "Value for Client_ID is not valid (values must be greater than 0)";
        }

        return null;
    }
}
