package org.kainos.ea.db;

//import org.kainos.ea.cli.Client;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.kainos.ea.db.DatabaseConnector.getConnection;

//public class ClientsDAO {
//    private DatabaseConnector databaseConnector = new DatabaseConnector();
//
//    public List<Client> getClientInfo() {
//        try (Connection c = getConnection()) {
//            Statement st = c.createStatement();
//
//            ResultSet rs = st.executeQuery("SELECT c.Client_ID, c.Client_Fname, c.Client_Lname, p.Project_Name AS Project_Name, s.Sales_Fname AS Sales_Fname, s.Sales_Lname AS Sales_Lname FROM Client c LEFT JOIN Project p ON c.Client_ID = p.Client_ID LEFT JOIN Sales_Employee s ON p.Sales_ID = s.Sales_ID;");
//
//            List<Client> clientList = new ArrayList<>();
//
//            while (rs.next()) {
//                Client client = new Client(
//                        rs.getInt("Client_ID"),
//                        rs.getString("Client_Fname"),
//                        rs.getString("Client_Lname"),
//                        rs.getString("Project_Name"),
//                        rs.getString("Sales_Fname")
////                        rs.getString("Sales_Lname")
//                );
//
//                clientList.add(client);
//            }
//
//            return clientList;
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//
//            return null;
//        }
//    }
//}
