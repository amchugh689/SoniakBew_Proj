package org.kainos.ea.client;

public class FailedToDeleteSalesEmpException extends Throwable {
    @Override
    public String getMessage() { return "An error occurred and the Sales Employee was not deleted. "; }
}
