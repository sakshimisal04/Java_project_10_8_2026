package com.powerwise.model;

import java.sql.Date;

public class Meter {

    private int meterId;
    private int userId;
    private String meterNumber;
    private String meterType;
    private Date installationDate;
    private double currentReading;

    public Meter() {
    }

    // Constructor without ID
    public Meter(int userId, String meterNumber, String meterType,
                 Date installationDate, double currentReading) {

        this.userId = userId;
        this.meterNumber = meterNumber;
        this.meterType = meterType;
        this.installationDate = installationDate;
        this.currentReading = currentReading;
    }

    // Constructor with ID
    public Meter(int meterId, int userId, String meterNumber,
                 String meterType, Date installationDate,
                 double currentReading) {

        this.meterId = meterId;
        this.userId = userId;
        this.meterNumber = meterNumber;
        this.meterType = meterType;
        this.installationDate = installationDate;
        this.currentReading = currentReading;
    }

    public int getMeterId() {
        return meterId;
    }

    public void setMeterId(int meterId) {
        this.meterId = meterId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMeterNumber() {
        return meterNumber;
    }

    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber;
    }

    public String getMeterType() {
        return meterType;
    }

    public void setMeterType(String meterType) {
        this.meterType = meterType;
    }

    public Date getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(Date installationDate) {
        this.installationDate = installationDate;
    }

    public double getCurrentReading() {
        return currentReading;
    }

    public void setCurrentReading(double currentReading) {
        this.currentReading = currentReading;
    }
}