package org.kainos.ea.api;

import org.kainos.ea.cli.DeliveryProjectRequest;
import org.kainos.ea.client.FailedToCreateDeliveryException;
import org.kainos.ea.client.FailedToCreateDeliveryProjectException;
import org.kainos.ea.client.InvalidDeliveryProjectException;
import org.kainos.ea.core.DeliveryProjectValidator;
import org.kainos.ea.db.DeliveryProjectDao;

import java.sql.SQLException;

public class DeliveryProjectService {

    DeliveryProjectValidator deliveryProjectValidator = new DeliveryProjectValidator();
    DeliveryProjectDao deliveryProjectDao = new DeliveryProjectDao();
    public void createDeliveryProject(DeliveryProjectRequest dp) throws FailedToCreateDeliveryProjectException, InvalidDeliveryProjectException  {

        try {
            String validation = deliveryProjectValidator.isValidDeliveryProject(dp);
            if(validation!=null) {
                throw new InvalidDeliveryProjectException(validation);
            }

            deliveryProjectDao.createDeliveryProject(dp);

        }
        catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToCreateDeliveryProjectException();
        }

    }

}
