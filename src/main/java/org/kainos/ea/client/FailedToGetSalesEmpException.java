package org.kainos.ea.client;

public class FailedToGetSalesEmpException extends Throwable {
    @Override
    public String getMessage() { return "An error occurred and the Sales Employee was not retrieved."; }
}
