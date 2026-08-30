package com.powerwise.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.powerwise.db.DBConnection;
import com.powerwise.model.Billing;

public class BillingRepository {

    // =====================================================
    // CREATE - ADD BILLING
    // =====================================================

    public void addBilling(Billing b) {

        String sql =
                "INSERT INTO billing " +
                "(meter_id, units_consumed, rate_per_unit, " +
                "fixed_charge, total_amount, billing_month, " +
                "due_date, payment_status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, b.getMeterId());

            ps.setDouble(2, b.getUnitsConsumed());

            ps.setDouble(3, b.getRatePerUnit());

            ps.setDouble(4, b.getFixedCharge());

            ps.setDouble(5, b.getTotalAmount());

            ps.setDate(6, b.getBillingMonth());

            ps.setDate(7, b.getDueDate());

            ps.setString(8, b.getPaymentStatus());

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Billing added successfully."
                );

            }

            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }


    // =====================================================
    // READ - VIEW ALL BILLING
    // =====================================================

    public List<Billing> getAllBilling() {

        List<Billing> list = new ArrayList<>();

        String sql = "SELECT * FROM billing";

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Billing b = new Billing();

                b.setBillId(
                        rs.getInt("bill_id")
                );

                b.setMeterId(
                        rs.getInt("meter_id")
                );

                b.setUnitsConsumed(
                        rs.getDouble("units_consumed")
                );

                b.setRatePerUnit(
                        rs.getDouble("rate_per_unit")
                );

                b.setFixedCharge(
                        rs.getDouble("fixed_charge")
                );

                b.setTotalAmount(
                        rs.getDouble("total_amount")
                );

                b.setBillingMonth(
                        rs.getDate("billing_month")
                );

                b.setDueDate(
                        rs.getDate("due_date")
                );

                b.setPaymentStatus(
                        rs.getString("payment_status")
                );

                list.add(b);
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return list;
    }


    // =====================================================
    // UPDATE - UPDATE BILLING
    // =====================================================

    public void updateBilling(Billing b) {

        String sql =
                "UPDATE billing SET " +
                "meter_id=?, " +
                "units_consumed=?, " +
                "rate_per_unit=?, " +
                "fixed_charge=?, " +
                "total_amount=?, " +
                "billing_month=?, " +
                "due_date=?, " +
                "payment_status=? " +
                "WHERE bill_id=?";

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(
                    1,
                    b.getMeterId()
            );

            ps.setDouble(
                    2,
                    b.getUnitsConsumed()
            );

            ps.setDouble(
                    3,
                    b.getRatePerUnit()
            );

            ps.setDouble(
                    4,
                    b.getFixedCharge()
            );

            ps.setDouble(
                    5,
                    b.getTotalAmount()
            );

            ps.setDate(
                    6,
                    b.getBillingMonth()
            );

            ps.setDate(
                    7,
                    b.getDueDate()
            );

            ps.setString(
                    8,
                    b.getPaymentStatus()
            );

            ps.setInt(
                    9,
                    b.getBillId()
            );

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Billing updated successfully."
                );

            } else {

                System.out.println(
                        "Bill not found."
                );
            }

            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }


    // =====================================================
    // DELETE - DELETE BILLING
    // =====================================================

    public void deleteBilling(int billId) {

        String sql =
                "DELETE FROM billing WHERE bill_id=?";

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(
                    1,
                    billId
            );

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Billing deleted successfully."
                );

            } else {

                System.out.println(
                        "Bill not found."
                );
            }

            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}