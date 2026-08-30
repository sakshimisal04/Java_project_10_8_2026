package com.powerwise.model;

import java.sql.Date;

public class Consumption {

    private int consumptionId;
    private int meterId;
    private double previousReading;
    private double currentReading;
    private double unitsConsumed;
    private String consumptionType;
    private Date readingDate;


    // =====================================================
    // DEFAULT CONSTRUCTOR
    // =====================================================

    public Consumption() {

    }


    // =====================================================
    // CONSTRUCTOR WITHOUT ID
    // =====================================================

    public Consumption(
            int meterId,
            double previousReading,
            double currentReading,
            double unitsConsumed,
            String consumptionType,
            Date readingDate) {

        this.meterId = meterId;
        this.previousReading = previousReading;
        this.currentReading = currentReading;
        this.unitsConsumed = unitsConsumed;
        this.consumptionType = consumptionType;
        this.readingDate = readingDate;
    }


    // =====================================================
    // CONSTRUCTOR WITH ID
    // =====================================================

    public Consumption(
            int consumptionId,
            int meterId,
            double previousReading,
            double currentReading,
            double unitsConsumed,
            String consumptionType,
            Date readingDate) {

        this.consumptionId = consumptionId;
        this.meterId = meterId;
        this.previousReading = previousReading;
        this.currentReading = currentReading;
        this.unitsConsumed = unitsConsumed;
        this.consumptionType = consumptionType;
        this.readingDate = readingDate;
    }


    // =====================================================
    // GETTERS AND SETTERS
    // =====================================================

    public int getConsumptionId() {
        return consumptionId;
    }

    public void setConsumptionId(int consumptionId) {
        this.consumptionId = consumptionId;
    }


    public int getMeterId() {
        return meterId;
    }

    public void setMeterId(int meterId) {
        this.meterId = meterId;
    }


    public double getPreviousReading() {
        return previousReading;
    }

    public void setPreviousReading(double previousReading) {
        this.previousReading = previousReading;
    }


    public double getCurrentReading() {
        return currentReading;
    }

    public void setCurrentReading(double currentReading) {
        this.currentReading = currentReading;
    }


    public double getUnitsConsumed() {
        return unitsConsumed;
    }

    public void setUnitsConsumed(double unitsConsumed) {
        this.unitsConsumed = unitsConsumed;
    }


    public String getConsumptionType() {
        return consumptionType;
    }

    public void setConsumptionType(String consumptionType) {
        this.consumptionType = consumptionType;
    }


    public Date getReadingDate() {
        return readingDate;
    }

    public void setReadingDate(Date readingDate) {
        this.readingDate = readingDate;
    }
}