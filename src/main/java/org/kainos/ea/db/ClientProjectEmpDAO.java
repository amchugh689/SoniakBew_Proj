package org.kainos.ea.db;

//import org.kainos.ea.cli.Client;
import org.kainos.ea.cli.ClientProjectEmp;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.kainos.ea.db.DatabaseConnector.getConnection;
public class ClientProjectEmpDAO {
    private DatabaseConnector databaseConnector = new DatabaseConnector();

    public List<ClientProjectEmp> getAllClientProjectEmp() throws SQLException {
            Connection c = databaseConnector.getConnection();
            Statement st = c.createStatement();

            ResultSet rs = st.executeQuery("SELECT c.Client_ID, c.Client_Fname, c.Client_Lname, p.Project_Name, s.Sales_Fname, s.Sales_Lname FROM Client c LEFT JOIN Project p ON c.Client_ID = p.Client_ID LEFT JOIN Sales_Employee s ON p.Sales_ID = s.Sales_ID;");

            List<ClientProjectEmp> clientProjectEmpList = new ArrayList<>();

            while (rs.next()) {
                ClientProjectEmp client = new ClientProjectEmp(
                        rs.getInt("Client_ID"),
                        rs.getString("Client_Fname"),
                        rs.getString("Client_Lname"),
                        rs.getString("Project_Name"),
                        rs.getString("Sales_Fname"),
                        rs.getString("Sales_Lname")
                );

                clientProjectEmpList.add(client);

            }

            return clientProjectEmpList;

    }
}

