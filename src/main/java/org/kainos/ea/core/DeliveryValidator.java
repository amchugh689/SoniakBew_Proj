package org.kainos.ea.core;

import org.kainos.ea.cli.DeliveryRequest;

public class DeliveryValidator {
    public String isValidDelivery(DeliveryRequest ser) {
        if(ser.getDelivery_Fname().length() > 20 ) {
            return "Forename cannot be longer than 20 characters.";
        }
        if (ser.getDelivery_Lname().length() > 30) {
            return "Surname cannot be longer than 30 characters";
        }
        if(ser.getDelivery_Salary()<0){
            return "Salary must be greater than £0";
        }
        if(ser.getDelivery_BankAcc().length()<9){
            return "Bank Account Number must be at least 9 characters long.";
        }
        if(ser.getDelivery_NINum().length()!= 9){
            return "National insurance number must be 9 characters in the format AB12345C";
        }
        return null;
    }
}
