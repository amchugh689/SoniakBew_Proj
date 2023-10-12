package org.kainos.ea.client;

public class FailedToGetClientProjectListException extends Throwable {
    public String getMessage() {
        return "Failed to get info from the database";
    }
}
