package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesEmpRequest {
    private String Sales_Fname;
    private String Sales_Lname;
    private double Sales_Salary;
    private String Sales_BankAcc;
    private String Sales_NINum;
    private double Sales_CommRate;

    public String getSales_Fname() {
        return Sales_Fname;
    }

    public void setSales_Fname(String sales_Fname) {
        Sales_Fname = sales_Fname;
    }

    public String getSales_Lname() {
        return Sales_Lname;
    }

    public void setSales_Lname(String sales_Lname) {
        Sales_Lname = sales_Lname;
    }

    public double getSales_Salary() {
        return Sales_Salary;
    }

    public void setSales_Salary(double sales_Salary) {
        Sales_Salary = sales_Salary;
    }

    public String getSales_BankAcc() {
        return Sales_BankAcc;
    }

    public void setSales_BankAcc(String sales_BankAcc) {
        Sales_BankAcc = sales_BankAcc;
    }

    public String getSales_NINum() {
        return Sales_NINum;
    }

    public void setSales_NINum(String sales_NINum) {
        Sales_NINum = sales_NINum;
    }

    public double getSales_CommRate() {
        return Sales_CommRate;
    }

    public void setSales_CommRate(double sales_CommRate) {
        Sales_CommRate = sales_CommRate;
    }


    @JsonCreator
    public SalesEmpRequest(
            @JsonProperty("Sales_Fname") String sales_Fname,
            @JsonProperty("Sales_Lname") String sales_Lname,
            @JsonProperty("Sales_Salary") double sales_Salary,
            @JsonProperty("Sales_BankAcc") String sales_BankAcc,
            @JsonProperty("Sales_NINum") String sales_NINum,
            @JsonProperty("Sales_CommRate")double sales_CommRate) {
                Sales_Fname = sales_Fname;
                Sales_Lname = sales_Lname;
                Sales_Salary = sales_Salary;
                Sales_BankAcc = sales_BankAcc;
                Sales_NINum = sales_NINum;
                Sales_CommRate = sales_CommRate;
    }
}
