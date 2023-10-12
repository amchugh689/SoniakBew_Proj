package org.kainos.ea.api;

//import org.kainos.ea.cli.Client;
import org.kainos.ea.cli.ClientProjectEmp;
import org.kainos.ea.client.FailedToGetClientProjectListException;
import org.kainos.ea.db.ClientProjectEmpDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientProjectEmpService {

    private ClientProjectEmpDAO clientProjectEmpDAO = new ClientProjectEmpDAO();
    public List<ClientProjectEmp> getAllClientProjectEmp() throws FailedToGetClientProjectListException {
        try {
            List<ClientProjectEmp>clientProjectEmpList = clientProjectEmpDAO.getAllClientProjectEmp();

            return clientProjectEmpList;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetClientProjectListException();
        }
    }
}