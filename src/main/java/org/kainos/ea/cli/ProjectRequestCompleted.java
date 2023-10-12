package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectRequestCompleted {
    private int Project_Completed;
    public int getProject_Completed() {
        return Project_Completed;
    }

    public void setProject_Completed(int project_Completed) {
        Project_Completed = project_Completed;
    }

    @JsonCreator
    public ProjectRequestCompleted(
            //at JSON key "test" accept value x
            // @JsonProperty("test") int x
            //eg "test" : x
            @JsonProperty("Project_Completed") int Project_Completed
    ){
        this.Project_Completed = Project_Completed;
    }
}
