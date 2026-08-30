package com.powerwise.model;

public class Appliance {

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

    public Appliance(
            int userId,
            String applianceName,
            int quantity,
            double powerRating,
            double hoursUsedPerDay,
            double estimatedUnits) {

        this.userId = userId;
        this.applianceName = applianceName;
        this.quantity = quantity;
        this.powerRating = powerRating;
        this.hoursUsedPerDay = hoursUsedPerDay;
        this.estimatedUnits = estimatedUnits;
    }


    // Constructor with ID

    public Appliance(
            int applianceId,
            int userId,
            String applianceName,
            int quantity,
            double powerRating,
            double hoursUsedPerDay,
            double estimatedUnits) {

        this.applianceId = applianceId;
        this.userId = userId;
        this.applianceName = applianceName;
        this.quantity = quantity;
        this.powerRating = powerRating;
        this.hoursUsedPerDay = hoursUsedPerDay;
        this.estimatedUnits = estimatedUnits;
    }


    // Getter and Setter for applianceId

    public int getApplianceId() {

        return applianceId;
    }

    public void setApplianceId(int applianceId) {

        this.applianceId = applianceId;
    }


    // Getter and Setter for userId

    public int getUserId() {

        return userId;
    }

    public void setUserId(int userId) {

        this.userId = userId;
    }


    // Getter and Setter for applianceName

    public String getApplianceName() {

        return applianceName;
    }

    public void setApplianceName(String applianceName) {

        this.applianceName = applianceName;
    }


    // Getter and Setter for quantity

    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }


    // Getter and Setter for powerRating

    public double getPowerRating() {

        return powerRating;
    }

    public void setPowerRating(double powerRating) {

        this.powerRating = powerRating;
    }


    // Getter and Setter for hoursUsedPerDay

    public double getHoursUsedPerDay() {

        return hoursUsedPerDay;
    }

    public void setHoursUsedPerDay(double hoursUsedPerDay) {

        this.hoursUsedPerDay = hoursUsedPerDay;
    }


    // Getter and Setter for estimatedUnits

    public double getEstimatedUnits() {

        return estimatedUnits;
    }

    public void setEstimatedUnits(double estimatedUnits) {

        this.estimatedUnits = estimatedUnits;
    }
}