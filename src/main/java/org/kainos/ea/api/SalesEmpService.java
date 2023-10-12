package org.kainos.ea.api;

import org.kainos.ea.cli.SalesEmp;
import org.kainos.ea.cli.SalesEmpRequest;
import org.kainos.ea.client.FailedToCreateSalesEmpException;
import org.kainos.ea.client.FailedToGetSalesEmpException;
import org.kainos.ea.client.InvalidSalesEmpException;
import org.kainos.ea.client.SalesEmpDoesNotExistException;
import org.kainos.ea.core.SalesEmpValidator;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.SalesEmpDao;

import java.sql.Connection;
import java.sql.SQLException;

public class SalesEmpService {
    SalesEmpDao salesEmpDao = new SalesEmpDao();

    private static Connection conn;
    private static DatabaseConnector databaseConnector;
    SalesEmpValidator salesEmpValidator = new SalesEmpValidator();

    public SalesEmp getSalesEmpByID(int id) throws FailedToGetSalesEmpException, SalesEmpDoesNotExistException {
        try {
            SalesEmp salesEmp = salesEmpDao.getSalesEmpByID(id);

            if(salesEmp == null) {
                throw new SalesEmpDoesNotExistException();
            }

            return salesEmp;
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetSalesEmpException();
        }
    }

    public int createSalesEmp(SalesEmpRequest se) throws FailedToCreateSalesEmpException, InvalidSalesEmpException {
        try {
            String validation = salesEmpValidator.isValidSalesEmp(se);
            if (validation != null) {
                throw new InvalidSalesEmpException(validation);
            }
            int id = salesEmpDao.createSalesEmp(se);
            if (id == -1) {
                throw new FailedToCreateSalesEmpException();
            }
            return id;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToCreateSalesEmpException();
        }
    }


//    public void updateProduct(int id, SalesEmpRequest se) throws InvalidSalesEmpException, SalesEmpDoesNotExistException {
//        try {
//            String validation = salesEmpValidator.isValidSalesEmp(se);
//
//            if(validation != null) {
//                throw new InvalidSalesEmpException(validation);
//            }
//
//
//            SalesEmp empToUpdate = salesEmpDao.getSalesEmpByID(id);
//        }
//
//
//    }

}
