package com.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.User;
import com.hibernate.entity.Meter;
import com.hibernate.entity.Appliance;
import com.hibernate.entity.Consumption;
import com.hibernate.entity.Billing;
import com.hibernate.entity.Alert;
import com.hibernate.entity.EnergySuggestion;
import com.hibernate.util.HibernateConnection;

public class PowerWiseDAO {

    // =====================================================
    // USER CRUD
    // =====================================================

    // CREATE
    public void saveUser(User user) {

        Transaction transaction = null;

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(user);

            transaction.commit();

            System.out.println("User saved successfully.");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // READ - ALL
    public List<User> getAllUsers() {

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            return session.createQuery("from User", User.class).list();

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    // READ - BY ID
    public User getUserById(int userId) {

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            return session.find(User.class, userId);

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    // UPDATE
    public void updateUser(User user) {

        Transaction transaction = null;

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.merge(user);

            transaction.commit();

            System.out.println("User updated successfully.");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteUser(int userId) {

        Transaction transaction = null;

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            User user = session.find(User.class, userId);

            if (user != null) {

                session.remove(user);

                System.out.println("User deleted successfully.");

            } else {

                System.out.println("User not found.");
            }

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }


    // =====================================================
    // METER CRUD
    // =====================================================

    // CREATE
    public void saveMeter(Meter meter) {

        Transaction transaction = null;

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(meter);

            transaction.commit();

            System.out.println("Meter saved successfully.");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // READ - ALL
    public List<Meter> getAllMeters() {

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            return session.createQuery("from Meter", Meter.class).list();

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    // READ - BY ID
    public Meter getMeterById(int meterId) {

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            return session.find(Meter.class, meterId);

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    // UPDATE
    public void updateMeter(Meter meter) {

        Transaction transaction = null;

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.merge(meter);

            transaction.commit();

            System.out.println("Meter updated successfully.");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteMeter(int meterId) {

        Transaction transaction = null;

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Meter meter = session.find(Meter.class, meterId);

            if (meter != null) {

                session.remove(meter);

                System.out.println("Meter deleted successfully.");

            } else {

                System.out.println("Meter not found.");
            }

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }


    // =====================================================
    // APPLIANCE CRUD
    // =====================================================

    // CREATE
    public void saveAppliance(Appliance appliance) {

        Transaction transaction = null;

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(appliance);

            transaction.commit();

            System.out.println("Appliance saved successfully.");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // READ - ALL
    public List<Appliance> getAllAppliances() {

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            return session.createQuery("from Appliance", Appliance.class).list();

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    // READ - BY ID
    public Appliance getApplianceById(int applianceId) {

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            return session.find(Appliance.class, applianceId);

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    // UPDATE
    public void updateAppliance(Appliance appliance) {

        Transaction transaction = null;

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.merge(appliance);

            transaction.commit();

            System.out.println("Appliance updated successfully.");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteAppliance(int applianceId) {

        Transaction transaction = null;

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Appliance appliance = session.find(Appliance.class, applianceId);

            if (appliance != null) {

                session.remove(appliance);

                System.out.println("Appliance deleted successfully.");

            } else {

                System.out.println("Appliance not found.");
            }

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }


    // =====================================================
    // CONSUMPTION CRUD
    // =====================================================

    // CREATE
    public void saveConsumption(Consumption consumption) {

        Transaction transaction = null;

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(consumption);

            transaction.commit();

            System.out.println("Consumption saved successfully.");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // READ - ALL
    public List<Consumption> getAllConsumptions() {

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            return session.createQuery(
                    "from Consumption",
                    Consumption.class
            ).list();

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    // READ - BY ID
    public Consumption getConsumptionById(int consumptionId) {

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            return session.find(Consumption.class, consumptionId);

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    // UPDATE
    public void updateConsumption(Consumption consumption) {

        Transaction transaction = null;

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.merge(consumption);

            transaction.commit();

            System.out.println("Consumption updated successfully.");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteConsumption(int consumptionId) {

        Transaction transaction = null;

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Consumption consumption =
                    session.find(Consumption.class, consumptionId);

            if (consumption != null) {

                session.remove(consumption);

                System.out.println("Consumption deleted successfully.");

            } else {

                System.out.println("Consumption not found.");
            }

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }


    // =====================================================
    // BILLING CRUD
    // =====================================================

    // CREATE
    public void saveBilling(Billing billing) {

        Transaction transaction = null;

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(billing);

            transaction.commit();

            System.out.println("Billing saved successfully.");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // READ - ALL
    public List<Billing> getAllBillings() {

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            return session.createQuery(
                    "from Billing",
                    Billing.class
            ).list();

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    // READ - BY ID
    public Billing getBillingById(int billId) {

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            return session.find(Billing.class, billId);

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    // UPDATE
    public void updateBilling(Billing billing) {

        Transaction transaction = null;

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.merge(billing);

            transaction.commit();

            System.out.println("Billing updated successfully.");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteBilling(int billId) {

        Transaction transaction = null;

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Billing billing = session.find(Billing.class, billId);

            if (billing != null) {

                session.remove(billing);

                System.out.println("Billing deleted successfully.");

            } else {

                System.out.println("Billing not found.");
            }

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }


    // =====================================================
    // ALERT CRUD
    // =====================================================

    // CREATE
    public void saveAlert(Alert alert) {

        Transaction transaction = null;

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(alert);

            transaction.commit();

            System.out.println("Alert saved successfully.");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // READ - ALL
    public List<Alert> getAllAlerts() {

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            return session.createQuery("from Alert", Alert.class).list();

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    // READ - BY ID
    public Alert getAlertById(int alertId) {

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            return session.find(Alert.class, alertId);

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    // UPDATE
    public void updateAlert(Alert alert) {

        Transaction transaction = null;

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.merge(alert);

            transaction.commit();

            System.out.println("Alert updated successfully.");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteAlert(int alertId) {

        Transaction transaction = null;

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Alert alert = session.find(Alert.class, alertId);

            if (alert != null) {

                session.remove(alert);

                System.out.println("Alert deleted successfully.");

            } else {

                System.out.println("Alert not found.");
            }

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }


    // =====================================================
    // ENERGY SUGGESTION CRUD
    // =====================================================

    // CREATE
    public void saveEnergySuggestion(EnergySuggestion suggestion) {

        Transaction transaction = null;

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(suggestion);

            transaction.commit();

            System.out.println("Energy Suggestion saved successfully.");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // READ - ALL
    public List<EnergySuggestion> getAllEnergySuggestions() {

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            return session.createQuery(
                    "from EnergySuggestion",
                    EnergySuggestion.class
            ).list();

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    // READ - BY ID
    public EnergySuggestion getEnergySuggestionById(int suggestionId) {

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            return session.find(EnergySuggestion.class, suggestionId);

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    // UPDATE
    public void updateEnergySuggestion(EnergySuggestion suggestion) {

        Transaction transaction = null;

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.merge(suggestion);

            transaction.commit();

            System.out.println("Energy Suggestion updated successfully.");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteEnergySuggestion(int suggestionId) {

        Transaction transaction = null;

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            EnergySuggestion suggestion =
                    session.find(EnergySuggestion.class, suggestionId);

            if (suggestion != null) {

                session.remove(suggestion);

                System.out.println("Energy Suggestion deleted successfully.");

            } else {

                System.out.println("Energy Suggestion not found.");
            }

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }
}