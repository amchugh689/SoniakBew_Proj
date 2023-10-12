package org.kainos.ea.client;

public class FailedToGetProjectTechDelException extends Throwable {
    @Override
    public String getMessage(){
        return "Failed to retrieve Project, Tech Lead, and Delivery list";
    }
}
