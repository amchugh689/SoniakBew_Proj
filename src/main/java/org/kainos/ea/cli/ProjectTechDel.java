package org.kainos.ea.cli;

public class ProjectTechDel {
    private String Project_Name;
    private int Tech_Lead;
    private String DeliveryEmpList;

    public String getProject_Name() {
        return Project_Name;
    }

    public void setProject_Name(String project_Name) {
        Project_Name = project_Name;
    }

    public int getTech_Lead() {
        return Tech_Lead;
    }

    public void setTech_Lead(int tech_Lead) {
        Tech_Lead = tech_Lead;
    }

    public String getDeliveryEmpList() {
        return DeliveryEmpList;
    }

    public void setDeliveryEmpList(String deliveryEmpList) {
        DeliveryEmpList = deliveryEmpList;
    }

    public ProjectTechDel(String project_Name, int tech_Lead, String deliveryEmpList) {
        this.Project_Name = project_Name;
        this.Tech_Lead = tech_Lead;
        this.DeliveryEmpList = deliveryEmpList;
    }
}
