package org.kainos.ea.client;

public class ProjectDoesNotExistException extends Throwable {
    @Override
    public String getMessage(){
        return "The Project_ID given does not exist in the database";
    }
}
