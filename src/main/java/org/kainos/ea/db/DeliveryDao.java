package org.kainos.ea.db;

import org.kainos.ea.cli.Delivery;
import org.kainos.ea.cli.DeliveryRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.kainos.ea.db.DatabaseConnector.getConnection;

public class DeliveryDao {
    private static Connection conn;
    DatabaseConnector databaseConnector = new DatabaseConnector();

    public List<Delivery> getAllDeliverys() throws SQLException {
        Connection c = databaseConnector.getConnection();

        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT Delivery_ID, Delivery_Fname, Delivery_Lname, " +
                "Delivery_Salary, Delivery_BankAcc, Delivery_NINum FROM Delivery_Employee;");

        List<Delivery> deliveryList = new ArrayList<>();

        while (rs.next()) {
            Delivery delivery = new Delivery(
                    rs.getInt("Delivery_ID"),
                    rs.getString("Delivery_Fname"),
                    rs.getString("Delivery_Lname"),
                    rs.getFloat("Delivery_Salary"),
                    rs.getString("Delivery_BankAcc"),
                    rs.getString("Delivery_NINum")
            );
            deliveryList.add(delivery);
        }

        return deliveryList;
    }

    public int createDelivery(DeliveryRequest delivery) throws SQLException {
        Connection c = databaseConnector.getConnection();

        String insertStatement = "INSERT into Delivery_Employee (Delivery_Fname, Delivery_Lname, Delivery_Salary, Delivery_BankAcc, Delivery_NINum)" +
                " VALUES (?,?,?,?,?)";

        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

        st.setString(1,delivery.getDelivery_Fname());
        st.setString(2,delivery.getDelivery_Lname());
        st.setDouble(3,delivery.getDelivery_Salary());
        st.setString(4,delivery.getDelivery_BankAcc());
        st.setString(5,delivery.getDelivery_NINum());

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1);
        }

        return -1;
    }
}


