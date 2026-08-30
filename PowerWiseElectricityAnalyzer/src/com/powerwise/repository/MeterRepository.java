package com.powerwise.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.powerwise.db.DBConnection;
import com.powerwise.model.Meter;

public class MeterRepository {

    // CREATE
    public void addMeter(Meter meter) {

        String sql = "INSERT INTO meter "
                + "(user_id, meter_number, meter_type, installation_date, current_reading) "
                + "VALUES (?, ?, ?, ?, ?)";

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, meter.getUserId());
            ps.setString(2, meter.getMeterNumber());
            ps.setString(3, meter.getMeterType());
            ps.setDate(4, meter.getInstallationDate());
            ps.setDouble(5, meter.getCurrentReading());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Meter added successfully.");
            }

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // READ
    public List<Meter> getAllMeters() {

        List<Meter> meters = new ArrayList<>();

        String sql = "SELECT * FROM meter";

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Meter meter = new Meter();

                meter.setMeterId(rs.getInt("meter_id"));
                meter.setUserId(rs.getInt("user_id"));
                meter.setMeterNumber(rs.getString("meter_number"));
                meter.setMeterType(rs.getString("meter_type"));
                meter.setInstallationDate(
                        rs.getDate("installation_date"));
                meter.setCurrentReading(
                        rs.getDouble("current_reading"));

                meters.add(meter);
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return meters;
    }


    // UPDATE
    public void updateMeter(Meter meter) {

        String sql = "UPDATE meter SET "
                + "user_id = ?, "
                + "meter_number = ?, "
                + "meter_type = ?, "
                + "installation_date = ?, "
                + "current_reading = ? "
                + "WHERE meter_id = ?";

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, meter.getUserId());
            ps.setString(2, meter.getMeterNumber());
            ps.setString(3, meter.getMeterType());
            ps.setDate(4, meter.getInstallationDate());
            ps.setDouble(5, meter.getCurrentReading());
            ps.setInt(6, meter.getMeterId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Meter updated successfully.");
            } else {
                System.out.println("Meter not found.");
            }

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // DELETE
    public void deleteMeter(int meterId) {

        String sql = "DELETE FROM meter WHERE meter_id = ?";

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, meterId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Meter deleted successfully.");
            } else {
                System.out.println("Meter not found.");
            }

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}