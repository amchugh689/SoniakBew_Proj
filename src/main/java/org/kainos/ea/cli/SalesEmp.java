package org.kainos.ea.cli;

public class SalesEmp {
    private int Sales_ID;
    private String Sales_Fname;
    private String Sales_Lname;
    private double Sales_Salary;
    private String Sales_BankAcc;
    private String Sales_NINum;
    private double Sales_CommRate;

    public int getSales_ID() {
        return Sales_ID;
    }

    public void setSales_ID(int sales_ID) {
        Sales_ID = sales_ID;
    }

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

    public SalesEmp(int sales_ID, String sales_Fname, String sales_Lname, double sales_Salary, String sales_BankAcc, String sales_NINum, double sales_CommRate) {
        Sales_ID = sales_ID;
        Sales_Fname = sales_Fname;
        Sales_Lname = sales_Lname;
        Sales_Salary = sales_Salary;
        Sales_BankAcc = sales_BankAcc;
        Sales_NINum = sales_NINum;
        Sales_CommRate = sales_CommRate;
    }
}
