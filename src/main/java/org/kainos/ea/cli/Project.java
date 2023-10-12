package org.kainos.ea.cli;

import java.sql.Date;

public class Project {
    private int Project_ID;
    private String Project_Name;
    private float Project_Value;
    private int Client_ID;
    private int Sales_ID;
    private int Tech_Lead;
    private Date Project_Start_Date;
    private Date Project_End_Date;
    private int Project_Completed ;

    public Project(int project_ID, String project_Name, float project_Value, int clientID, int salesID, int tech_Lead, Date project_Start_Date, Date project_End_Date, int project_Completed) {
        this.Project_ID = project_ID;
        this.Project_Name = project_Name;
        this.Project_Value = project_Value;
        this.Client_ID = clientID;
        this.Sales_ID = salesID;
        this.Tech_Lead = tech_Lead;
        this.Project_Start_Date = project_Start_Date;
        this.Project_End_Date = project_End_Date;
        this.Project_Completed = project_Completed;
    }

    public int getProject_ID() {
        return Project_ID;
    }

    public void setProject_ID(int project_ID) {
        Project_ID = project_ID;
    }

    public String getProject_Name() {
        return Project_Name;
    }

    public void setProject_Name(String project_Name) {
        Project_Name = project_Name;
    }

    public float getProject_Value() {
        return Project_Value;
    }

    public void setProject_Value(float project_Value) {
        Project_Value = project_Value;
    }

    public int getClient_ID() {
        return Client_ID;
    }

    public void setClient_ID(int client_ID) {
        Client_ID = client_ID;
    }

    public int getSales_ID() {
        return Sales_ID;
    }

    public void setSales_ID(int sales_ID) {
        Sales_ID = sales_ID;
    }

    public int getTech_Lead() {
        return Tech_Lead;
    }

    public void setTech_Lead(int tech_Lead) {
        Tech_Lead = tech_Lead;
    }

    public Date getProject_Start_Date() {
        return Project_Start_Date;
    }

    public void setProject_Start_Date(Date project_Start_Date) {
        Project_Start_Date = project_Start_Date;
    }

    public Date getProject_End_Date() {
        return Project_End_Date;
    }

    public void setProject_End_Date(Date project_End_Date) {
        Project_End_Date = project_End_Date;
    }

    public int getProject_Completed() {
        return Project_Completed;
    }

    public void setProject_Completed(int project_Completed) {
        Project_Completed = project_Completed;
    }

    //Format the object to string for when being output
    @Override
    public String toString() {
        return "Project ID: " + this.getProject_ID() + " Project Name: " + this.getProject_Name() + " Project Value: " + this.getProject_Value() +
                " Client ID: " + this.getClient_ID() + " Sales ID: " + this.getSales_ID() + " Tech Lead ID: " + this.getTech_Lead() + " Start Date: " +
                this.getProject_Start_Date().toLocalDate() + "Project End Date: " + (this.getProject_End_Date() != null ?  this.getProject_End_Date().toLocalDate() : "not finished" ) +
                " Project completed: " + this.getProject_Completed();
    }
}
