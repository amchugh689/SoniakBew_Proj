package org.kainos.ea.db;
import org.kainos.ea.cli.SalesEmp;

import javax.swing.plaf.nimbus.State;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SalesEmpDao {
    private static Connection conn;
    private static DatabaseConnector databaseConnector;

    public int createSalesEmp(SalesEmp se) throws SQLException {
        Connection c = databaseConnector.getConnection();

        String insertStatement = ("INSERT INTO Sales_Employee(Sales_Fname, Sales_Lname, Sales_Salary, Sales_BankAcc, "
                + "Sales_NINum, Sales_CommRate) VALUES ?, ?, ?, ?, ?, ?");

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
}
