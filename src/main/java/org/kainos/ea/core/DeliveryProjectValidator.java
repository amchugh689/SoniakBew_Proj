package org.kainos.ea.core;

import org.kainos.ea.cli.*;
import org.kainos.ea.db.DeliveryDao;
import org.kainos.ea.db.ProjectDao;

import java.sql.SQLException;

public class DeliveryProjectValidator {
    DeliveryDao deliveryDao = new DeliveryDao();
    ProjectDao projectDao = new ProjectDao();

    public String isValidDeliveryProject (DeliveryProjectRequest dp) throws SQLException {
        Delivery delivery = deliveryDao.getDeliveryById(dp.getDelivery_ID());
        if(delivery == null) {
            return "The delivery specified doesn't exist.";
        }

        Project project = projectDao.getProjectById(dp.getProject_ID());

        if(project==null) {
            return "The project specified doesn't exist.";
        }

        return null;

    }
}
