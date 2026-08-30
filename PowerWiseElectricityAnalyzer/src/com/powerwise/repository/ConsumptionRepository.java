package com.powerwise.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.powerwise.db.DBConnection;
import com.powerwise.model.Consumption;

public class ConsumptionRepository {


    // =====================================================
    // CREATE
    // =====================================================

    public void addConsumption(Consumption c) {

        String sql =
                "INSERT INTO consumption "
                + "(meter_id, previous_reading, current_reading, "
                + "units_consumed, consumption_type, reading_date) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);


            ps.setInt(
                    1,
                    c.getMeterId()
            );

            ps.setDouble(
                    2,
                    c.getPreviousReading()
            );

            ps.setDouble(
                    3,
                    c.getCurrentReading()
            );

            ps.setDouble(
                    4,
                    c.getUnitsConsumed()
            );

            ps.setString(
                    5,
                    c.getConsumptionType()
            );

            ps.setDate(
                    6,
                    c.getReadingDate()
            );


            int rows =
                    ps.executeUpdate();


            if (rows > 0) {

                System.out.println(
                        "Consumption added successfully."
                );
            }


            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    // =====================================================
    // READ
    // =====================================================

    public List<Consumption> getAllConsumption() {

        List<Consumption> list =
                new ArrayList<>();

        String sql =
                "SELECT * FROM consumption";


        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();


            while (rs.next()) {

                Consumption c =
                        new Consumption();


                c.setConsumptionId(
                        rs.getInt("consumption_id")
                );

                c.setMeterId(
                        rs.getInt("meter_id")
                );

                c.setPreviousReading(
                        rs.getDouble("previous_reading")
                );

                c.setCurrentReading(
                        rs.getDouble("current_reading")
                );

                c.setUnitsConsumed(
                        rs.getDouble("units_consumed")
                );

                c.setConsumptionType(
                        rs.getString("consumption_type")
                );

                c.setReadingDate(
                        rs.getDate("reading_date")
                );


                list.add(c);
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
    // UPDATE
    // =====================================================

    public void updateConsumption(Consumption c) {

        String sql =
                "UPDATE consumption SET "
                + "meter_id=?, "
                + "previous_reading=?, "
                + "current_reading=?, "
                + "units_consumed=?, "
                + "consumption_type=?, "
                + "reading_date=? "
                + "WHERE consumption_id=?";


        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);


            ps.setInt(
                    1,
                    c.getMeterId()
            );

            ps.setDouble(
                    2,
                    c.getPreviousReading()
            );

            ps.setDouble(
                    3,
                    c.getCurrentReading()
            );

            ps.setDouble(
                    4,
                    c.getUnitsConsumed()
            );

            ps.setString(
                    5,
                    c.getConsumptionType()
            );

            ps.setDate(
                    6,
                    c.getReadingDate()
            );

            ps.setInt(
                    7,
                    c.getConsumptionId()
            );


            int rows =
                    ps.executeUpdate();


            if (rows > 0) {

                System.out.println(
                        "Consumption updated successfully."
                );

            } else {

                System.out.println(
                        "Consumption not found."
                );
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

    public void deleteConsumption(int consumptionId) {

        String sql =
                "DELETE FROM consumption "
                + "WHERE consumption_id=?";


        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);


            ps.setInt(
                    1,
                    consumptionId
            );


            int rows =
                    ps.executeUpdate();


            if (rows > 0) {

                System.out.println(
                        "Consumption deleted successfully."
                );

            } else {

                System.out.println(
                        "Consumption not found."
                );
            }


            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}