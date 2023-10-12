package org.kainos.ea.api;

import org.kainos.ea.cli.Delivery;
import org.kainos.ea.cli.DeliveryRequest;
import org.kainos.ea.cli.SalesEmp;
import org.kainos.ea.client.*;
import org.kainos.ea.core.DeliveryValidator;
import org.kainos.ea.db.DeliveryDao;

import java.sql.SQLException;
import java.util.List;

public class DeliveryService {
    private DeliveryDao deliveryDao = new DeliveryDao();
    private DeliveryValidator deliveryValidator = new DeliveryValidator();
    public List<Delivery> getAllDeliverys() throws SQLException {
        List<Delivery> deliveryList = deliveryDao.getAllDeliverys();

        return deliveryList;
    }

    public int createDelivery(DeliveryRequest delivery) throws FailedToCreateDeliveryException, InvalidDeliveryException {
        try {
            String validation = deliveryValidator.isValidDelivery(delivery);

            if (validation != null) {
                throw new InvalidDeliveryException(validation);
            }

            int id = deliveryDao.createDelivery(delivery);

            if (id == -1) {
                throw new FailedToCreateDeliveryException();
            }

            return id;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToCreateDeliveryException();
        }
    }

    public Delivery getDeliveryById(int id) throws FailedToGetDeliveryException, DeliveryDoesNotExistException {
        try {
            Delivery delivery = deliveryDao.getDeliveryById(id);

            if (delivery == null) {
                throw new DeliveryDoesNotExistException();
            }

            return delivery;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetDeliveryException();
        }
    }

    public void updateDelivery(int id, DeliveryRequest delivery) throws InvalidDeliveryException, DeliveryDoesNotExistException, FailedToUpdateDeliveryException {
        try {
            String validation = deliveryValidator.isValidDelivery(delivery);

            if (validation != null) {
                throw new InvalidDeliveryException(validation);
            }

            Delivery deliveryToUpdate = deliveryDao.getDeliveryById(id);

            if (deliveryToUpdate == null) {
                throw new DeliveryDoesNotExistException();
            }

            deliveryDao.updateDelivery(id, delivery);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToUpdateDeliveryException();
        }
    }

    public void deleteDelivery(int id) throws DeliveryDoesNotExistException, FailedToDeleteDeliveryException {
        try {
            Delivery deliveryDelete = deliveryDao.getDeliveryById(id);
            if (deliveryDelete == null) {
                throw new DeliveryDoesNotExistException();
            }

            deliveryDao.deleteDelivery(id);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToDeleteDeliveryException();
        }
    }
}
