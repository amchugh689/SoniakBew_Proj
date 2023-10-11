package org.kainos.ea.client;

public class FailedToCreateSalesEmpException extends Throwable {
    @Override
    public String getMessage(){ return "An error has occurred and the Sales Employee has not been added."; }
}
