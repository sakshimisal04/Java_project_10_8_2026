package com.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.User;
import com.hibernate.entity.Meter;
import com.hibernate.entity.Appliance;
import com.hibernate.entity.Consumption;
import com.hibernate.entity.Billing;
import com.hibernate.entity.Alert;
import com.hibernate.entity.EnergySuggestion;

public class HibernateConnection {

    private static SessionFactory sessionFactory;

    static {
        try {

            Configuration configuration = new Configuration();

            configuration.configure("hibernate.cfg.xml");

            // Register all PowerWise entities
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Meter.class);
            configuration.addAnnotatedClass(Appliance.class);
            configuration.addAnnotatedClass(Consumption.class);
            configuration.addAnnotatedClass(Billing.class);
            configuration.addAnnotatedClass(Alert.class);
            configuration.addAnnotatedClass(EnergySuggestion.class);

            sessionFactory = configuration.buildSessionFactory();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}