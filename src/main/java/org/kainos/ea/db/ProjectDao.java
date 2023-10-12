package org.kainos.ea.db;

import org.kainos.ea.cli.Project;
import org.kainos.ea.cli.ProjectRequest;
import org.kainos.ea.cli.ProjectTechDel;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.kainos.ea.cli.ProjectRequestClientID;
import org.kainos.ea.cli.ProjectRequestCompleted;

public class ProjectDao {
    private DatabaseConnector databaseConnector = new DatabaseConnector();
  
    public Project getProjectById(int Id) throws SQLException {
        Connection c = databaseConnector.getConnection();

        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT Project_ID, Project_Name, Project_Value, Client_ID, Sales_ID, Tech_Lead, Project_Start_Date, Project_End_Date, Project_Completed" +
                " FROM Project WHERE Project_ID=" + Id);

        while (rs.next()){
            return new Project(
                    rs.getInt("Project_ID"),
                    rs.getString("Project_Name"),
                    rs.getFloat("Project_Value"),
                    rs.getInt("Client_ID"),
                    rs.getInt("Sales_ID"),
                    rs.getInt("Tech_Lead"),
                   rs.getDate("Project_Start_Date"),
                    rs.getDate("Project_End_Date"),
                    rs.getInt("Project_Completed")
            );

        }
        return null;
    }

    public void updateProjectCompleted(int id, ProjectRequestCompleted project) throws SQLException {
        Connection c = databaseConnector.getConnection();
        String updateStatement = "UPDATE Project SET Project_Completed = ? WHERE Project_ID = ?";

        PreparedStatement st = c.prepareStatement(updateStatement);

        st.setInt(1, project.getProject_Completed());
        st.setInt(2, id);

        st.executeUpdate();
    }

    public List<ProjectTechDel> getProjectTechDelivery() throws SQLException {

        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT Project_Name, Tech_Lead, GROUP_CONCAT(CONCAT(Delivery_FName,' ', Delivery_Lname ) separator ', ') as 'Name' FROM Project INNER JOIN Project_Delivery ON Project.Project_ID = Project_Delivery.Project_ID INNER JOIN Delivery_Employee ON Delivery_Employee.Delivery_ID = Project_Delivery.Delivery_ID GROUP BY Project.Project_ID;");

        List<ProjectTechDel> projectList = new ArrayList<>();

        while (rs.next()){
            ProjectTechDel project = new ProjectTechDel(
                    rs.getString("Project_Name"),
                    rs.getInt("Tech_Lead"),
                    rs.getString("Name")
            );

            projectList.add(project);
        }

        return projectList;
  
    public void updateProjectClient(int id, ProjectRequestClientID project) throws SQLException {
        Connection c = databaseConnector.getConnection();
        String updateStatement = "UPDATE Project SET Client_ID = ? WHERE Project_ID = ?";

        PreparedStatement st = c.prepareStatement(updateStatement);

        st.setInt(1, project.getClient_ID());
        st.setInt(2, id);

        st.executeUpdate();
    }
}
