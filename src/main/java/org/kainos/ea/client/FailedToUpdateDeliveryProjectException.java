package org.kainos.ea.client;

public class FailedToUpdateDeliveryProjectException extends Throwable {
    @Override
    public String getMessage() {return "An error has occurred and the Delivery Employee-Project link was unable to be updated." ;}
}