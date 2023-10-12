package org.kainos.ea.db;

import org.kainos.ea.cli.Project;
import org.kainos.ea.cli.ProjectRequest;

import java.sql.*;

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

    public void updateProject(int id, ProjectRequest project) throws SQLException {
        Connection c = databaseConnector.getConnection();

        String updateStatement = "UPDATE Project SET Project_Completed = ? WHERE Product_ID = ?";

        PreparedStatement st = c.prepareStatement(updateStatement);

        st.setInt(1, project.getProject_Completed());
        st.setInt(2, id);

        st.executeUpdate();
    }
}
