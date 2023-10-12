package org.kainos.ea.client;

public class FailedToCreateDeliveryProjectException extends Throwable {
    @Override
    public String getMessage(){return "an error occurred and the link wasn't created";}
}
