package com.powerwise.model;

import java.sql.Date;

public class Billing {

    private int billId;
    private int meterId;
    private double unitsConsumed;
    private double ratePerUnit;
    private double fixedCharge;
    private double totalAmount;
    private Date billingMonth;
    private Date dueDate;
    private String paymentStatus;


    // ==========================================
    // DEFAULT CONSTRUCTOR
    // ==========================================

    public Billing() {

    }


    // ==========================================
    // CONSTRUCTOR WITH ID
    // ==========================================

    public Billing(
            int billId,
            int meterId,
            double unitsConsumed,
            double ratePerUnit,
            double fixedCharge,
            double totalAmount,
            Date billingMonth,
            Date dueDate,
            String paymentStatus) {

        this.billId = billId;
        this.meterId = meterId;
        this.unitsConsumed = unitsConsumed;
        this.ratePerUnit = ratePerUnit;
        this.fixedCharge = fixedCharge;
        this.totalAmount = totalAmount;
        this.billingMonth = billingMonth;
        this.dueDate = dueDate;
        this.paymentStatus = paymentStatus;
    }


    // ==========================================
    // CONSTRUCTOR WITHOUT ID
    // ==========================================

    public Billing(
            int meterId,
            double unitsConsumed,
            double ratePerUnit,
            double fixedCharge,
            double totalAmount,
            Date billingMonth,
            Date dueDate,
            String paymentStatus) {

        this.meterId = meterId;
        this.unitsConsumed = unitsConsumed;
        this.ratePerUnit = ratePerUnit;
        this.fixedCharge = fixedCharge;
        this.totalAmount = totalAmount;
        this.billingMonth = billingMonth;
        this.dueDate = dueDate;
        this.paymentStatus = paymentStatus;
    }


    // ==========================================
    // GETTERS AND SETTERS
    // ==========================================

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }


    public int getMeterId() {
        return meterId;
    }

    public void setMeterId(int meterId) {
        this.meterId = meterId;
    }


    public double getUnitsConsumed() {
        return unitsConsumed;
    }

    public void setUnitsConsumed(double unitsConsumed) {
        this.unitsConsumed = unitsConsumed;
    }


    public double getRatePerUnit() {
        return ratePerUnit;
    }

    public void setRatePerUnit(double ratePerUnit) {
        this.ratePerUnit = ratePerUnit;
    }


    public double getFixedCharge() {
        return fixedCharge;
    }

    public void setFixedCharge(double fixedCharge) {
        this.fixedCharge = fixedCharge;
    }


    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }


    public Date getBillingMonth() {
        return billingMonth;
    }

    public void setBillingMonth(Date billingMonth) {
        this.billingMonth = billingMonth;
    }


    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }


    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}