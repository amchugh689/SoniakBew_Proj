package org.kainos.ea.client;

public class FailedToGetDeliveryException extends Throwable {
    @Override
    public String getMessage() {return "An error has occurred :(" ;}
}