package org.kainos.ea.db;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.kainos.ea.cli.ClientProjectValue;



public class ClientProjectValueDAO {
    private DatabaseConnector databaseConnector = new DatabaseConnector();

    public List<ClientProjectValue> getClientProjectValue() throws SQLException {
        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT c.Client_ID, c.Client_Fname, c.Client_Lname, SUM(p.Project_Value) as Project_Value FROM Client c LEFT JOIN Project p ON c.Client_ID = p.Client_ID GROUP BY c.Client_ID, c.Client_Fname, c.Client_Lname ORDER BY p.Project_Value DESC;");

        List<ClientProjectValue> clientProjectValueList = new ArrayList<>();

        while (rs.next()) {
            ClientProjectValue clientProjectValue = new ClientProjectValue(
                    rs.getInt("Client_ID"),
                    rs.getString("Client_Fname"),
                    rs.getString("Client_Lname"),
                    rs.getDouble("Project_Value")
            );

            clientProjectValueList.add(clientProjectValue);
        }
        return clientProjectValueList;
    }
}