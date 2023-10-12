package org.kainos.ea.client;

public class InvalidDeliveryException extends Throwable {
    public InvalidDeliveryException(String error) {
        super(error);
    }
}
