package org.kainos.ea.core;

import org.kainos.ea.cli.SalesEmpRequest;

public class SalesEmpValidator {
    public String isValidSalesEmp(SalesEmpRequest ser) {
        if(ser.getSales_Fname().length() > 20 ) {
            return "Forename cannot be longer than 20 characters.";
        }
        if (ser.getSales_Lname().length() > 30) {
            return "Surname cannot be longer than 30 characters";
        }
        if(ser.getSales_Salary()<0){
            return "Salary must be greater than £0";
        }
        if(ser.getSales_BankAcc().length()<9){
            return "Bank Account Number must be at least 9 characters long.";
        }
        if(ser.getSales_NINum().length()!= 9){
            return "National insurance number must be 9 characters in the format AB12345C";
        }
        if(ser.getSales_CommRate()<=0 || ser.getSales_CommRate()>=100){
            return "Commission rate must be greater than 0 and less than 100";
        }
        return null;
    }
}
