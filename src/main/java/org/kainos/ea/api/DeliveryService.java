package org.kainos.ea.api;

import org.kainos.ea.cli.Delivery;
import org.kainos.ea.cli.DeliveryRequest;
import org.kainos.ea.client.FailedToCreateProductException;
import org.kainos.ea.client.InvalidDeliveryException;
import org.kainos.ea.core.DeliveryValidator;
import org.kainos.ea.db.DeliveryDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryService {
    private DeliveryDao deliveryDao = new DeliveryDao();
    private DeliveryValidator deliveryValidator = new DeliveryValidator();
    public List<Delivery> getAllDeliverys() throws SQLException {
        List<Delivery> deliveryList = deliveryDao.getAllDeliverys();

        return deliveryList;
    }

    public int createDelivery(DeliveryRequest delivery) throws FailedToCreateProductException, InvalidDeliveryException {
        try {
            String validation = deliveryValidator.isValidDelivery(delivery);

            if (validation != null) {
                throw new InvalidDeliveryException(validation);
            }

            int id = deliveryDao.createDelivery(delivery);

            if (id == -1) {
                throw new FailedToCreateProductException();
            }

            return id;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToCreateProductException();
        }
    }
}
