package org.kainos.ea.api;

import org.kainos.ea.cli.ClientProjectValue;
import org.kainos.ea.client.FailedToGetClientProjectValueException;
import org.kainos.ea.db.ClientProjectValueDAO;

import java.sql.SQLException;
import java.util.List;

public class ClientProjectValueService {
    private ClientProjectValueDAO clientProjectValueDAO = new ClientProjectValueDAO();
    public List<ClientProjectValue> getClientProjectValue() throws FailedToGetClientProjectValueException {
        try {
            List<ClientProjectValue> clientProjectValueList = clientProjectValueDAO.getClientProjectValue();

            return clientProjectValueList;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetClientProjectValueException();
        }
    }
}
