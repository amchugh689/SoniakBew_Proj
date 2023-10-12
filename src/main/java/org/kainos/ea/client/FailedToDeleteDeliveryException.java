package org.kainos.ea.client;

public class FailedToDeleteDeliveryException extends Throwable {
    @Override
    public String getMessage() {return "An error has occurred :(" ;}
}