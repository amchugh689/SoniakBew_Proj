package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeliveryRequest {
    private String Delivery_Fname;
    private String Delivery_Lname;
    private  Float Delivery_Salary;
    private String Delivery_BankAcc;
    private String Delivery_NINum;

    @JsonCreator
    public DeliveryRequest(
            @JsonProperty ("Delivery_Fname") String delivery_Fname,
            @JsonProperty ("Delivery_Lname") String delivery_Lname,
            @JsonProperty ("Delivery_Salary") Float delivery_Salary,
            @JsonProperty ("Delivery_BankAcc") String delivery_BankAcc,
            @JsonProperty ("Delivery_NINum") String delivery_NINum) {
        this.Delivery_Fname = delivery_Fname;
        this.Delivery_Lname = delivery_Lname;
        this. Delivery_Salary = delivery_Salary;
        this.Delivery_BankAcc = delivery_BankAcc;
        this.Delivery_NINum = delivery_NINum;
    }

    public String getDelivery_Fname() {
        return Delivery_Fname;
    }

    public void setDelivery_Fname(String delivery_Fname) {
        Delivery_Fname = delivery_Fname;
    }

    public String getDelivery_Lname() {
        return Delivery_Lname;
    }

    public void setDelivery_Lname(String delivery_Lname) {
        Delivery_Lname = delivery_Lname;
    }

    public Float getDelivery_Salary() {
        return Delivery_Salary;
    }

    public void setDelivery_Salary(Float delivery_Salary) {
        Delivery_Salary = delivery_Salary;
    }

    public String getDelivery_BankAcc() {
        return Delivery_BankAcc;
    }

    public void setDelivery_BankAcc(String delivery_BankAcc) {
        Delivery_BankAcc = delivery_BankAcc;
    }

    public String getDelivery_NINum() {
        return Delivery_NINum;
    }

    public void setDelivery_NINum(String delivery_NINum) {
        Delivery_NINum = delivery_NINum;
    }
}
