package com.powerwise.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.powerwise.db.DBConnection;
import com.powerwise.model.Appliance;

public class ApplianceRepository {


    // =====================================================
    // CREATE
    // =====================================================

    public void addAppliance(Appliance appliance) {

        String sql = "INSERT INTO appliance "
                + "(user_id, appliance_name, quantity, "
                + "power_rating, hours_used_per_day, estimated_units) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(1, appliance.getUserId());

            ps.setString(
                    2,
                    appliance.getApplianceName()
            );

            ps.setInt(
                    3,
                    appliance.getQuantity()
            );

            ps.setDouble(
                    4,
                    appliance.getPowerRating()
            );

            ps.setDouble(
                    5,
                    appliance.getHoursUsedPerDay()
            );

            ps.setDouble(
                    6,
                    appliance.getEstimatedUnits()
            );


            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Appliance added successfully."
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

    public List<Appliance> getAllAppliances() {

        List<Appliance> appliances =
                new ArrayList<>();

        String sql = "SELECT * FROM appliance";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();


            while (rs.next()) {

                Appliance appliance =
                        new Appliance();

                appliance.setApplianceId(
                        rs.getInt("appliance_id")
                );

                appliance.setUserId(
                        rs.getInt("user_id")
                );

                appliance.setApplianceName(
                        rs.getString("appliance_name")
                );

                appliance.setQuantity(
                        rs.getInt("quantity")
                );

                appliance.setPowerRating(
                        rs.getDouble("power_rating")
                );

                appliance.setHoursUsedPerDay(
                        rs.getDouble("hours_used_per_day")
                );

                appliance.setEstimatedUnits(
                        rs.getDouble("estimated_units")
                );


                appliances.add(appliance);
            }


            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return appliances;
    }


    // =====================================================
    // UPDATE
    // =====================================================

    public void updateAppliance(
            Appliance appliance) {

        String sql =
                "UPDATE appliance SET "
                + "user_id = ?, "
                + "appliance_name = ?, "
                + "quantity = ?, "
                + "power_rating = ?, "
                + "hours_used_per_day = ?, "
                + "estimated_units = ? "
                + "WHERE appliance_id = ?";


        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);


            ps.setInt(
                    1,
                    appliance.getUserId()
            );

            ps.setString(
                    2,
                    appliance.getApplianceName()
            );

            ps.setInt(
                    3,
                    appliance.getQuantity()
            );

            ps.setDouble(
                    4,
                    appliance.getPowerRating()
            );

            ps.setDouble(
                    5,
                    appliance.getHoursUsedPerDay()
            );

            ps.setDouble(
                    6,
                    appliance.getEstimatedUnits()
            );

            ps.setInt(
                    7,
                    appliance.getApplianceId()
            );


            int rows = ps.executeUpdate();


            if (rows > 0) {

                System.out.println(
                        "Appliance updated successfully."
                );

            } else {

                System.out.println(
                        "Appliance not found."
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

    public void deleteAppliance(
            int applianceId) {

        String sql =
                "DELETE FROM appliance "
                + "WHERE appliance_id = ?";


        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);


            ps.setInt(
                    1,
                    applianceId
            );


            int rows =
                    ps.executeUpdate();


            if (rows > 0) {

                System.out.println(
                        "Appliance deleted successfully."
                );

            } else {

                System.out.println(
                        "Appliance not found."
                );
            }


            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}