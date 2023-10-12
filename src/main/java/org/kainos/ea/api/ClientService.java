package org.kainos.ea.api;

//import org.kainos.ea.cli.Client;
import org.kainos.ea.cli.ClientProjectEmp;

import java.util.ArrayList;
import java.util.List;

public class ClientService {
    public List<ClientProjectEmp> getAllClients() {
        List<ClientProjectEmp> clientList = new ArrayList<>();

        ClientProjectEmp client1 = new ClientProjectEmp(11, "John", "Doe", "Project11", "Matt", "Hand");

        clientList.add(client1);

        return clientList;
    }
}
