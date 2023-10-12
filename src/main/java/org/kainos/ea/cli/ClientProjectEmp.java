package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ClientProjectEmp {
    private int Client_ID;
    private String Client_Fname;
    private String Client_Lname;
    private String Project_Name;
    private String Sales_Fname;
    private String Sales_Lname;


    public ClientProjectEmp(int client_ID, String client_Fname, String client_Lname, String project_Name, String sales_Fname, String sales_Lname) {
        Client_ID = client_ID;
        Client_Fname = client_Fname;
        Client_Lname = client_Lname;
        Project_Name = project_Name;
        Sales_Fname = sales_Fname;
        Sales_Lname = sales_Lname;
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

    public String getProject_Name() {
        return Project_Name;
    }

    public void setProject_Name(String project_Name) {
        Project_Name = project_Name;
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

}
