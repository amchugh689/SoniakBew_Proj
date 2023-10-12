package org.kainos.ea.cli;

public class Delivery {
    private int Delivery_ID;
    private String Delivery_Fname;
    private String Delivery_Lname;
    private float Delivery_Salary;
    private String Delivery_BankAcc;
    private String Delivery_NINum;

    public Delivery(int delivery_ID, String delivery_Fname, String delivery_Lname, float delivery_Salary, String delivery_BankAcc, String delivery_NINum) {
        this.Delivery_ID = delivery_ID;
        this.Delivery_Fname = delivery_Fname;
        this.Delivery_Lname = delivery_Lname;
        this.Delivery_Salary = delivery_Salary;
        this.Delivery_BankAcc = delivery_BankAcc;
        this.Delivery_NINum = delivery_NINum;
    }

    public int getDelivery_ID() {
        return Delivery_ID;
    }

    public void setDelivery_ID(int delivery_ID) {
        Delivery_ID = delivery_ID;
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

    public float getDelivery_Salary() {
        return Delivery_Salary;
    }

    public void setDelivery_Salary(float delivery_Salary) {
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
