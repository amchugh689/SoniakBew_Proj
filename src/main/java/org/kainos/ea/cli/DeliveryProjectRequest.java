package org.kainos.ea.cli;

public class DeliveryProjectRequest {
    private int Project_ID;
    private int Delivery_ID;
    private boolean Actively_Working;

    public DeliveryProjectRequest(int project_ID, int delivery_ID, boolean actively_Working) {
        Project_ID = project_ID;
        Delivery_ID = delivery_ID;
        Actively_Working = actively_Working;
    }
    public DeliveryProjectRequest(int project_ID, int delivery_ID) {
        Project_ID = project_ID;
        Delivery_ID = delivery_ID;
    }

    public int getProject_ID() {
        return Project_ID;
    }

    public void setProject_ID(int project_ID) {
        Project_ID = project_ID;
    }

    public int getDelivery_ID() {
        return Delivery_ID;
    }

    public void setDelivery_ID(int delivery_ID) {
        Delivery_ID = delivery_ID;
    }

    public boolean isActively_Working() {
        return Actively_Working;
    }

    public void setActively_Working(boolean actively_Working) {
        Actively_Working = actively_Working;
    }

}
