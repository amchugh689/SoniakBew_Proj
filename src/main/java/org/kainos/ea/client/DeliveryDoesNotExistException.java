package org.kainos.ea.client;

public class DeliveryDoesNotExistException extends Throwable {
    @Override
    public String getMessage() {return "The delivery employee you specified doesnt exist." ;}
}
