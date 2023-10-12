package org.kainos.ea.db;
import org.kainos.ea.api.SalesEmpService;
import org.kainos.ea.cli.SalesEmp;
import org.kainos.ea.cli.SalesEmpRequest;

import javax.swing.plaf.nimbus.State;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SalesEmpDao {
    private static Connection conn;
    private static DatabaseConnector databaseConnector;

    public SalesEmp getSalesEmpByID(int id) throws SQLException {
        Connection c = databaseConnector.getConnection();

        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT Sales_Fname, Sales_Lname, Sales_Salary, Sales_BankAcc,"
                + " Sales_NINum, Sales_CommRate FROM Sales_Employee WHERE Sales_ID = "+id);

        while(rs.next()) {
            return new SalesEmp(
                    rs.getString("Sales_Fname"),
                    rs.getString("Sales_Lname"),
                    rs.getDouble("Sales_Salary"),
                    rs.getString("Sales_BankAcc"),
                    rs.getString("Sales_NINum"),
                    rs.getDouble("Sales_CommRate")
                    );
        }

        return null;

    }

    public int createSalesEmp(SalesEmpRequest se) throws SQLException {
        Connection c = databaseConnector.getConnection();

        String insertStatement = ("INSERT INTO Sales_Employee(Sales_Fname, Sales_Lname, Sales_Salary, Sales_BankAcc,"
                + " Sales_NINum, Sales_CommRate) VALUES (?, ?, ?, ?, ?, ?);");

        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

        st.setString(1, se.getSales_Fname());
        st.setString(2, se.getSales_Lname());
        st.setDouble(3, se.getSales_Salary());
        st.setString(4, se.getSales_BankAcc());
        st.setString(5, se.getSales_NINum());
        st.setDouble(6, se.getSales_CommRate());

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if(rs.next()) {
            return rs.getInt(1);
        }
        return -1;

    }

/*    public void updateSalesEmp(int id, SalesEmpRequest se) throws SQLException {
        Connection c = databaseConnector.getConnection();

        String updateStatement = "UPDATE Sales_Employee SET Sales_Fname = ?, Sales_Lname = ?, Sales_Salary = ?, " +
                "Sales_BankAcc = ?, Sales_NINum = ?, Sales_CommRate = ? WHERE Sales_ID = ?";

        PreparedStatement st = c.prepareStatement(updateStatement);

        st.setString(1, se.getSales_Fname());
        st.setString(2, se.getSales_Lname());
        st.setDouble(3, se.getSales_Salary());
        st.setString(4,se.getSales_BankAcc());
        st.setString(5, se.getSales_NINum());
        st.setDouble(6, se.getSales_CommRate());
        st.setInt(7, id);

        st.executeUpdate();
    }*/
}
