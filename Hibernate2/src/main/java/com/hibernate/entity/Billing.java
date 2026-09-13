package com.hibernate.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "billing")
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billId;

    private int meterId;
    private double unitsConsumed;
    private double ratePerUnit;
    private double fixedCharge;
    private double totalAmount;
    private Date billingMonth;
    private Date dueDate;
    private String paymentStatus;

    // Default Constructor
    public Billing() {
    }

    // Constructor with ID
    public Billing(int billId, int meterId, double unitsConsumed,
                   double ratePerUnit, double fixedCharge,
                   double totalAmount, Date billingMonth,
                   Date dueDate, String paymentStatus) {

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

    // Constructor without ID
    public Billing(int meterId, double unitsConsumed,
                   double ratePerUnit, double fixedCharge,
                   double totalAmount, Date billingMonth,
                   Date dueDate, String paymentStatus) {

        this.meterId = meterId;
        this.unitsConsumed = unitsConsumed;
        this.ratePerUnit = ratePerUnit;
        this.fixedCharge = fixedCharge;
        this.totalAmount = totalAmount;
        this.billingMonth = billingMonth;
        this.dueDate = dueDate;
        this.paymentStatus = paymentStatus;
    }

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