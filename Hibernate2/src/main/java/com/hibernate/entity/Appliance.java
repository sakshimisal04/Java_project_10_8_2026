package com.hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "appliances")
public class Appliance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int applianceId;

    private int userId;
    private String applianceName;
    private int quantity;
    private double powerRating;
    private double hoursUsedPerDay;
    private double estimatedUnits;

    // Default Constructor
    public Appliance() {
    }

    // Constructor without ID
    public Appliance(int userId, String applianceName, int quantity,
                     double powerRating, double hoursUsedPerDay,
                     double estimatedUnits) {

        this.userId = userId;
        this.applianceName = applianceName;
        this.quantity = quantity;
        this.powerRating = powerRating;
        this.hoursUsedPerDay = hoursUsedPerDay;
        this.estimatedUnits = estimatedUnits;
    }

    // Constructor with ID
    public Appliance(int applianceId, int userId, String applianceName,
                     int quantity, double powerRating,
                     double hoursUsedPerDay, double estimatedUnits) {

        this.applianceId = applianceId;
        this.userId = userId;
        this.applianceName = applianceName;
        this.quantity = quantity;
        this.powerRating = powerRating;
        this.hoursUsedPerDay = hoursUsedPerDay;
        this.estimatedUnits = estimatedUnits;
    }

    public int getApplianceId() {
        return applianceId;
    }

    public void setApplianceId(int applianceId) {
        this.applianceId = applianceId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getApplianceName() {
        return applianceName;
    }

    public void setApplianceName(String applianceName) {
        this.applianceName = applianceName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPowerRating() {
        return powerRating;
    }

    public void setPowerRating(double powerRating) {
        this.powerRating = powerRating;
    }

    public double getHoursUsedPerDay() {
        return hoursUsedPerDay;
    }

    public void setHoursUsedPerDay(double hoursUsedPerDay) {
        this.hoursUsedPerDay = hoursUsedPerDay;
    }

    public double getEstimatedUnits() {
        return estimatedUnits;
    }

    public void setEstimatedUnits(double estimatedUnits) {
        this.estimatedUnits = estimatedUnits;
    }
}