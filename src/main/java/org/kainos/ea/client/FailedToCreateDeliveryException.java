package org.kainos.ea.client;

public class FailedToCreateDeliveryException extends Throwable {
    @Override
    public String getMessage() {return "An error has occurred :(" ;}
}