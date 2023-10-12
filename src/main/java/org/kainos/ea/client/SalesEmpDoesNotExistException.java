package org.kainos.ea.client;

public class SalesEmpDoesNotExistException extends Throwable {
    @Override
    public String getMessage() { return "The specified Sales Employee does not exist."; }
}
