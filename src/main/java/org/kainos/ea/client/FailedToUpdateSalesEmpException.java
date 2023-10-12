package org.kainos.ea.client;

public class FailedToUpdateSalesEmpException extends Throwable {
    @Override
    public String getMessage() { return "An error has occurred and the Sales Employee was not updated."; }
}
