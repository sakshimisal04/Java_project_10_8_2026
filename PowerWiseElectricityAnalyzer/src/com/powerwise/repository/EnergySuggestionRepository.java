package com.powerwise.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.powerwise.db.DBConnection;
import com.powerwise.model.EnergySuggestion;

public class EnergySuggestionRepository {

    // =====================================================
    // ADD
    // =====================================================

    public void addEnergySuggestion(EnergySuggestion e) {

        String sql =
                "INSERT INTO energy_suggestion " +
                "(user_id, title, category, description, " +
                "recommended_action, estimated_saving) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, e.getUserId());
            ps.setString(2, e.getTitle());
            ps.setString(3, e.getCategory());
            ps.setString(4, e.getDescription());
            ps.setString(5, e.getRecommendedAction());
            ps.setDouble(6, e.getEstimatedSaving());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println(
                        "Energy suggestion added successfully."
                );
            }

            ps.close();
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // =====================================================
    // VIEW
    // =====================================================

    public List<EnergySuggestion> getAllEnergySuggestions() {

        List<EnergySuggestion> list = new ArrayList<>();

        String sql = "SELECT * FROM energy_suggestion";

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                EnergySuggestion e =
                        new EnergySuggestion();

                e.setSuggestionId(
                        rs.getInt("suggestion_id")
                );

                e.setUserId(
                        rs.getInt("user_id")
                );

                e.setTitle(
                        rs.getString("title")
                );

                e.setCategory(
                        rs.getString("category")
                );

                e.setDescription(
                        rs.getString("description")
                );

                e.setRecommendedAction(
                        rs.getString("recommended_action")
                );

                e.setEstimatedSaving(
                        rs.getDouble("estimated_saving")
                );

                list.add(e);
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;
    }

    // =====================================================
    // UPDATE
    // =====================================================

    public void updateEnergySuggestion(EnergySuggestion e) {

        String sql =
                "UPDATE energy_suggestion SET " +
                "user_id=?, " +
                "title=?, " +
                "category=?, " +
                "description=?, " +
                "recommended_action=?, " +
                "estimated_saving=? " +
                "WHERE suggestion_id=?";

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(
                    1,
                    e.getUserId()
            );

            ps.setString(
                    2,
                    e.getTitle()
            );

            ps.setString(
                    3,
                    e.getCategory()
            );

            ps.setString(
                    4,
                    e.getDescription()
            );

            ps.setString(
                    5,
                    e.getRecommendedAction()
            );

            ps.setDouble(
                    6,
                    e.getEstimatedSaving()
            );

            ps.setInt(
                    7,
                    e.getSuggestionId()
            );

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Energy suggestion updated successfully."
                );

            } else {

                System.out.println(
                        "Energy suggestion not found."
                );
            }

            ps.close();
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // =====================================================
    // DELETE
    // =====================================================

    public void deleteEnergySuggestion(int suggestionId) {

        String sql =
                "DELETE FROM energy_suggestion " +
                "WHERE suggestion_id=?";

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(1, suggestionId);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Energy suggestion deleted successfully."
                );

            } else {

                System.out.println(
                        "Energy suggestion not found."
                );
            }

            ps.close();
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}