package org.kainos.ea.db;

import org.kainos.ea.cli.DeliveryProject;
import org.kainos.ea.cli.DeliveryProjectRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DeliveryProjectDao {

    private static Connection conn;
    DatabaseConnector databaseConnector = new DatabaseConnector();

    public void createDeliveryProject(DeliveryProjectRequest dp) throws SQLException {
        Connection c = databaseConnector.getConnection();

        String insertStatement = "INSERT INTO Project_Delivery(Project_ID, Delivery_ID, Actively_Working) " +
                "VALUES(?, ?, 1)";
        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

        st.setInt(1, dp.getProject_ID());
        st.setInt(2, dp.getDelivery_ID());

        st.executeUpdate();





    }
}
