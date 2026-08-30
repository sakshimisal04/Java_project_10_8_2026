package com.powerwise.model;

import java.sql.Timestamp;

public class Alert {

    private int alertId;
    private int userId;
    private double currentUsage;
    private double thresholdValue;
    private String alertType;
    private String message;
    private Timestamp alertDate;
    private String status;

    // Default constructor
    public Alert() {
    }

    // Constructor without ID
    public Alert(
            int userId,
            double currentUsage,
            double thresholdValue,
            String alertType,
            String message,
            Timestamp alertDate,
            String status) {

        this.userId = userId;
        this.currentUsage = currentUsage;
        this.thresholdValue = thresholdValue;
        this.alertType = alertType;
        this.message = message;
        this.alertDate = alertDate;
        this.status = status;
    }

    // Constructor with ID
    public Alert(
            int alertId,
            int userId,
            double currentUsage,
            double thresholdValue,
            String alertType,
            String message,
            Timestamp alertDate,
            String status) {

        this.alertId = alertId;
        this.userId = userId;
        this.currentUsage = currentUsage;
        this.thresholdValue = thresholdValue;
        this.alertType = alertType;
        this.message = message;
        this.alertDate = alertDate;
        this.status = status;
    }

    // Getters and Setters

    public int getAlertId() {
        return alertId;
    }

    public void setAlertId(int alertId) {
        this.alertId = alertId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getCurrentUsage() {
        return currentUsage;
    }

    public void setCurrentUsage(double currentUsage) {
        this.currentUsage = currentUsage;
    }

    public double getThresholdValue() {
        return thresholdValue;
    }

    public void setThresholdValue(double thresholdValue) {
        this.thresholdValue = thresholdValue;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getAlertDate() {
        return alertDate;
    }

    public void setAlertDate(Timestamp alertDate) {
        this.alertDate = alertDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}