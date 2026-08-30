package com.powerwise.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.powerwise.db.DBConnection;
import com.powerwise.model.Alert;

public class AlertRepository {

    // =====================================================
    // CREATE - ADD ALERT
    // =====================================================

    public void addAlert(Alert alert) {

        String sql = "INSERT INTO alert "
                + "(user_id, current_usage, threshold_value, "
                + "alert_type, message, alert_date, status) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, alert.getUserId());
            ps.setDouble(2, alert.getCurrentUsage());
            ps.setDouble(3, alert.getThresholdValue());
            ps.setString(4, alert.getAlertType());
            ps.setString(5, alert.getMessage());
            ps.setTimestamp(6, alert.getAlertDate());
            ps.setString(7, alert.getStatus());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Alert added successfully.");
            }

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // =====================================================
    // READ - VIEW ALL ALERTS
    // =====================================================

    public List<Alert> getAllAlerts() {

        List<Alert> alerts = new ArrayList<>();

        String sql = "SELECT * FROM alert";

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Alert alert = new Alert();

                alert.setAlertId(
                        rs.getInt("alert_id"));

                alert.setUserId(
                        rs.getInt("user_id"));

                alert.setCurrentUsage(
                        rs.getDouble("current_usage"));

                alert.setThresholdValue(
                        rs.getDouble("threshold_value"));

                alert.setAlertType(
                        rs.getString("alert_type"));

                alert.setMessage(
                        rs.getString("message"));

                alert.setAlertDate(
                        rs.getTimestamp("alert_date"));

                alert.setStatus(
                        rs.getString("status"));

                alerts.add(alert);
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return alerts;
    }


    // =====================================================
    // UPDATE
    // =====================================================

    public void updateAlert(Alert alert) {

        String sql = "UPDATE alert SET "
                + "user_id = ?, "
                + "current_usage = ?, "
                + "threshold_value = ?, "
                + "alert_type = ?, "
                + "message = ?, "
                + "alert_date = ?, "
                + "status = ? "
                + "WHERE alert_id = ?";

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, alert.getUserId());

            ps.setDouble(2,
                    alert.getCurrentUsage());

            ps.setDouble(3,
                    alert.getThresholdValue());

            ps.setString(4,
                    alert.getAlertType());

            ps.setString(5,
                    alert.getMessage());

            ps.setTimestamp(6,
                    alert.getAlertDate());

            ps.setString(7,
                    alert.getStatus());

            ps.setInt(8,
                    alert.getAlertId());

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Alert updated successfully.");

            } else {

                System.out.println(
                        "Alert not found.");
            }

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // =====================================================
    // DELETE
    // =====================================================

    public void deleteAlert(int alertId) {

        String sql =
                "DELETE FROM alert WHERE alert_id = ?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(1, alertId);

            int rows =
                    ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Alert deleted successfully.");

            } else {

                System.out.println(
                        "Alert not found.");
            }

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}