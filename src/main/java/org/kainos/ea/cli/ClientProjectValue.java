package org.kainos.ea.cli;

public class ClientProjectValue {
    private int Client_ID;
    private String Client_Fname;
    private String Client_Lname;
    private double Project_Value;

    public ClientProjectValue(int client_ID, String client_Fname, String client_Lname, double project_Value) {
        Client_ID = client_ID;
        Client_Fname = client_Fname;
        Client_Lname = client_Lname;
        Project_Value = project_Value;
    }


    public int getClient_ID() {
        return Client_ID;
    }

    public void setClient_ID(int client_ID) {
        Client_ID = client_ID;
    }

    public String getClient_Fname() {
        return Client_Fname;
    }

    public void setClient_Fname(String client_Fname) {
        Client_Fname = client_Fname;
    }

    public String getClient_Lname() {
        return Client_Lname;
    }

    public void setClient_Lname(String client_Lname) {
        Client_Lname = client_Lname;
    }

    public double getProject_Value() {
        return Project_Value;
    }

    public void setProject_Value(double project_Value) {
        Project_Value = project_Value;
    }


}
